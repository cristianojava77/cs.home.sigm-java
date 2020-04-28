package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.CountryDTO;
import cs.home.sigm.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService service;

	@GetMapping
	public List<CountryDTO> getAll(@RequestParam String language) {
		return service.getAll(language);
	}

	@GetMapping("/single")
	public CountryDTO getSingle(@RequestParam Long code, @RequestParam String language) {
		return service.getSingle(code, language);
	}

	@GetMapping("/{id}")
	public CountryDTO getSingle(@PathVariable("id") Long id) {
		return service.getSingle(id);
	}

	@PostMapping
	public String saveSingle(@RequestBody CountryDTO request) {
		service.saveSingle(request);
		return "Request saved.";
	}

	@PostMapping("/delete/{id}")
	public String deleteSingle(@PathVariable("id") Long id) {
		service.deleteSingle(id);
		return "Request deleted.";
	}

}
