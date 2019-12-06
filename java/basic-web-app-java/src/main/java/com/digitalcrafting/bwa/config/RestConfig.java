package com.digitalcrafting.bwa.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import java.util.concurrent.TimeUnit;

@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = "com.digitalcrafting.bwa")
public class RestConfig implements WebMvcConfigurer {

    private final Environment env;

    public RestConfig(Environment env) {
        this.env = env;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebContentInterceptor interceptor = new WebContentInterceptor();
        interceptor.setCacheControl(CacheControl.maxAge(0, TimeUnit.NANOSECONDS).cachePrivate().mustRevalidate());
        registry.addInterceptor(interceptor);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /* Only for dev */
        if (env.getProperty("config.debug.allow.cors", "false").equals("true")) {
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowCredentials(true);
        }
    }
}
