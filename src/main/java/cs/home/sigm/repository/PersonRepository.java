package cs.home.sigm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
