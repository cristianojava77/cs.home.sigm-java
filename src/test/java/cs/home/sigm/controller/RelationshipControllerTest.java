package cs.home.sigm.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;

import cs.home.sigm.SIGMApplicationTestSetup;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationshipControllerTest extends SIGMApplicationTestSetup {

	private static final String BASE_URL = "/relationship";

	@Test
	public void shouldLoadAllRelationshipsForPtBR() throws Exception {
		log.info("|:: TEST ::| >>> Should load all Relationships for pt_BR.");
		findAll("pt_BR").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].language", is("pt_BR")));
	}

	@Test
	public void shouldLoadAllRelationshipsForEnUS() throws Exception {
		log.info("|:: TEST ::| >>> Should load all Relationships for en_US.");
		findAll("en_US").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].language", is("en_US")));
	}

	@Test
	public void shouldLoadAllRelationshipsForEsES() throws Exception {
		log.info("|:: TEST ::| >>> Should load all Relationships for es_ES.");
		findAll("es_ES").andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)))
				.andExpect(jsonPath("$[0].language", is("es_ES")));
	}

	@Test
	public void shouldGetSpouse() throws Exception {
		log.info("|:: TEST ::| >>> Should get Brazil.");
		findSingle("en_US", 1L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("en_US")))
				.andExpect(jsonPath("$.title", is("Spouse")));
	}

	@Test
	public void shouldGetMother() throws Exception {
		log.info("|:: TEST ::| >>> Should get Argentina.");
		findSingle("es_ES", 3L).andExpect(status().isOk()).andExpect(jsonPath("$.language", is("es_ES")))
				.andExpect(jsonPath("$.title", is("Madre")));
	}

	private ResultActions findSingle(String language, Long code) throws Exception {
		return mvc.perform(
				get(BASE_URL + "/single/" + code + "?language=" + language).accept(MediaType.APPLICATION_JSON));
	}

	private ResultActions findAll(String language) throws Exception {
		return mvc.perform(get(BASE_URL + "?language=" + language).accept(MediaType.APPLICATION_JSON));
	}

}
