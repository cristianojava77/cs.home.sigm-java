package cs.home.sigm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
