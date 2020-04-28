package cs.home.sigm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	public List<Country> findAllByLanguageOrderByTitle(String language);

	public List<Country> findAllByCodeAndLanguage(Long code, String language);

}
