package com.spring.learn.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFiltering {

	@GetMapping(path = "/dynamicfilter")
	public MappingJacksonValue bean() {

		SampleBean sampleBean = new SampleBean("Venkat", "Chumma", "Durga");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("val1", "val2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SampleBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(sampleBean);
		mapping.setFilters(filters);
		return mapping;

	}

	@GetMapping(path = "/dynamicfilterlist")
	public MappingJacksonValue beanList() {

		List<SampleBean> list =  Arrays.asList(new SampleBean("Durga", "Chumma", "Perisetti"),
				new SampleBean("Venkat", "Chumma", "Kumar"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("val2", "val3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SampleBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;

	}

}
