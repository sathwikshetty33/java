package com.example.demo;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<VisitCounterServlet> visitCounterServlet() {
        return new ServletRegistrationBean<>(new VisitCounterServlet(), "/visit-counter");
    }
}