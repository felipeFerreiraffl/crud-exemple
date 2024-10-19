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

import br.edu.senaisp.estacionamento.model.Carro;
import br.edu.senaisp.estacionamento.repository.ICarroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	ICarroRepository repo;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listaCarro() {
		return ResponseEntity.ok(repo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> buscarPorId(@PathVariable Integer id) {
		Carro car = repo.findById(id).orElseThrow();
		
		return ResponseEntity.ok(car);
	}
	
	@PostMapping
	public ResponseEntity<Carro> inserirEstacionamento(@RequestBody @Valid Carro car) {
		repo.save(car);
		
		ResponseEntity<Carro> respEnt = 
				ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
						.path("{id}").buildAndExpand(car.getId()).toUri()).build();
		
		return respEnt;
			
	}
	
}
