package com.gistone.cdsems.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource(value = "classpath:/config.properties")
/**
 * 路径帮助类
 * 
 * @author WangShanxi
 */
public class ConfigUtil {

	
	@Value("${RunningStatus}")
	private String RunningStatus;
	
	@Value("${webAppName}")
	private String webAppName;
//
//	@Value("${ServerPath}")
//	private String serverPath;
//
//	public String getServerPath() {
//		return serverPath;
//	}
//	@Value("${ThePath}")
//	private String ThePath;
//	public String getThePath() {
//		return ThePath;
//	}
	
	public String getRunningStatus() {
		return RunningStatus;
	}
	
	public String getWebAppName() {
		return webAppName;
	}
	
	
}
