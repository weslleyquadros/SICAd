package br.unitins.sac.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;
import javax.persistence.Entity;

@Entity
public class Pessoas extends Model<Pessoas> {

	
	
	private static final long serialVersionUID = 8594567099657063872L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidpessoas")
	@SequenceGenerator(name = "seqidpessoas", sequenceName = "seqidpessoas", allocationSize = 1)
	private Integer id;
	private String nome;
	private String cpf;
	private String Rg;
	private String endereco;
	private String telefone;
	
	
	
	@Override
	public Integer getId() {
		
		return id;
	}

	@Override
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
		return Rg;
	}

	public void setRg(String rg) {
		Rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
