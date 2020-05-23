package cs.home.sigm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_person", indexes = { @Index(columnList = "name", name = "idx_person_name") })
public class Person implements Serializable {

	private static final long serialVersionUID = -1926509930607287585L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long countrycode;

	private Long maritalstatuscode;

	private Long statecode;

	@NotBlank(message = "Name is mandatory")
	private String name;

	private Date datebirth;

	private String street;

	private String number;

	private String district;

	private String city;

	private String zipcode;

	private String phonemobile;

	private String phonehome;

	private String phonework;

	@NotBlank(message = "Personal Email is mandatory")
	private String emailpersonal;

	private String emailwork;

}
