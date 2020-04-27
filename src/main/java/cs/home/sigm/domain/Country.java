package cs.home.sigm.domain;

import java.io.Serializable;

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
public class Country implements Serializable {

	private static final long serialVersionUID = 2065829407246890806L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank(message = "Country code is mandatory")
	private String code;

	@NotBlank(message = "Country title is mandatory")
	private String title;

	private String description;

	@Builder.Default
	private Boolean active = true;

}
