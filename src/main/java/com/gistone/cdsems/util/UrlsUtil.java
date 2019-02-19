package com.gistone.cdsems.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class UrlsUtil {
	
	@Autowired
	private ConfigUtil configUtil;
	
	public String geturl() {
		//获取当前类的物理路径
        //debug：“file:/D:/work/201711/nrme/target/classes/com/gistone/nrme/util/UrlsUtil.class”
        //production:“file:E:/apache-tomcat-8.5.8-80-nrme/webapps/nrme/WEB-INF/classes/com/gistone/nrme/util/UrlsUtil.class”
		String classFilePath = this.getClass().getResource("UrlsUtil.class").toString();
		
		String urlFile = "";
		
		String status=configUtil.getRunningStatus();
		if (!status.equals("debug")) {
				urlFile = classFilePath.substring(6,
						classFilePath.indexOf(configUtil.getWebAppName())
						+ configUtil.getWebAppName().length()
						)+"WEB-INF/classes/WebRoot/";
			
		} else {
				urlFile = classFilePath.substring(6,classFilePath.indexOf("classes/") + 8)
						+ "WebRoot/";
		}
		return urlFile;
		
		/*String classFilePath = this.getClass().getResource("UrlsUtil.class").toString();
		String urlFile = "";
		String status=configUtil.getRunningStatus();
		if (!status.equals("debug")) {
				urlFile = classFilePath.substring(6,
						classFilePath.indexOf(configUtil.getWebAppName())
						+ configUtil.getWebAppName().length()
						);
			
		} else {
				urlFile = classFilePath.substring(6,classFilePath.indexOf("classes/") + 8)
						+ "META-INF/resources/";
		}
		return urlFile;*/
	}
	
}
