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
public class MaritalStatusControllerTest {

	private static final String BASE_URL = "/maritalstatus";

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {
		log.info("Validating context before start testing.");
		assertNotNull(mvc);
	}

	@Test
	public void shouldLoadAllMaritalStatusForPtBR() throws Exception {
		log.info("|:: TEST ::| >>> Should load all marital status for pt_BR.");
		findAll("pt_BR").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(6))).andExpect(jsonPath("$[0].language", is("pt_BR")));
	}

	@Test
	public void shouldLoadAllMaritalStatusForEnUS() throws Exception {
		log.info("|:: TEST ::| >>> Should load all marital status for en_US.");
		findAll("en_US").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(6))).andExpect(jsonPath("$[0].language", is("en_US")));
	}

	@Test
	public void shouldLoadAllMaritalStatusForEsES() throws Exception {
		log.info("|:: TEST ::| >>> Should load all marital status for es_ES.");
		findAll("es_ES").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(6))).andExpect(jsonPath("$[0].language", is("es_ES")));
	}

	@Test
	public void shouldGetSingle() throws Exception {
		log.info("|:: TEST ::| >>> Should get Single.");
		findSingle("en_US", 1L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("en_US"))).andExpect(jsonPath("$.title", is("Single")));
	}

	@Test
	public void shouldGetMarried() throws Exception {
		log.info("|:: TEST ::| >>> Should get Married.");
		findSingle("en_US", 3L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("en_US"))).andExpect(jsonPath("$.title", is("Married")));
	}

	private ResultActions findSingle(String language, Long code) throws Exception {
		return mvc.perform(get(BASE_URL + "/single/" + code + "?language=" + language).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions findAll(String language) throws Exception {
		return mvc.perform(get(BASE_URL + "?language=" + language).accept(MediaType.APPLICATION_JSON));
	}

}
