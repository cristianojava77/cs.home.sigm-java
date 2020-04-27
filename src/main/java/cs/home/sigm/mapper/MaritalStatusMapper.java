package cs.home.sigm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.MaritalStatusDTO;
import cs.home.sigm.domain.MaritalStatus;

@Service
public class MaritalStatusMapper {

	public MaritalStatus map(MaritalStatusDTO request) {
		// @formatter:off
		return MaritalStatus.builder()
				.description(request.getDescription())
				.id(request.getId())
				.title(request.getTitle())
				.build();
		// @formatter:on
	}

	public List<MaritalStatusDTO> mapResponse(List<MaritalStatus> lst) {
		List<MaritalStatusDTO> response = new ArrayList<>();
		for (MaritalStatus cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

	public MaritalStatusDTO map(MaritalStatus domain) {
		// @// @formatter:off
		return MaritalStatusDTO.builder()
				.description(domain.getDescription())
				.id(domain.getId())
				.title(domain.getTitle())
				.build();
		// @formatter:on
	}

	public List<MaritalStatus> mapRequest(List<MaritalStatusDTO> lst) {
		List<MaritalStatus> response = new ArrayList<>();
		for (MaritalStatusDTO cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

}
