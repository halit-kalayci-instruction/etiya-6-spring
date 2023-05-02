package com.etiya.ecommercedemo.core.internationalization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

@Service
public class MessageManager implements MessageService {
    private MessageSource messageSource;

    @Autowired
    public MessageManager(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String keyword) {
        return messageSource.getMessage(keyword,null, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessageWithParams(String keyword, Object... params) {
        return messageSource.getMessage(keyword,params,LocaleContextHolder.getLocale());
    }
}
