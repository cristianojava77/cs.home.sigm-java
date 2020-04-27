package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.RelationshipDTO;
import cs.home.sigm.mapper.RelationshipMapper;
import cs.home.sigm.repository.RelationshipRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelationshipService {

	@Autowired
	private RelationshipRepository relationshipRepository;

	@Autowired
	private RelationshipMapper relationshipMapper;

	public List<RelationshipDTO> getAll() {
		log.info("Listing all entries.");
		return relationshipMapper.mapResponse(relationshipRepository.findAll());
	}

	public RelationshipDTO getSingle(Long id) {
		log.info("Loading a single entry: {}", id);
		return relationshipMapper.map(relationshipRepository.getOne(id));
	}

	public void saveSingle(RelationshipDTO request) {
		log.info("Saving a new entry based on request: {}", request);
		relationshipRepository.save(relationshipMapper.map(request));
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		relationshipRepository.deleteById(id);
	}

}
