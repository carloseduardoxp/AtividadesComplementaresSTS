package br.edu.iftm.atividadeComplementar.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.iftm.atividadeComplementar.domains.Aluno;
import br.edu.iftm.atividadeComplementar.services.AlunoService;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping(value="like/{nome}")
	public ResponseEntity<?> findByNome(@PathVariable String nome) {
		List<Aluno> alunos = service.buscar(nome);
		return ResponseEntity.ok().body(alunos);
	}
	
	@GetMapping(value="{ra}")
	public ResponseEntity<?> findByRa(@PathVariable Long ra) {
		Optional<Aluno> aluno = service.buscarRa(ra);
		if (aluno.isPresent()) {
			return ResponseEntity.ok().body(aluno);	
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll(@RequestParam( "page" ) int page, @RequestParam( "size" ) int size) {
		Page<Aluno> alunos = service.buscarTodos(page,size);
		return ResponseEntity.ok().body(alunos.getContent());
	}
		
	@PostMapping
	public ResponseEntity<?> salvar(@Valid @RequestBody Aluno aluno) {
		service.salvarAtualizar(aluno);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		        .buildAndExpand(aluno.getRa()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<?> atualizar(@Valid @RequestBody Aluno aluno) {
		Optional<Aluno> alunoOptional = service.buscarRa(aluno.getRa());

	    if (!alunoOptional.isPresent()) {
	      return ResponseEntity.notFound().build();
	    }
	    
	 	service.salvarAtualizar(aluno);
	    return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="{ra}")
	public ResponseEntity<?> excluir(@PathVariable Long ra) {
		try {
			service.excluir(ra);
			return ResponseEntity.ok(ra);	
		} catch(EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
		
	}

}