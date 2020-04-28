package cs.home.sigm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.MaritalStatus;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Long> {

	public List<MaritalStatus> findAllByLanguageOrderByTitle(String language);

	public List<MaritalStatus> findAllByCodeAndLanguage(Long code, String language);

}
