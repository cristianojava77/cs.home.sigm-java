package cs.home.sigm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

}
