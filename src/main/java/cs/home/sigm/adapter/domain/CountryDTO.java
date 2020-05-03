package cs.home.sigm.adapter.domain;

import java.io.Serializable;

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
public class CountryDTO implements Serializable {

	private static final long serialVersionUID = -654206246878189571L;

	private Long id;

	private Long code;

	private String title;

	private String language;

	private Boolean active;

}
