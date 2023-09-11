package org.example.config;

import org.example.converter.AuthorConverter;
import org.example.converter.CategoryConverter;
import org.example.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthorConverter authorConverter;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(authorConverter);
        registry.addConverter(categoryConverter);
    }

}
