package cs.home.sigm.adapter.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateDTO implements Serializable {

	private static final long serialVersionUID = 1476166298462645135L;

	private Long id;

	private Long countrycode;

	private String abbreviation;

	private String title;

	private Boolean active;

}
