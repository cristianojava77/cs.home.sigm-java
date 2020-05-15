package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.CountryDTO;
import cs.home.sigm.exception.InvalidRequestException;
import cs.home.sigm.mapper.CountryMapper;
import cs.home.sigm.service.CountryService;

@RestController
@RequestMapping(value = "/country", produces = { MediaType.APPLICATION_JSON_VALUE })
public class CountryController {

	@Autowired
	private CountryService service;

	@Autowired
	private CountryMapper mapper;

	@GetMapping("/single/{code}")
	public CountryDTO findSingle(@PathVariable Long code, @RequestParam String language) {
		return mapper.map(service.findSingle(language, code).orElseThrow(() -> new InvalidRequestException("Cannot find entry based on the received code.")));
	}

	@GetMapping
	public List<CountryDTO> findAll(@RequestParam String language) {
		return mapper.mapResponse(service.findAll(language));
	}

	@PostMapping
	public String saveEntry(@RequestBody CountryDTO request) {
		service.save(mapper.map(request));
		return "Saved successfully";
	}

	@PostMapping("/delete/{id}")
	public String deleteEntry(@PathVariable("id") Long id) {
		service.deleteSingle(id);
		return "Request deleted.";
	}

}
