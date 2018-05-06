package com.imooc.backstage.aspect;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * CORS跨域
 */
@Configuration
public class MyWebAppConfigurer  extends WebMvcConfigurerAdapter{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");//全部
        
/*        registry.addMapping("/api/**")
        .allowedOrigins("http://192.168.1.97")
        .allowedMethods("GET", "POST")
        .allowCredentials(false).maxAge(3600);
*/    }
}
