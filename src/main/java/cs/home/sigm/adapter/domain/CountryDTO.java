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
public class CountryDTO implements Serializable {

	private static final long serialVersionUID = -654206246878189571L;

	private Long id;

	private String code;

	private String title;

	private String description;

	private Boolean active;

}
