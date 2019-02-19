package com.gistone.cdsems.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gistone.cdsems.database.entity.SysUser;
import com.gistone.cdsems.util.CheckSensitiveStringUtil;

@WebFilter(urlPatterns = "/*")  
public class MyFilter implements Filter {
	
	protected static List<String> patterns = new ArrayList<String>();
	
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
    	patterns.add("login.html");
    	patterns.add("qrcode.html");
    	patterns.add("qrcode_next.html");
    	patterns.add(".css");
    	patterns.add(".js");
    	patterns.add(".png");
    	patterns.add("loginUser");
    	patterns.add("getCheckCode");
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
    	HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        
        String url=httpServletRequest.getRequestURI();
        
        if (isInclude(url)){
        	//放行
        	filterChain.doFilter(request, response);
        }else{
        	///获取当前登录用户
        	SysUser user = (SysUser) httpServletRequest.getSession().getAttribute("sysUser");
        	//拦截后判断当前登录用户是否有效
    		if (user!=null) {
    			filterChain.doFilter(request, response);
        	}else{
        		//使用路由用这种拼接js进行跳转
    			PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
				builder.append("window.top.location.href=\"");
				String path = httpServletRequest.getContextPath()+"/login.html";
//				String path = configUtil.getServerPath()+"/login.html";
				builder.append(path);
				builder.append("\";</script>");
				response.setContentType("text/html;charset=utf-8");
				out.print(builder.toString());
				out.close();
				//使用Html的时候直接使用response跳转即可
    			//httpServletResponse.sendRedirect(configUtil.getServerPath()+"/login.html");
					
        	}
        }
    }
  
    @Override  
    public void destroy() {  
  
    }
    
    private boolean isInclude(String url) {
        for (String pattern : patterns) {
            if (url.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}  
