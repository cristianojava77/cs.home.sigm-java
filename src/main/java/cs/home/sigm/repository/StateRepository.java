package cs.home.sigm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.State;

public interface StateRepository extends JpaRepository<State, Long> {

}
