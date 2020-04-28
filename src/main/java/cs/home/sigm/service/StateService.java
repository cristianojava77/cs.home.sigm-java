package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.StateDTO;
import cs.home.sigm.mapper.StateMapper;
import cs.home.sigm.repository.StateRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StateService {

	@Autowired
	private StateRepository repository;

	@Autowired
	private StateMapper mapper;

	public List<StateDTO> getAll(Long countrycode) {
		log.info("Listing all states for country code: {}.", countrycode);
		if (countrycode != null) {
			return mapper.mapResponse(repository.findAllByCountrycodeOrderByTitle(countrycode));
		}
		return mapper.mapResponse(repository.findAll());
	}

	public StateDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return mapper.map(repository.getOne(id));
	}

	public void saveSingle(StateDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		repository.save(mapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		repository.deleteById(id);
	}

}
