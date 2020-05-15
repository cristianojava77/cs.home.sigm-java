package cs.home.sigm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.domain.State;
import cs.home.sigm.repository.StateRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StateService {

	@Autowired
	private StateRepository repository;

	/**
	 * If a country code filter is provided, it will only load the states for that particular country. Otherwise, all entries will be loaded.
	 *
	 * @param  countrycode The code of the Country to filter states.
	 * @return             A list of States of the Country filtered, or all states if no filter is provided.
	 */
	public List<State> findAll(Long countrycode) {
		log.info("Listing all states for country code: {}.", countrycode);
		return repository.findAllByCountrycodeOrderByTitle(countrycode);
	}

	/**
	 * Load a single State based on its Id.
	 *
	 * @param  id The ID of the state to be loaded.
	 * @return
	 */
	public State getOne(Long id) {
		log.info("Loading a single entry: {}", id);
		return repository.getOne(id);
	}

}
