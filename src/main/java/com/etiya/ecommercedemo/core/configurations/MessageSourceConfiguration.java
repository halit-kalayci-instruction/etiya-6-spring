package com.etiya.ecommercedemo.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfiguration {
    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        // Veritabanı?
        // Dosya
        // API
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename("messages");
        return messageSource;
    }

    // Kullanıcıdan kullanmak istediği dili nasıl konfigüre etmeli?

    @Bean
    public LocaleResolver localeResolver(){
        // Clientdan seçili dili hangi yöntemle almalıyım?
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

        // Dil gönderilmemişse hangi dili baz alayım?
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));

        return acceptHeaderLocaleResolver;
    }
}
