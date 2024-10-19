package br.edu.senaisp.estacionamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dono")
public class Dono {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Size(min = 14, max = 14)
	private String cpf;
	
	@NotBlank
	@Size(min = 12, max = 12)
	private String rg;
	
	@NotBlank
	private String cidadeLocal;
	
	@OneToOne
	private Carro carro;

	public Dono() {}

	public Dono(Integer id, @NotBlank String nome, @NotBlank @Size(min = 14, max = 14) String cpf,
			@NotBlank @Size(min = 9, max = 9) String rg, @NotBlank String cidadeLocal, Carro carro) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.cidadeLocal = cidadeLocal;
		this.carro = carro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCidadeLocal() {
		return cidadeLocal;
	}

	public void setCidadeLocal(String cidadeLocal) {
		this.cidadeLocal = cidadeLocal;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
}
