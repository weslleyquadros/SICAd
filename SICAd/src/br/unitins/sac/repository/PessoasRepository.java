package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;

import br.unitins.sac.model.Pessoas;

public class PessoasRepository extends Repository<Pessoas>{

	public PessoasRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Pessoas> getModelClass() {
		return Pessoas.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoas> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select p From Pessoas p Order by p.id Desc");
		List<Pessoas> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Pessoas>();
		
		return lista;

	}
	
}
