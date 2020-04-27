package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.RelationshipDTO;
import cs.home.sigm.service.RelationshipService;

@RequestMapping("/relationship")
@RestController
public class RelationshipController {

	@Autowired
	private RelationshipService relationshipService;

	@GetMapping
	public List<RelationshipDTO> getAll() {
		return relationshipService.getAll();
	}

	@GetMapping("/{id}")
	public RelationshipDTO getSingle(@PathVariable("id") Long id) {
		return relationshipService.getSingle(id);
	}

	@PostMapping
	public String saveSingle(@RequestBody RelationshipDTO request) {
		relationshipService.saveSingle(request);
		return "Request saved.";
	}

	@PostMapping("/delete/{id}")
	public String deleteSingle(@PathVariable("id") Long id) {
		relationshipService.deleteSingle(id);
		return "Request deleted.";
	}

}
