package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.StateDTO;
import cs.home.sigm.service.StateService;

@RequestMapping("/state")
@RestController
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public List<StateDTO> getAll() {
		return stateService.getAll();
	}

	@GetMapping("/{id}")
	public StateDTO getSingle(@PathVariable("id") Long id) {
		return stateService.getSingle(id);
	}

	@PostMapping
	public String saveSingle(@RequestBody StateDTO request) {
		stateService.saveSingle(request);
		return "Request saved.";
	}

	@PostMapping("/delete/{id}")
	public String deleteSingle(@PathVariable("id") Long id) {
		stateService.deleteSingle(id);
		return "Request deleted.";
	}

}
