package cs.home.sigm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Person implements Serializable {

	private static final long serialVersionUID = -1926509930607287585L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Country country;

	private State state;

	private MaritalStatus maritalStatus;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Email is mandatory")
	private String email;

	private Date dateBirth;

	private String street;

	private String number;

}
