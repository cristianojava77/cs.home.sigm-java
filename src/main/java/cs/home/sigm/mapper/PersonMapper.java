package cs.home.sigm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.PersonDTO;
import cs.home.sigm.domain.Person;

@Service
public class PersonMapper {

	public Person map(PersonDTO request) {
		// @formatter:off
		return Person.builder()
				.id(request.getId())
				.countrycode(request.getCountrycode())
				.maritalstatuscode(request.getMaritalstatuscode())
				.statecode(request.getStatecode())
				.name(request.getName())
				.email(request.getEmail())
				.dateBirth(request.getDatebirth())
				.street(request.getStreet())
				.number(request.getNumber())
				.build();
		// @formatter:on
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
				.id(domain.getId())
				.countrycode(domain.getCountrycode())
				.maritalstatuscode(domain.getMaritalstatuscode())
				.statecode(domain.getStatecode())
				.name(domain.getName())
				.email(domain.getEmail())
				.datebirth(domain.getDateBirth())
				.street(domain.getStreet())
				.number(domain.getNumber())
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
