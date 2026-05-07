package com.url.shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UrlShortenerSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerSbApplication.class, args);
	}

}
