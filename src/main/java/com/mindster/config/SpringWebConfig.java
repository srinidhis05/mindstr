package com.mindster.config;

import com.mindster.DTO.JiraDto.JiraResponseDTO;
import com.mindster.DTO.MindsterDto.MindstrResponseMainDto;
import com.mindster.service.JiraService;
import com.mindster.service.MindstrService;
import com.mindster.service.MoztrapService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * Created by srinidhis on 16/12/16.
 */
@EnableWebMvc
@Configuration
@ComponentScan({"com.mindster.web"})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


    @Bean
    public JiraService jiraService(){return new JiraService();}

    @Bean
    public MoztrapService moztrapService(){return new MoztrapService();}

    @Bean
    public MindstrResponseMainDto mindstrResponseMainDto(){return new MindstrResponseMainDto();};

    @Bean
    public MindstrService mindstrService(){return new MindstrService();}

    @Bean
    public JiraResponseDTO jiraResponseDTO(){return new JiraResponseDTO();};
}
