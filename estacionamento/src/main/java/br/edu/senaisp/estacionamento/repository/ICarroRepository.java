package br.edu.senaisp.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.senaisp.estacionamento.model.Carro;

public interface ICarroRepository extends JpaRepository<Carro, Integer> {}
