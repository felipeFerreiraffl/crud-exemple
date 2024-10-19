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

import br.edu.senaisp.estacionamento.model.Dono;
import br.edu.senaisp.estacionamento.repository.IDonoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dono")
public class DonoController {
	
	@Autowired
	IDonoRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Dono>> listaCarro() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dono> buscarPorId(@PathVariable Integer id) {
		Dono dono = repo.findById(id).orElseThrow();
		
		return ResponseEntity.ok(dono);
	}
	
	@PostMapping
	public ResponseEntity<Dono> inserirEstacionamento(@RequestBody @Valid Dono dono) {
		repo.save(dono);
		
		ResponseEntity<Dono> respEnt = 
				ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
						.path("{id}").buildAndExpand(dono.getId()).toUri()).build();
		
		return respEnt;
			
	}
}
