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

import cs.home.sigm.adapter.domain.MaritalStatusDTO;
import cs.home.sigm.service.MaritalStatusService;

@RequestMapping("/maritalstatus")
@RestController
public class MaritalStatusController {

	@Autowired
	private MaritalStatusService service;

	@GetMapping
	public List<MaritalStatusDTO> getAll(@RequestParam String language) {
		return service.getAll(language);
	}

	@GetMapping("/single")
	public MaritalStatusDTO getSingle(@RequestParam Long code, @RequestParam String language) {
		return service.getSingle(code, language);
	}

	@GetMapping("/{id}")
	public MaritalStatusDTO getSingle(@PathVariable("id") Long id) {
		return service.getSingle(id);
	}

	@PostMapping
	public String saveSingle(@RequestBody MaritalStatusDTO request) {
		service.saveSingle(request);
		return "Request saved.";
	}

	@PostMapping("/delete/{id}")
	public String deleteSingle(@PathVariable("id") Long id) {
		service.deleteSingle(id);
		return "Request deleted.";
	}

}
