package br.edu.iftm.atividadeComplementar.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.iftm.atividadeComplementar.domains.Aluno;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlunoRepositoryTest {
	
	@Autowired
	private AlunoRepository repository;
	
	@Test
	public void testaAlunoCarlos() {
		List<Aluno> c = repository.findByNomeContaining("carlos");
		assertThat(c.size()).isGreaterThan(0);
	}
	
	@Test
	public void testaListaVazia() {
		List<Aluno> c = repository.findByNomeContaining("diogo");
		assertThat(c.size()).isEqualTo(0);
	}

}
