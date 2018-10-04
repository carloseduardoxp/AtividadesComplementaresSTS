package br.edu.iftm.atividadeComplementar.domains;

import java.util.Calendar;
import java.util.Date;

public class LancamentoAtividade {
	
	private Integer codigo;
	
	private Integer quantidadeHoras;
	
	private Date dataInicio;
	
	private Date dataFim;
	
	private Aluno aluno;
	
	private Atividade atividade;

	public LancamentoAtividade(Integer codigo, Integer quantidadeHoras, Date dataInicio, Date dataFim, Aluno aluno,
			Atividade atividade) {
		super();
		this.codigo = codigo;
		this.quantidadeHoras = quantidadeHoras;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.aluno = aluno;
		this.atividade = atividade;
	}
	
	public String getSemestreAtividade() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataFim);
		int ano = calendar.get(Calendar.YEAR);
		int mes = calendar.get(Calendar.MONTH);
		if (mes > 5) {
			return ano+"-2";
		} else {
			return ano+"-1";
		}
	}
	
	//public Integer getHorasAproveitadas() {
		
	//}

	public LancamentoAtividade() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidadeHoras() {
		return quantidadeHoras;
	}

	public void setQuantidadeHoras(Integer quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	

}
