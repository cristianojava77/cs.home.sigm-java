package cs.home.sigm.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import cs.home.sigm.adapter.domain.CountryDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Sql("/data.sql")
public class CountryControllerTest {

	private static final String BASE_URL = "/country";

	@Autowired
	private MockMvc mvc;

	private final ObjectMapper mapper = new ObjectMapper();

	@Before
	public void setup() {

	}

	@Test
	public void contextLoads() {
		log.info("Validating context before start testing.");
		assertNotNull(mvc);
	}

	@Test
	public void shouldLoadAllCountriesForPtBR() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for pt_BR.");
		findAll("pt_BR").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(20))).andExpect(jsonPath("$[0].language", is("pt_BR")));
	}

	@Test
	public void shouldLoadAllCountriesForEnUS() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for en_US.");
		findAll("en_US").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(20))).andExpect(jsonPath("$[0].language", is("en_US")));
	}

	@Test
	public void shouldLoadAllCountriesForEsAR() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for es_AR.");
		findAll("es_AR").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(20))).andExpect(jsonPath("$[0].language", is("es_ES")));
	}

	@Test
	public void shouldLoadAllCountriesForEsCL() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for es_CL.");
		findAll("es_CL").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(20))).andExpect(jsonPath("$[0].language", is("es_ES")));
	}

	@Test
	public void shouldGetArgentina() throws Exception {
		log.info("|:: TEST ::| >>> Should get Argentina.");
		findSingle("pt_BR", 1l).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("pt_BR"))).andExpect(jsonPath("$.title", is("Argentina")));
	}

	@Test
	public void shouldGetVenezuela() throws Exception {
		log.info("|:: TEST ::| >>> Should get Bolivia.");
		findSingle("pt_BR", 20l).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("pt_BR"))).andExpect(jsonPath("$.title", is("Venezuela")));
	}

	@Test
	public void shouldSaveEntry() throws Exception {
		log.info("|:: TEST ::| >>> Should save a new Country.");
		final MvcResult result = saveEntry(CountryDTO.builder().code(21L).language("pt_BR").title("Nova Zelândia").build()).andReturn();
		assertEquals("Saved successfully", result.getResponse().getContentAsString());
		// Validating
		findSingle("pt_BR", 21l).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("pt_BR"))).andExpect(jsonPath("$.title", is("Nova Zelândia")));
	}

	private ResultActions findSingle(String lang, Long code) throws Exception {
		return mvc.perform(get(BASE_URL + "/single/" + code + "?lang=" + lang).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions findAll(String lang) throws Exception {
		return mvc.perform(get(BASE_URL + "?lang=" + lang).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions saveEntry(CountryDTO request) throws Exception {
		return mvc.perform(post(BASE_URL).content(this.mapper.writeValueAsBytes(request)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
	}

}
