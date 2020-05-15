package cs.home.sigm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cs.home.sigm.adapter.domain.RelationshipDTO;
import cs.home.sigm.exception.InvalidRequestException;
import cs.home.sigm.mapper.RelationshipMapper;
import cs.home.sigm.service.RelationshipService;

@RequestMapping("/relationship")
@RestController
public class RelationshipController {

	@Autowired
	private RelationshipService service;

	@Autowired
	private RelationshipMapper mapper;

	@GetMapping("/single/{code}")
	public RelationshipDTO findSingle(@PathVariable Long code, @RequestParam String language) {
		return mapper.map(service.findSingle(language, code).orElseThrow(() -> new InvalidRequestException("Cannot find entry based on the received code.")));
	}

	@GetMapping
	public List<RelationshipDTO> findAll(@RequestParam String language) {
		return mapper.mapResponse(service.findAll(language));
	}

}
