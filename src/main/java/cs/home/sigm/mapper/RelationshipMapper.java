package cs.home.sigm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.RelationshipDTO;
import cs.home.sigm.domain.Relationship;

@Service
public class RelationshipMapper {

	/*
	public Relationship map(RelationshipDTO request) {
		// @formatter:off
		return Relationship.builder()
				.id(request.getId())
				.code(request.getCode())
				.title(request.getTitle())
				.language(request.getLanguage())
				.build();
		// @formatter:on
	}
	*/

	public List<RelationshipDTO> mapResponse(List<Relationship> lst) {
		List<RelationshipDTO> response = new ArrayList<>();
		for (Relationship cur : lst) {
			response.add(map(cur));
		}
		return response;
	}

	public RelationshipDTO map(Relationship domain) {
		// @// @formatter:off
		return RelationshipDTO.builder()
				.id(domain.getId())
				.code(domain.getCode())
				.title(domain.getTitle())
				.language(domain.getLanguage())
				.build();
		// @formatter:on
	}

	/*
	public List<Relationship> mapRequest(List<RelationshipDTO> lst) {
		List<Relationship> response = new ArrayList<>();
		for (RelationshipDTO cur : lst) {
			response.add(map(cur));
		}
		return response;
	}
	*/

}
