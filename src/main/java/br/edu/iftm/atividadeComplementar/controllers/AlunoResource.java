package br.edu.iftm.atividadeComplementar.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.atividadeComplementar.domains.Aluno;
import br.edu.iftm.atividadeComplementar.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@RequestMapping(value="like/{nome}",method=RequestMethod.GET)
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		List<Aluno> alunos = service.buscar(nome);
		return ResponseEntity.ok().body(alunos);
	}
	
	@RequestMapping(value="{ra}",method=RequestMethod.GET)
	public ResponseEntity<?> findByRa(@PathVariable Long ra) {
		Optional<Aluno> aluno = service.buscarRa(ra);
		return ResponseEntity.ok().body(aluno);
	}
	
	@GetMapping
	//@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>> findAll() {
		return ResponseEntity.ok().body(service.buscarTodos());
	}
		
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Aluno aluno) {
		service.salvarAtualizar(aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody Aluno aluno) {
		service.salvarAtualizar(aluno);
		return ResponseEntity.ok().body(aluno);
	}
	
	@DeleteMapping(value="{ra}")
	public ResponseEntity<?> excluir(@PathVariable Long ra) {
		service.excluir(ra);
		return ResponseEntity.ok(ra);
	}

}
