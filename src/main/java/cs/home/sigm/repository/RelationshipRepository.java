package cs.home.sigm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

	public List<Relationship> findAllByLanguageOrderByTitle(String language);

	public List<Relationship> findAllByCodeAndLanguage(Long code, String language);

}
