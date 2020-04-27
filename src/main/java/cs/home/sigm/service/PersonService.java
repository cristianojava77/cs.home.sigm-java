package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.PersonDTO;
import cs.home.sigm.mapper.PersonMapper;
import cs.home.sigm.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonMapper personMapper;

	public List<PersonDTO> getAll() {
		log.info("Listing all entries.");
		return personMapper.mapResponse(personRepository.findAll());
	}

	public PersonDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return personMapper.map(personRepository.getOne(id));
	}

	public void saveSingle(PersonDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		personRepository.save(personMapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		personRepository.deleteById(id);
	}

}
