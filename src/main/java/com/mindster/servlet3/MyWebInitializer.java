package com.mindster.servlet3;

import com.mindster.config.SpringWebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by srinidhis on 16/12/16.
 */
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] { SpringWebConfig.class };
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] { "/" };
        }

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return null;
        }

    }

