package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cs.home.sigm.adapter.domain.MaritalStatusDTO;
import cs.home.sigm.exception.EntryNotFoundException;
import cs.home.sigm.mapper.MaritalStatusMapper;
import cs.home.sigm.repository.MaritalStatusRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MaritalStatusService {

	@Autowired
	private MaritalStatusRepository repository;

	@Autowired
	private MaritalStatusMapper mapper;

	public List<MaritalStatusDTO> getAll(String language) {
		log.info("Listing all entries for language: {}.", language);
		if (StringUtils.isEmpty(language)) {
			return mapper.mapResponse(repository.findAll());
		}
		return mapper.mapResponse(repository.findAllByLanguageOrderByTitle(language));
	}

	public MaritalStatusDTO getSingle(Long code, String language) {
		log.info("Loading a single entry based on code and language. code: {}, language: {}", code, language);
		return mapper.map(repository.findAllByCodeAndLanguage(code, language).stream().findFirst()
				.orElseThrow(() -> new EntryNotFoundException("Cannot find any entry for code: " + code + " and language: " + language)));
	}

	public MaritalStatusDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return mapper.map(repository.getOne(id));
	}

	public void saveSingle(MaritalStatusDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		repository.save(mapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		repository.deleteById(id);
	}

}
