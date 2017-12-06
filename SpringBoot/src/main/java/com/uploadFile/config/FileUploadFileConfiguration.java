package com.uploadFile.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUploadFileConfiguration {
	// 可以直接在配置文件里面进行配置,间application.yml
    /*@Bean
	public MultipartConfigElement mutipartConfigElement(){
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//最大文件大小
		factory.setMaxFileSize("5MB");//KB MB
		//设置总上传数据总大小 
		factory.setMaxRequestSize("10MB");
		return factory.createMultipartConfig();
	}*/
}
