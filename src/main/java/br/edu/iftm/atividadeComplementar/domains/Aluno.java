package br.edu.iftm.atividadeComplementar.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aluno {
	
	@Id
	@NotNull(message="Campo ra precisa ser preenchido")
	private Long ra;
	
	@NotNull(message="Campo nome precisa ser preenchido")
	@Size(min=3, message="Nome precisa ter pelo menos 3 caracteres")
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
