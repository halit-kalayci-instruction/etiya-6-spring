package com.etiya.ecommercedemo;

import com.etiya.ecommercedemo.core.exceptions.BusinessException;
import com.etiya.ecommercedemo.core.utils.result.ErrorResult;
import com.etiya.ecommercedemo.core.utils.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		// Veritabanı?
		// Dosya
		// API
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename("messages");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver(){
		// Clientdan seçili dili hangi yöntemle almalıyım?
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();

		// Dil gönderilmemişse hangi dili baz alayım?
		acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));

		return acceptHeaderLocaleResolver;
	}

	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}

	@ExceptionHandler({BusinessException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result handleBusinessException(BusinessException exception)
	{
		return new ErrorResult(exception.getMessage());
	}

	// TODO
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Object handleValidationException(MethodArgumentNotValidException exception){
		// gelen exceptiondaki validasyon hatalarını oku liste olarak kullanıcıya göster
		Map<String,String>  errors = new HashMap<>();

		for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		// DATA
		// Validasyon hataları mevcut.
		return errors;
	}

}
// Unit Test => Mock, Business Kodlar (SALI)