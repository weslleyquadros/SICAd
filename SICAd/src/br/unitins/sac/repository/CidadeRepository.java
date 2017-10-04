package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;
import br.unitins.sac.model.Cidade;

public class CidadeRepository extends Repository<Cidade>{

	public CidadeRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Cidade> getModelClass() {
		return Cidade.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select c From Cidade c Order by c.id Desc");
		List<Cidade> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Cidade>();
		
		return lista;

	}
	
}
