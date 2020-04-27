package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.CountryDTO;
import cs.home.sigm.mapper.CountryMapper;
import cs.home.sigm.repository.CountryRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryMapper countryMapper;

	public List<CountryDTO> getAll() {
		log.info("Listing all entries.");
		return countryMapper.mapResponse(countryRepository.findAll());
	}

	public CountryDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return countryMapper.map(countryRepository.getOne(id));
	}

	public void saveSingle(CountryDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		countryRepository.save(countryMapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		countryRepository.deleteById(id);
	}

}
