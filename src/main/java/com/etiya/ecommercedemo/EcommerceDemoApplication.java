package com.etiya.ecommercedemo;

import com.etiya.ecommercedemo.core.exceptions.BusinessException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoApplication.class, args);
	}

	@ExceptionHandler({BusinessException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleBusinessException(BusinessException exception)
	{
		return "HATA";
	}

}
