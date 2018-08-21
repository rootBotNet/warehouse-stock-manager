package com.wacevazl.configuration.servlet;

import com.wacevazl.configuration.spring.WebFlowConfig;
import com.wacevazl.configuration.spring.WebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebInitializer() {
        super();
    }

    // API
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { WebMvcConfig.class, WebFlowConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void customizeRegistration(final ServletRegistration.Dynamic registration) {
        super.customizeRegistration(registration);
    }
}
