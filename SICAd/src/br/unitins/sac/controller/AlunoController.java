package br.unitins.sac.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Aluno;
import br.unitins.sac.model.Cidade;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.repository.AlunoRepository;
import br.unitins.sac.repository.CidadeRepository;
import br.unitins.sac.repository.PessoasRepository;
import br.unitins.sac.validation.AlunoValidation;

@ManagedBean
@ViewScoped
public class AlunoController extends Controller<Aluno> {

	private List<Cidade> listaCidade;
	private List<Pessoas> listaPessoas;
	private List<Aluno> listaAluno;

	@Override
	public Aluno getEntity() {
		if (entity == null) {
			entity = new Aluno();
			entity.setPessoas(new Pessoas());
			entity.setCidade(new Cidade());
		}
		return entity;
	}

	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaAluno(null);
		setListaCidade(null);
	}

	@Override
	public Validation<Aluno> getValidation() {
		return new AlunoValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}

	public List<Aluno> getListaAluno() {
		if (listaAluno == null) {
			AlunoRepository repository = new AlunoRepository(JPAFactory.getEntityManager());
			listaAluno = repository.bucarTodos();
		}
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaServidor) {
		this.listaAluno = listaServidor;
	}


	public List<Cidade> getListaCidade() {
		if (listaCidade == null) {
			CidadeRepository repository = new CidadeRepository(JPAFactory.getEntityManager());
			listaCidade = repository.bucarTodos();
		}
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

	public List<Pessoas> getListaPessoas() {
		if (listaPessoas == null) {
			PessoasRepository repository = new PessoasRepository(JPAFactory.getEntityManager());
			listaPessoas = repository.bucarTodos();
		}
		return listaPessoas;
	}

	public void setListaPessoas(List<Pessoas> listaPessoas) {
		this.listaPessoas = listaPessoas;
	}
	

}
