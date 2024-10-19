package br.edu.senaisp.estacionamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "carro")
public class Carro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String modelo;
	
	@NotBlank
	private String cor;
	
	@NotBlank
	@Size(min = 7)
	private String placa;
	
	@ManyToOne
	private Estacionamento estacionamento;
	
	@OneToOne
	private Dono dono;

	public Carro() {}

	public Carro(Integer id, @NotBlank String modelo, @NotBlank String cor, @NotBlank @Size(min = 7) String placa,
			Estacionamento estacionamento, Dono dono) {
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.estacionamento = estacionamento;
		this.dono = dono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}
}
