package com.spring.learn.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello" )
	public String helloWorld() {
		return "Hello From Spring Boot Web Services";
	}
	
	@GetMapping(path = "/helloget" )
	public String helloWorldWithGetMapping() {
		return "Hello From Spring Boot Web Services with Get Mapping";
	}
	
	@GetMapping(path = "/hellobean" )
	public HelloWorldBean helloWorldWithBean() {
		return new HelloWorldBean("This is a message returned from Bean");
	}
	
	@GetMapping(path = "/hellobean/{name}" )
	public HelloWorldBean helloWorldWithPathVariable(@PathVariable("name") String name) {
		return new HelloWorldBean("Hello  " + name);
	}
	
	@GetMapping(path = "/helloglobal" )
	public String helloInternational(@RequestHeader (name = "Accept-Languate", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping(path = "/hellogloballocalecontext" )
	public String helloInternationalWithAutoLocale() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping(path = "/helloboot" )
	public String helloWorldFromEC2() {
		return "Hello From Spring Boot Web Services with Added for EC2 Testing";
	}
	

}
