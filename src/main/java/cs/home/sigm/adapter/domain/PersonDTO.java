package cs.home.sigm.adapter.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 8983469289098555408L;

	private Long id;

	private Long idcountry;

	private Long idstate;

	private Long idmaritalstatus;

	private String name;

	private String email;

	private Date datebirth;

	private String street;

	private String number;

}
