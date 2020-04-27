package cs.home.sigm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cs.home.sigm.domain.MaritalStatus;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Long> {

}
