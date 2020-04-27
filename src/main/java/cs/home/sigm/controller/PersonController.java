package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.PersonDTO;
import cs.home.sigm.service.PersonService;

@RequestMapping("/person")
@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public List<PersonDTO> getAll() {
		return personService.getAll();
	}

	@GetMapping("/{id}")
	public PersonDTO getSingle(@PathVariable("id") Long id) {
		return personService.getSingle(id);
	}

	@PostMapping
	public String saveSingle(@RequestBody PersonDTO request) {
		personService.saveSingle(request);
		return "Request saved.";
	}

	@PostMapping("/delete/{id}")
	public String deleteSingle(@PathVariable("id") Long id) {
		personService.deleteSingle(id);
		return "Request deleted.";
	}

}
