package edu.ac.gitdebugging.web;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ac.gitdebugging.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MainControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() throws Exception{
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.build();
	}
	
	@Test public void 
	shouldCallSaveWhenPostPersonJson ()
		throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		Person person = new Person();
		person.setName("Jonathan");
		
		mockMvc.perform(post("/persons/").content( mapper.writeValueAsString(person) )).
		
			andExpect(status().isCreated());
		
	}
	
	@Test public void 
	shouldCallSaveWhenPutPersonJson ()
		throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		Person person = new Person();
		person.setName("Jonathan");
		
		mockMvc.perform(put("/persons/1").content( mapper.writeValueAsString(person) ).
			contentType(org.springframework.http.MediaType.APPLICATION_JSON_UTF8) ).
		
			andExpect(status().isOk());
	}
	
	@Test public void 
	shouldReturnPersonListWhenGet ()
		throws Exception{
		mockMvc.perform(get("/persons/").
			contentType(org.springframework.http.MediaType.APPLICATION_JSON_UTF8) ).
		
			andExpect(status().isOk()).
			andExpect( jsonPath("$.length()", greaterThan(0) ) ).
			andReturn();
	}
	
	@Test public void 
	shouldReturnPersonWhenGetWithId ()
		throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		Person person = new Person();
		person.setName("Jonathan");
		
		mockMvc.perform(get("/persons/1").content( mapper.writeValueAsString(person) ).
			contentType(org.springframework.http.MediaType.APPLICATION_JSON_UTF8) ).
		
			andExpect(status().isOk()).
			andExpect( jsonPath("$.id").isNumber() ).
			andReturn();
	}
	
}
