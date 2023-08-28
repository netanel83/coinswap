package com.coinswap.config;

import com.coinswap.constant.CommonStatus;
import com.coinswap.constant.SysAdvertiseLocation;
import com.coinswap.converter.OrdinalToEnumConverter;
import com.coinswap.interceptor.MemberInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@Configuration
public class ApplicationConfig implements WebFluxConfigurer {

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getMessageSource(){
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setBasenames("i18n","i18n/ValidationMessages");
        resourceBundleMessageSource.setCacheSeconds(3600);
        return resourceBundleMessageSource;
    }
    @Override
    public Validator getValidator(){
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(getMessageSource());
        return validator;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/asset/**").addResourceLocations("classpath:/asset/");
    }
    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new OrdinalToEnumConverter<>(CommonStatus.class));
        registry.addConverter(new OrdinalToEnumConverter<> (SysAdvertiseLocation.class));
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new MemberInterceptor());
//    }




}
