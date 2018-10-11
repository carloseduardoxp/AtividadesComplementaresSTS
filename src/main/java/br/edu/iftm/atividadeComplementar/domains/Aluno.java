package br.edu.iftm.atividadeComplementar.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	
	@Id
	private Long ra;
	
	private String nome;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<LancamentoAtividade> atividades;

	public Aluno(Long ra, String nome) {
		super();
		this.ra = ra;
		this.nome = nome;
	}

	public Aluno() {
		super();
	}

	public Long getRa() {
		return ra;
	}

	public void setRa(Long ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LancamentoAtividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<LancamentoAtividade> atividades) {
		this.atividades = atividades;
	}
	

}
