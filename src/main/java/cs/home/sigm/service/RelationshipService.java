package cs.home.sigm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs.home.sigm.adapter.domain.ValidLanguages;
import cs.home.sigm.domain.Relationship;
import cs.home.sigm.repository.RelationshipRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RelationshipService {

	@Autowired
	private RelationshipRepository repository;

	/**
	 * Load a single entry based on its language and code.
	 *
	 * @param  language The language to be used.
	 * @param  code     The code to be located.
	 * @return          An <code>Optional</code> containing the entry, or null, if not found.
	 */
	public Optional<Relationship> findSingle(String language, Long code) {
		log.info("Loading entry based on language: {}, and code: {}", language, code);
		return repository.findAllByCodeAndLanguage(code, language).stream().findFirst();
	}

	/**
	 * If a language filter is provided, it will only load the entries for that particular language. Otherwise, all entries will be loaded.
	 *
	 * @return All entries currently in the database for the request entity.
	 */
	public List<Relationship> findAll(String language) {
		log.info("Loading all entries. Language: {}.", language);
		if (ValidLanguages.isValid(language)) {
			return repository.findAllByLanguageOrderByTitle(ValidLanguages.parseLanguage(language));
		} else {
			return repository.findAll();
		}
	}

	/**
	 * Save the received entry into the database.
	 *
	 * @param request The entry to be persisted.
	 */
	public void save(Relationship request) {
		log.info("Persisting the entry: {}", request);
		repository.save(request);
	}

	public void deleteSingle(Long id) {
		log.info("Deleting the entry {}.", id);
		repository.deleteById(id);
	}

}
