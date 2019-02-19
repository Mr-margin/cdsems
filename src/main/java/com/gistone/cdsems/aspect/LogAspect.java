package com.gistone.cdsems.aspect;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import javax.websocket.Session;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gistone.cdsems.database.entity.SysLog;
import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.service.sys.SysLogService;
import com.gistone.cdsems.util.EdatResult;
import com.gistone.cdsems.util.RequestIPUtils;


/**
 * 日志记录切面
 */
@Aspect
@Component
@SuppressWarnings("all")
public class LogAspect {

	@Autowired
	private SysLogService sysLogService;
	
	//切入点表达式
	@Pointcut("execution(* com.gistone.cdsems.service.*.*.save*(..))")  
	public void saveCell(){
    }
	
	//切入点表达式
	@Pointcut("execution(* com.gistone.cdsems.service.*.*.update*(..))")  
	public void updateCell(){
    }
	
	//切入点表达式
	@Pointcut("execution(* com.gistone.cdsems.service.*.*.delete*(..))")  
	public void deleteCell(){
    }
	
	//切入点表达式
	@Pointcut("execution(* com.gistone.cdsems.service.*.*.login*(..))")  
	public void loginCell(){
    }
	
	//切入点表达式
	@Pointcut("execution(* com.gistone.cdsems.service.*.*.logout*(..))")  
	public void logoutCell(){
    }
	
	//后置通知
	@AfterReturning(value = "saveCell()", argNames = "object", returning = "object")  
    public void saveLog(JoinPoint joinPoint, Object object) throws Throwable {  
		if(object!=null){
			saveLogInfo(joinPoint, object, 3);
		}
//        System.out.println("tongzhi");
    }
	
	//后置通知
	@AfterReturning(value = "updateCell()", argNames = "object", returning = "object")  
    public void updateLog(JoinPoint joinPoint, Object object) throws Throwable {  
		if(object!=null){
			saveLogInfo(joinPoint, object, 4);
		}
//        System.out.println("tongzhi");
    }
	
	//后置通知
	@AfterReturning(value = "deleteCell()", argNames = "object", returning = "object")  
    public void deleteLog(JoinPoint joinPoint, Object object) throws Throwable {  
		if(object!=null){
			saveLogInfo(joinPoint, object, 5);
		}
//        System.out.println("tongzhi");
    }
	
	//后置通知
	@AfterReturning(value = "loginCell()", argNames = "object", returning = "object")  
    public void loginLog(JoinPoint joinPoint, Object object) throws Throwable {  
		if(object!=null){
			saveLogInfo(joinPoint, object, 1);
		}
//        System.out.println("tongzhi");
    }
	
	//后置通知
	@AfterReturning(value = "logoutCell()", argNames = "object", returning = "object")  
    public void logoutLog(JoinPoint joinPoint, Object object) throws Throwable {  
		if(object!=null){
			saveLogInfo(joinPoint, object, 2);
		}
//        System.out.println("tongzhi");
    }
	
	private void saveLogInfo (JoinPoint joinPoint, Object object, int logType){
		
		//返回值获取日志内容
		EdatResult edatResult = (EdatResult)object;
		//日志内容
		String logContent = edatResult.getLogContent();
		
		//获取session
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		SysUser sysUser = (SysUser)session.getAttribute("sysUser");
		if(sysUser!=null && logContent!=null && logContent!=""){
			BigDecimal suId = sysUser.getSuId();
			
			//用户ip
			String ipStr = RequestIPUtils.getIpAddress(request);
			
			//时间
			DateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			
			SysLog sysLog = new SysLog();
			sysLog.setSlContent(logContent);
			sysLog.setSlSltId(new BigDecimal(logType));
			sysLog.setSlSuId(suId);
			sysLog.setSlIp(ipStr);
			
			//save log
			sysLogService.insertSelective(sysLog);
//			System.out.println();
		}
	}
	
	//切入点表达式
	@Pointcut("execution(* com.gistone.dlsthx.service.*.*.test*(..))")  
	public void testCell(){
    }
	
	//后置通知
	@AfterReturning(value = "testCell()", argNames = "object", returning = "object")  
    public void testLog(JoinPoint joinPoint, Object object) throws Throwable {  
		if(object!=null){
			//返回值获取日志内容
//			Result result = (Result)object;
			//日志内容
//			String logContent = result.getLogContent();
			
			//获取session
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			System.out.println();
		}
        System.out.println("tongzhi");
    }
	
	 /** 
     * 使用Java反射来获取被拦截方法(insert、update)的参数值， 将参数值拼接为操作内容 
     */  
    public String optionContent(Object[] args, String mName) {  
        if (args == null) {  
            return null;  
        }  
        StringBuffer rs = new StringBuffer();  
        rs.append(mName);  
        String className = null;  
        int index = 1;  
        // 遍历参数对象  
        for (Object info : args) {  
            // 获取对象类型  
            className = info.getClass().getName();  
            className = className.substring(className.lastIndexOf(".") + 1);  
            rs.append("[参数" + index + "，类型:" + className + "，值:");  
            // 获取对象的所有方法  
            Method[] methods = info.getClass().getDeclaredMethods();  
            // 遍历方法，判断get方法  
            for (Method method : methods) {  
                String methodName = method.getName();  
                // 判断是不是get方法  
                if (methodName.indexOf("get") == -1) {// 不是get方法  
                    continue;// 不处理  
                }  
                Object rsValue = null;  
                try {  
                    // 调用get方法，获取返回值  
                    rsValue = method.invoke(info);  
                } catch (Exception e) {  
                    continue;  
                }  
                // 将值加入内容中  
                rs.append("(" + methodName + ":" + rsValue + ")");  
            }  
            rs.append("]");  
            index++;  
        }  
        return rs.toString();  
    }  
}
