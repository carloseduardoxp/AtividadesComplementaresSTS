package br.edu.iftm.atividadeComplementar.domains;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.edu.iftm.atividadeComplementar.domains.LancamentoAtividade;

public class LancamentoAtividadeTest {
	
	
	private LancamentoAtividade lancamentoAtividade;
	
	@Before
	public void init() {
		lancamentoAtividade = new LancamentoAtividade();
	}
	
	@Test
	public void testeSegundoSemestre() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,1);
		c.set(Calendar.MONTH, 6);
		c.set(Calendar.YEAR, 2018);
		lancamentoAtividade.setDataFim(c.getTime());
		String semestre = lancamentoAtividade.getSemestreAtividade();
		Assert.assertEquals(semestre,"2018-2");
	}
	
	@Test
	public void testePrimeiroSemestre() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,1);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.YEAR, 2017);
		lancamentoAtividade.setDataFim(c.getTime());
		String semestre = lancamentoAtividade.getSemestreAtividade();
		Assert.assertEquals(semestre,"2017-1");
	}
	
	@Test
	public void testeFinalPrimeiroSemestre() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,30);
		c.set(Calendar.MONTH, 5);
		c.set(Calendar.YEAR, 2015);
		lancamentoAtividade.setDataFim(c.getTime());
		String semestre = lancamentoAtividade.getSemestreAtividade();
		Assert.assertEquals(semestre,"2015-1");
	}
	
	@Test
	public void testeFinalAno() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH,31);
		c.set(Calendar.MONTH, 11);
		c.set(Calendar.YEAR, 2013);
		lancamentoAtividade.setDataFim(c.getTime());
		String semestre = lancamentoAtividade.getSemestreAtividade();
		Assert.assertEquals(semestre,"2013-2");
	}

}
