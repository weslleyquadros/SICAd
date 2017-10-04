package br.unitins.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Cidade extends Model<Cidade> {

	private static final long serialVersionUID = 684044324554894454L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidcidade")
	@SequenceGenerator(name = "seqidcidade", sequenceName = "seqidcidade", allocationSize = 1)
	private Integer id;
	private String nome;

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

}
