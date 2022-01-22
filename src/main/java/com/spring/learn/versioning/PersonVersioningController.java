package com.spring.learn.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping("/v1/person")
	public PersonV1 personV1() {
		return new PersonV1("DurgaKumar");
	}

	@GetMapping("/v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("DurgaKumar", "Perisetti"));

	}
	
	@GetMapping(path = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("DurgaKumar");
	}

	@GetMapping(path = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("DurgaKumar", "Perisetti"));

	}
	
	@GetMapping(path = "/person/header", headers = "X_API_VERSION=1")
	public PersonV1 headerVersionV1() {
		return new PersonV1("DurgaKumar");
	}

	@GetMapping(path = "/person/header", headers = "X_API_VERSION=2")
	public PersonV2 headerVersionV2() {
		return new PersonV2(new Name("DurgaKumar", "Perisetti"));

	}
	
	@GetMapping(path = "/person/produce", produces = "application/v1+json")
	public PersonV1 produceV1() {
		return new PersonV1("DurgaKumar");
	}

	@GetMapping(path = "/person/produce", produces = "application/v2+json")
	public PersonV2 produceV2() {
		return new PersonV2(new Name("DurgaKumar", "Perisetti"));

	}
}
