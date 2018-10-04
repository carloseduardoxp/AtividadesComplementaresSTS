package br.edu.iftm.atividadeComplementar.domains;

import org.junit.Before;
import org.junit.Test;

import br.edu.iftm.atividadeComplementar.domains.Atividade;

import org.junit.Assert;

public class AtividadeTest {
	
	private Atividade atividade;
	
	@Before
	public void init() {
		atividade = new Atividade();
	}
	
	@Test
	public void testaQuantidadeLimiteHoras() {
		int percentualMonitoria = 50;
		int quantidadeHorasSistemasParaInternet = 60;
		atividade.setNome("Monitoria");
		atividade.setMaximoAtividadesSemestre(1);
		atividade.setPercentualPorAtividade(percentualMonitoria);
		int quantidadeHoras = atividade.getValorLimiteHorasAtividade(quantidadeHorasSistemasParaInternet);
		Assert.assertEquals(quantidadeHoras,30);
	}
	
	@Test
	public void testaQuantidadeLimiteHorasLicenciatura() {
		int percentualCurso = 40;
		int quantidadeHorasLicenciatura = 200;
		atividade.setNome("Cursos e Minicursos");
		atividade.setMaximoAtividadesSemestre(2);
		atividade.setPercentualPorAtividade(percentualCurso);
		int quantidadeHoras = atividade.getValorLimiteHorasAtividade(quantidadeHorasLicenciatura);
		Assert.assertEquals(quantidadeHoras,80);
	}

}



