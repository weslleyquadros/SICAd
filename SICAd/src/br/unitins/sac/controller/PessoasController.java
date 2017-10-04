package br.unitins.sac.controller;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;


import br.unitins.frame.controller.Controller;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.repository.PessoasRepository;
import br.unitins.sac.validation.PessoasValidation;


@ManagedBean
@ViewScoped
public class PessoasController extends Controller<Pessoas> {

	private List<Pessoas> listaPessoas;

	@Override
	public Pessoas getEntity() {
		if (entity == null) 
			entity = new Pessoas();
			return entity;
	}

	@Override
	public Validation<Pessoas> getValidation() {
		return new PessoasValidation();
	}

	@Override
	protected EntityManager getEntityManager() {
		return JPAFactory.getEntityManager();
	}
	
	@Override
	public void clean(ActionEvent actionEvent) {
		super.clean(actionEvent);
		setListaPessoas(null);
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
