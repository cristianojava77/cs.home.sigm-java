package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.StateDTO;
import cs.home.sigm.mapper.StateMapper;
import cs.home.sigm.service.StateService;

@RequestMapping("/state")
@RestController
public class StateController {

	@Autowired
	private StateService stateService;

	@Autowired
	private StateMapper mapper;

	@GetMapping
	public List<StateDTO> getAll(@RequestParam Long countrycode) {
		return mapper.mapResponse(stateService.findAll(countrycode));
	}

	@GetMapping("/{id}")
	public StateDTO getSingle(@PathVariable("id") Long id) {
		return mapper.map(stateService.getOne(id));
	}

}
