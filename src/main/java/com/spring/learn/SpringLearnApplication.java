package com.spring.learn;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		// SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;

	}

	/**
	 * This Method is used to set the base name for the
	 * ResourceBundleMessageSource. The same can be achieved by setting the base
	 * name in application.properties files if we set it in
	 * application.properties files we no need to write this code in this place.
	 * So we can remove it or comment it here.
	 * 
	 * @return
	 */
	@Bean
	public ResourceBundleMessageSource resourceMessage() {
		ResourceBundleMessageSource resourceMessage = new ResourceBundleMessageSource();
		resourceMessage.setBasename("messages");
		return resourceMessage;

	}

}
