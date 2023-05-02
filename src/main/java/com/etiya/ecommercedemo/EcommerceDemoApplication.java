package com.etiya.ecommercedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoApplication.class, args);
	}
}
// Many-To-Many
// Ana dosya refactorü
// Multi-language args
// Validation handler ve messageSource
// Sayfalama


// Önemli Sunum notları:
// Defensive programming => uygulamamınız yönetemediği hiç bir user input olmamalı
// Tüm listelemelerde sayfalama!!
// Magic string kullanmamak
// Multi-language