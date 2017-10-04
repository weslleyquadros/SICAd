package br.unitins.sac.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.frame.repository.Repository;
import br.unitins.sac.model.Aluno;

public class AlunoRepository extends Repository<Aluno>{

	public AlunoRepository(EntityManager em) {
		super(em);
	}

	@Override
	protected Class<Aluno> getModelClass() {
		return Aluno.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<Aluno> bucarTodos() {
		
		Query query = geEntityManager().createQuery("Select a From Aluno a Order by a.id Desc");
		List<Aluno> lista = query.getResultList();
		
		if (lista == null)
			lista = new ArrayList<Aluno>();
		
		return lista;

	}
	
}
