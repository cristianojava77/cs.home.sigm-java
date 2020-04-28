package cs.home.sigm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.StateDTO;
import cs.home.sigm.domain.State;

@Service
public class StateMapper {

	public State map(StateDTO request) {
		// @formatter:off
		return State.builder()
				.abbreviation(request.getAbbreviation())
				.active(request.getActive())
				.countrycode(request.getCountrycode())
				.id(request.getId())
				.title(request.getTitle())
				.build();
		// @formatter:on
	}

	public List<StateDTO> mapResponse(List<State> lst) {
		List<StateDTO> response = new ArrayList<>();
		for (State cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

	public StateDTO map(State domain) {
		// @// @formatter:off
		return StateDTO.builder()
				.abbreviation(domain.getAbbreviation())
				.active(domain.getActive())
				.countrycode(domain.getCountrycode())
				.id(domain.getId())
				.title(domain.getTitle())
				.build();
		// @formatter:on
	}

	public List<State> mapRequest(List<StateDTO> lst) {
		List<State> response = new ArrayList<>();
		for (StateDTO cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

}
