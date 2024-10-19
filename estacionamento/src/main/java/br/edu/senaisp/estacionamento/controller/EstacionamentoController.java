package br.edu.senaisp.estacionamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.senaisp.estacionamento.model.Estacionamento;
import br.edu.senaisp.estacionamento.repository.IEstacionamentoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	IEstacionamentoRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Estacionamento>> listaEstacionamento() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estacionamento> buscarPorId(@PathVariable Integer id) {
		Estacionamento estm = repo.findById(id).orElseThrow();
		
		return ResponseEntity.ok(estm);
	}
	
	@PostMapping
	public ResponseEntity<Estacionamento> inserirEstacionamento(@RequestBody @Valid Estacionamento estm) {
		repo.save(estm);
		
		ResponseEntity<Estacionamento> respEnt = 
				ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
						.path("{id}").buildAndExpand(estm.getId()).toUri()).build();
		
		return respEnt;
			
	}
	
}

