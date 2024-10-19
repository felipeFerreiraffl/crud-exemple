package br.edu.senaisp.estacionamento.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "estacionamento")
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private int numEstacionamento;

	@OneToMany(mappedBy = "estacionamento")
	private List<Carro> carro = new ArrayList<Carro>();

	public Estacionamento() {}

	public Estacionamento(Integer id, @NotNull int numEstacionamento, List<Carro> carro) {
		this.id = id;
		this.numEstacionamento = numEstacionamento;
		this.carro = carro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNumEstacionamento() {
		return numEstacionamento;
	}

	public void setNumEstacionamento(int numEstacionamento) {
		this.numEstacionamento = numEstacionamento;
	}

	public List<Carro> getCarro() {
		return carro;
	}

	public void setCarro(List<Carro> carro) {
		this.carro = carro;
	}

}
