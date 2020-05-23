package cs.home.sigm;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles("test")
@AutoConfigureMockMvc
@Sql("/sql/data.sql")
public abstract class SIGMApplicationTestSetup {

	@Autowired
	protected MockMvc mvc;

	protected final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void contextLoads() {
		// log.info("Validating context before start testing.");
		assertNotNull(mvc);
	}

}
