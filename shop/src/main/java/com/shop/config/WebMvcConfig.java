package com.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${uploadPath}")
    String uploadPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //웹브라우저에 입력하는 url에 /images로 시작하는 경우
        //uploadPath에 설정한 폴더를 기준으로 파일을 읽어오도록 설정
        registry.addResourceHandler("/images/**")
                .addResourceLocations(uploadPath);
        //로컬 컴퓨터에 저장된 파일을 읽어 올 root경로를 설정
    }
}
