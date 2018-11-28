package com.pluto.wservice.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.*;
import javax.servlet.ServletException;


@Configuration
@EnableWebMvc
@ComponentScan("com.pluto.wservice")
public class AppConfig implements WebApplicationInitializer
{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {


        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext =
                new AnnotationConfigWebApplicationContext();

        rootContext.register(AppConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher1", new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }


}
