package cs.home.sigm.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cs.home.sigm.adapter.domain.CountryDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
// @Sql("/test/data.sql")
public class CountryControllerTest {

	private static final String BASE_URL = "/country";

	@Autowired
	private MockMvc mvc;

	private final ObjectMapper mapper = new ObjectMapper();

	@Test
	public void contextLoads() {
		log.info("Validating context before start testing.");
		assertNotNull(mvc);
	}

	@Test
	public void shouldLoadAllCountriesForPtBR() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for pt_BR.");
		findAll("pt_BR").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].language", is("pt_BR")));
	}

	@Test
	public void shouldLoadAllCountriesForEnUS() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for en_US.");
		findAll("en_US").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].language", is("en_US")));
	}

	@Test
	public void shouldLoadAllCountriesForEsES() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries for es_ES.");
		findAll("es_ES").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3))).andExpect(jsonPath("$[0].language", is("es_ES")));
	}

	@Test
	public void shouldLoadAllCountriesForInvalidLocale() throws Exception {
		log.info("|:: TEST ::| >>> Should load all countries (invalid locale).");
		findAll("xx_XX").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(9)));
	}

	@Test
	public void shouldGetBrazil() throws Exception {
		log.info("|:: TEST ::| >>> Should get Brazil.");
		findSingle("pt_BR", 1L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("pt_BR"))).andExpect(jsonPath("$.title", is("Brasil")));
	}

	@Test
	public void shouldGetArgentina() throws Exception {
		log.info("|:: TEST ::| >>> Should get Argentina.");
		findSingle("en_US", 2L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("en_US"))).andExpect(jsonPath("$.title", is("Argentina")));
	}

	@Test
	public void shouldSaveAndThenDeleteEntry() throws Exception {
		log.info("|:: TEST ::| >>> Should save a new Country.");
		final MvcResult result = saveEntry(CountryDTO.builder().code(5L).language("en_US").title("Test Country").build()).andReturn();
		assertEquals("Saved successfully", result.getResponse().getContentAsString());
		// Reading ID
		final MvcResult countryRaw = findSingle("en_US", 5L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("en_US"))).andExpect(jsonPath("$.title", is("Test Country"))).andReturn();
		final CountryDTO countryDto = mapper.readValue(countryRaw.getResponse().getContentAsString(), new TypeReference<CountryDTO>() {
		});
		assertNotNull(countryDto);
		assertEquals("Test Country", countryDto.getTitle());

		log.info("|:: TEST ::| >>> Should delete a Country.");
		// Deleting by ID
		final MvcResult resultDelete = deleteEntry(countryDto.getId()).andExpect(status().isOk()).andReturn();
		assertNotNull(resultDelete);
		assertEquals("Request deleted.", resultDelete.getResponse().getContentAsString());
	}

	private ResultActions findSingle(String language, Long code) throws Exception {
		return mvc.perform(get(BASE_URL + "/single/" + code + "?language=" + language).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions findAll(String language) throws Exception {
		return mvc.perform(get(BASE_URL + "?language=" + language).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions saveEntry(CountryDTO request) throws Exception {
		return mvc.perform(post(BASE_URL).content(this.mapper.writeValueAsBytes(request)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions deleteEntry(Long id) throws Exception {
		return mvc.perform(post(BASE_URL + "/delete/" + id).accept(MediaType.APPLICATION_JSON));
	}

}
