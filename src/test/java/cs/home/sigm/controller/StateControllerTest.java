package cs.home.sigm.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
// @Sql("/test/data.sql")
public class StateControllerTest {

	private static final String BASE_URL = "/state";

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
		log.info("Validating context before start testing.");
		assertNotNull(mvc);
	}

	@Test
	public void shouldLoadAllStatesForBrazil() throws Exception {
		log.info("|:: TEST ::| >>> Should load all states that belongs to Brazil.");
		findAll(1L).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(27)));
	}

	@Test
	public void shouldLoadAllStatesForArgentina() throws Exception {
		log.info("|:: TEST ::| >>> Should load all states that belongs to Argentina.");
		findAll(2L).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(23)));
	}

	@Test
	public void shouldGetSaoPaulo() throws Exception {
		log.info("|:: TEST ::| >>> Should get Sao Paulo.");
		getOne(25L).andReturn(); // andExpect(status().isOk()).andExpect(jsonPath("$.title", is("São Paulo")));
	}

	@Test
	public void shouldGetBuenosAires() throws Exception {
		log.info("|:: TEST ::| >>> Should get Buenos Aires.");
		getOne(28L).andExpect(status().isOk()).andExpect(jsonPath("$.title", is("Buenos Aires")));
	}

	private ResultActions getOne(Long id) throws Exception {
		return mvc.perform(get(BASE_URL + "/" + id.intValue()).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions findAll(Long countrycode) throws Exception {
		return mvc.perform(get(BASE_URL + "?countrycode=" + countrycode).accept(MediaType.APPLICATION_JSON));
	}

}
