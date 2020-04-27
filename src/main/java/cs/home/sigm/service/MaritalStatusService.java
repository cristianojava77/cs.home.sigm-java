package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.MaritalStatusDTO;
import cs.home.sigm.mapper.MaritalStatusMapper;
import cs.home.sigm.repository.MaritalStatusRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MaritalStatusService {

	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	@Autowired
	private MaritalStatusMapper maritalStatusMapper;

	public List<MaritalStatusDTO> getAll() {
		log.info("Listing all entries.");
		return maritalStatusMapper.mapResponse(maritalStatusRepository.findAll());
	}

	public MaritalStatusDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return maritalStatusMapper.map(maritalStatusRepository.getOne(id));
	}

	public void saveSingle(MaritalStatusDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		maritalStatusRepository.save(maritalStatusMapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		maritalStatusRepository.deleteById(id);
	}

}
