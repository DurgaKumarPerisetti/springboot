package com.spring.learn.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping(path = "/filtering")
	public TestBean bean() {
		return new TestBean("Value 1", "Value 2", "Value 3");

	}

	@GetMapping(path = "/filteringlist")
	public List<TestBean> beanList() {
		return Arrays.asList(new TestBean("Value 1", "Value 2", "Value 3"),
				new TestBean("Value 4", "Value 5", "Value 6"));

	}

}
