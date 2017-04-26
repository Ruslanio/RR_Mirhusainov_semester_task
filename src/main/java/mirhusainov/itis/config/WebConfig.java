package mirhusainov.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by Ruslan on 26.04.2017.
 */
@Configuration
@EnableWebMvc
@ComponentScan("mirhusainov.itis.controllers")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public FreeMarkerViewResolver fmResolver(){
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html;charset=UTF-8");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer fmConfigurer(){
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setDefaultEncoding("UTF-8");
        configurer.setTemplateLoaderPath("WEB-INF/view/");
        return configurer;
    }

    @Bean
    @Autowired
    public freemarker.template.Configuration fmConfiguration(FreeMarkerConfig freeMarkerConfig){
        return freeMarkerConfig.getConfiguration();
    }
}
