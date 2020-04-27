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
	private StateRepository stateRepository;

	@Autowired
	private StateMapper stateMapper;

	public List<StateDTO> getAll() {
		log.info("Listing all entries.");
		return stateMapper.mapResponse(stateRepository.findAll());
	}

	public StateDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return stateMapper.map(stateRepository.getOne(id));
	}

	public void saveSingle(StateDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		stateRepository.save(stateMapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		stateRepository.deleteById(id);
	}

}
