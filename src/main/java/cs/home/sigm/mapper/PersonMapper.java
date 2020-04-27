package cs.home.sigm.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.PersonDTO;
import cs.home.sigm.domain.Person;
import cs.home.sigm.repository.CountryRepository;
import cs.home.sigm.repository.MaritalStatusRepository;
import cs.home.sigm.repository.StateRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonMapper {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	public Person map(PersonDTO request) {
		// @formatter:off
		Person result = Person.builder()
				.dateBirth(request.getDatebirth())
				.email(request.getEmail())
				.id(request.getId())
				.name(request.getName())
				.number(request.getNumber())
				.street(request.getStreet())
				.build();
		// @formatter:on

		if (request.getIdcountry() != null) {
			try {
				result.setCountry(countryRepository.getOne(request.getIdcountry()));
			} catch (EntityNotFoundException e) {
				log.error("Counld not find a country for ID {} on the request mapper.", request.getIdcountry(), e);
			}
		}
		if (request.getIdmaritalstatus() != null) {
			try {
				result.setMaritalStatus(maritalStatusRepository.getOne(request.getIdmaritalstatus()));
			} catch (EntityNotFoundException e) {
				log.error("Counld not find a valid marital status for ID {} on the request mapper.", request.getIdmaritalstatus(), e);
			}
		}
		if (request.getIdstate() != null) {
			try {
				result.setState(stateRepository.getOne(request.getIdstate()));
			} catch (EntityNotFoundException e) {
				log.error("Counld not find a state for ID {} on the request mapper.", request.getIdstate(), e);
			}
		}

		return result;
	}

	public List<PersonDTO> mapResponse(List<Person> lst) {
		List<PersonDTO> response = new ArrayList<>();
		for (Person cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

	public PersonDTO map(Person domain) {
		// @// @formatter:off
		return PersonDTO.builder()
				.datebirth(domain.getDateBirth())
				.email(domain.getEmail())
				.id(domain.getId())
				.idcountry(domain.getCountry() != null ? domain.getCountry().getId() : null)
				.idmaritalstatus(domain.getMaritalStatus() != null ? domain.getMaritalStatus().getId() : null)
				.idstate(domain.getState() != null ? domain.getState().getId() : null)
				.name(domain.getName())
				.number(domain.getNumber())
				.street(domain.getStreet())
				.build();
		// @formatter:on
	}

	public List<Person> mapRequest(List<PersonDTO> lst) {
		List<Person> response = new ArrayList<>();
		for (PersonDTO cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

}
