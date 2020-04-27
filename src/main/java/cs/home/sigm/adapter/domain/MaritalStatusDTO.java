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
public class MaritalStatusDTO implements Serializable {

	private static final long serialVersionUID = 7741935306970417818L;

	private Long id;

	private String title;

	private String description;

}
