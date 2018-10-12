package br.edu.iftm.atividadeComplementar.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlunoResourceTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void teste01RequisicaoIdSucesso() throws Exception {
		String url = "/alunos/59320492";
		this.mvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(jsonPath("nome",equalTo("carlos eduardo")));
	}
	
	@Test
	public void teste02RequisicaoIdFalha() throws Exception {
		String url = "/alunos/666";
		this.mvc.perform(get(url))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void teste03RequisicaoLikeSucesso() throws Exception {
		String url = "/alunos/like/carlos";
		this.mvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("carlos eduardo")));
	}
	
	@Test
	public void teste04RequisicaoLikeFalha() throws Exception {
		String url = "/alunos/like/keilane";
		this.mvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("[]")));
	}
	
	@Test
	public void teste05RequisicaoFindAll() throws Exception {
		String url = "/alunos?page=0&size=10";
		this.mvc.perform(get(url))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("ra")));
	}
	
	@Test
	public void teste06RequisicaoDelete() throws Exception {
		String url = "/alunos/59320492";
		this.mvc.perform(delete(url))
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("59320492")));
	}
	
	@Test
	public void teste07RequisicaoDeleteFalha() throws Exception {
		String url = "/alunos/666";
		this.mvc.perform(delete(url))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void teste08Post() throws Exception {
		String url = "/alunos/";
        
		this.mvc.perform(post(url)
				.content("{\"ra\":123456,\"nome\":\"gabriel\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
		        .andExpect(header().string("Location", is("http://localhost/alunos/123456")))
		        .andExpect(content().string(""))
		        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void teste09PostIncompletoNome() throws Exception {
		String url = "/alunos/";
		this.mvc.perform(post(url).content("{\"ra\":123456}")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}


	@Test
	public void teste10PostIncompletoRa() throws Exception {
		String url = "/alunos/";
		this.mvc.perform(post(url).content("{\"nome\":\"gabriel\"}")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void teste11PutOk() throws Exception {
		String url = "/alunos/";
        
		this.mvc.perform(put(url)
				.content("{\"ra\":123456,\"nome\":\"gabriel jesus\"}")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent())
		        .andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void teste12PutIncompletoNome() throws Exception {
		String url = "/alunos/";
		this.mvc.perform(put(url).content("{\"ra\":123456}")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}

}
