package br.edu.senaisp.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.senaisp.estacionamento.model.Estacionamento;

public interface IEstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {}
