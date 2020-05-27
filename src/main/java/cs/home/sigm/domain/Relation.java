package cs.home.sigm.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Table(name = "tbl_relation")
public class Relation implements Serializable {

	private static final long serialVersionUID = 306339534621157444L;

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("person_id")
	private Person person;

	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("relative_id")
	private Person relative;

	@NotEmpty(message = "Relationship is mandatory")
	private Long relationshipcode;

}
