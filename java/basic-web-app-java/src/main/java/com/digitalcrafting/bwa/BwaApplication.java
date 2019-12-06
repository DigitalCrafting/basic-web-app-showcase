package com.digitalcrafting.bwa;

import com.digitalcrafting.bwa.config.RestConfig;
import com.digitalcrafting.bwa.config.WebStaticConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableAspectJAutoProxy
public class BwaApplication implements WebApplicationInitializer {

    private final Logger logger = LogManager.getLogger(BwaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(BwaApplication.class, args);
    }

    @Override
    public void onStartup(ServletContext servletContext) {
        logger.info("Starting initialization");
        AnnotationConfigWebApplicationContext webRestConfig = new AnnotationConfigWebApplicationContext();
        webRestConfig.register(RestConfig.class);
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher-rest", new DispatcherServlet(webRestConfig));
        registration.setLoadOnStartup(1);
        registration.addMapping("/api/*");

        AnnotationConfigWebApplicationContext webStaticConfig = new AnnotationConfigWebApplicationContext();
        webStaticConfig.register(WebStaticConfig.class);
        ServletRegistration.Dynamic registration2 = servletContext.addServlet("dispatcher-web-static", new DispatcherServlet(webStaticConfig));
        registration2.setLoadOnStartup(1);
        registration2.addMapping("/*");
        logger.info("Finished initialization");
    }
}
