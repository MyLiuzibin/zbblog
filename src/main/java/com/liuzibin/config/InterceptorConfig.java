package com.liuzibin.config;

import com.liuzibin.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzibin
 * @date 2020/8/1
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public AuthInterceptor authInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList();
//        文章详情
        patterns.add("/api/port/v01/ArticleInfo");
//        用户登录
        patterns.add("/api/port/v01/loginUsers");
//        用户注册
        patterns.add("/api/port/v01/registerUsers");
//        文章列表
        patterns.add("/api/port/v01/ArticleList");
//        观看文章最多
        patterns.add("/api/port/v01/ArticleTop");
//        评论列表
        patterns.add("/api/port/v01/commentsList");




        registry.addInterceptor(authInterceptor()).addPathPatterns("/**").excludePathPatterns(patterns);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")// 允许跨域访问的路径
                .allowedOrigins("*")// 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")// 允许请求方法
                .maxAge(168000)// 预检间隔时间
                .allowedHeaders("*")// 允许头部设置
                .allowCredentials(true);// 是否发送cookie
    }
}
