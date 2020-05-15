package cs.home.sigm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.CountryDTO;
import cs.home.sigm.domain.Country;

@Service
public class CountryMapper {

	public Country map(CountryDTO request) {
		// @formatter:off
		return Country.builder()
				.active(request.getActive())
				.code(request.getCode())
				.id(request.getId())
				.language(request.getLanguage())
				.title(request.getTitle())
				.build();
		// @formatter:on
	}

	public List<CountryDTO> mapResponse(List<Country> lst) {
		List<CountryDTO> response = new ArrayList<>();
		for (Country cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

	public CountryDTO map(Country domain) {
		// @// @formatter:off
		return CountryDTO.builder()
				.active(domain.getActive())
				.code(domain.getCode())
				.id(domain.getId())
				.language(domain.getLanguage())
				.title(domain.getTitle())
				.build();
		// @formatter:on
	}

	/*
	public List<Country> mapRequest(List<CountryDTO> lst) {
		List<Country> response = new ArrayList<>();
		for (CountryDTO cur : lst) {
			response.add(map(cur));
		}
		return response;
	}
	*/

}
