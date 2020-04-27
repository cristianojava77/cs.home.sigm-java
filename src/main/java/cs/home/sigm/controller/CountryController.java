package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.CountryDTO;
import cs.home.sigm.service.CountryService;

@RequestMapping("/country")
@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping
	public List<CountryDTO> getAll() {
		return countryService.getAll();
	}

	@GetMapping("/{id}")
	public CountryDTO getSingle(@PathVariable("id") Long id) {
		return countryService.getSingle(id);
	}

	@PostMapping
	public String saveSingle(@RequestBody CountryDTO request) {
		countryService.saveSingle(request);
		return "Request saved.";
	}

	@PostMapping("/delete/{id}")
	public String deleteSingle(@PathVariable("id") Long id) {
		countryService.deleteSingle(id);
		return "Request deleted.";
	}

}
