package cs.home.sigm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.State;

public interface StateRepository extends JpaRepository<State, Long> {

	public List<State> findAllByCountrycodeOrderByTitle(Long countrycode);

}
