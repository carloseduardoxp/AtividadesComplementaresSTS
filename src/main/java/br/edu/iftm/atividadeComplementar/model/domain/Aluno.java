package br.edu.iftm.atividadeComplementar.model.domain;

public class Aluno {
	
	private Long ra;
	
	private String nome;

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
	
	

}
