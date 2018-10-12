package br.edu.iftm.atividadeComplementar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.iftm.atividadeComplementar.domains.Aluno;
import br.edu.iftm.atividadeComplementar.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> buscar(String nome) {
		return repository.findByNomeContaining(nome);
	}
		
	public void salvarAtualizar(Aluno aluno) {
		repository.save(aluno);
	}
	
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	public Optional<Aluno> buscarRa(Long ra) {
		return repository.findById(ra);
	}
	
	public Page<Aluno> buscarTodos(Integer inicio, Integer fim) {
		return this.repository.findAll(PageRequest.of(inicio,fim));
	}
	
}
