package cs.home.sigm.adapter.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 8983469289098555408L;

	private Long id;

	private Long countrycode;

	private Long maritalstatuscode;

	private Long statecode;

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

	private String emailpersonal;

	private String emailwork;

}
