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
				.datebirth(request.getDatebirth())
				.street(request.getStreet())
				.number(request.getNumber())
				.district(request.getDistrict())
				.city(request.getCity())
				.zipcode(request.getZipcode())
				.phonemobile(request.getPhonemobile())
				.phonehome(request.getPhonehome())
				.phonework(request.getPhonework())
				.emailpersonal(request.getEmailpersonal())
				.emailwork(request.getEmailwork())
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
				.datebirth(domain.getDatebirth())
				.street(domain.getStreet())
				.number(domain.getNumber())
				.district(domain.getDistrict())
				.city(domain.getCity())
				.zipcode(domain.getZipcode())
				.phonemobile(domain.getPhonemobile())
				.phonehome(domain.getPhonehome())
				.phonework(domain.getPhonework())
				.emailpersonal(domain.getEmailpersonal())
				.emailwork(domain.getEmailwork())
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
