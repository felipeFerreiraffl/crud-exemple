package br.edu.senaisp.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.senaisp.estacionamento.model.Dono;

public interface IDonoRepository extends JpaRepository<Dono, Integer> {}
