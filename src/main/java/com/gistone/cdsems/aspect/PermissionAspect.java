package com.gistone.cdsems.aspect;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import com.gistone.cdsems.database.entity.SysRole;
import com.gistone.cdsems.database.entity.SysRoleModule;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.util.EdatResult;


/**
 * 权限验证切面
 */
@Aspect
@Component
@SuppressWarnings("all")
public class PermissionAspect {
	
	//声明一个切入点,切入点的名称其实是一个方法
	@Pointcut("execution (* com.gistone.cdsems.service.*.*.*(..))")
    private void anyMethod(){}

	 //环绕通知（特别适合做权限系统）
    @Around("anyMethod()")
	public Object doBasicProfiling(ProceedingJoinPoint joinPoint) throws Throwable{
    	Signature signature = joinPoint.getSignature();
    	MethodSignature methodSignature = (MethodSignature)signature;
    	Method method = methodSignature.getMethod();
    	//对于MyPermission注解的方法进行权限验证
    	Boolean isHaveMyPermission = method.isAnnotationPresent(MyPermission.class);
    	if(isHaveMyPermission){
    		//获取注解对象
    		MyPermission myPermission = method.getAnnotation(MyPermission.class);
    		String value = myPermission.value();
    		if(value.equals("yes")){
    			//获取session
    			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    			ServletWebRequest servletWebRequest = new ServletWebRequest(request);
    			HttpServletResponse response = servletWebRequest.getResponse();
    			HttpSession session = request.getSession();
    			//从注解中获取信息
    			String module = myPermission.module();
    			//
    			int type = myPermission.type();
    			
    			//验证
    			if(checkModule(session, module, type)){
    				//验证通过，执行方法
    	    		Object object = joinPoint.proceed();
    	    		return object;
    			}else{
    				return EdatResult.error(1007, "没有权限！");
    			}
    		}
    	}else{
    		//执行方法
    		Object object = joinPoint.proceed();
    		return object;
    	}
    	
		return null;
	}
    
    private boolean checkModule(HttpSession session, String module, int type){
    	boolean flag = false;
    	//获取权限
    	if(type==1){
	    	SysUser sysUser = (SysUser)session.getAttribute("sysUser");
	    	if(sysUser.getSuSysRole()!=null){
	    		//角色
	    		SysRole sysRole = sysUser.getSuSysRole();
		    	if(sysRole.getSrSysRoleModule()!=null){
		    		//角色权限中间表
			  		List<SysRoleModule> sysRoleModules = sysRole.getSrSysRoleModule();
			  		//遍历用户角色 的角色模块中间表
			  		for (SysRoleModule sysRoleModule : sysRoleModules) {
			  			String[] moduleStr = module.split(",");
			  			//遍历接口权限字符串
			  			for (String currModule : moduleStr) {
			  				if(currModule.equals(sysRoleModule.getSrmSmId().toString())){
				  				flag = true;
				  				return flag;
				  			}
						}
					}
			  	}
	    	}
    	}
    	return flag;
    }
}
