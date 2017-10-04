package br.unitins.sac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import br.unitins.frame.model.Model;

@Entity
public class Aluno extends Model<Aluno> {

	private static final long serialVersionUID = 5340998728426485061L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqidaluno")
	@SequenceGenerator(name = "seqidaluno", sequenceName = "seqidaluno", allocationSize = 1)
	private Integer id;
	private String matricula;
	private String nota1;
	private String nota2;


	@ManyToOne
	@JoinColumn(name = "idCidade", nullable = true)
	private Cidade cidade;
	@JoinColumn(name = "idPessoas", nullable = true)
	private Pessoas pessoas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Pessoas getPessoas() {
		return pessoas;
	}

	public void setPessoas(Pessoas pessoas) {
		this.pessoas = pessoas;
	}
	
	public String getNota1() {
		return nota1;
	}

	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}

	public String getNota2() {
		return nota2;
	}

	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}
}
