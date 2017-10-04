package br.unitins.sac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.frame.application.ApplicationException;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Pessoas;
import br.unitins.sac.repository.PessoasRepository;

@FacesConverter(value = "pessoasConverter", forClass = Pessoas.class)
public class PessoasConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		PessoasRepository repository = new PessoasRepository(JPAFactory.getEntityManager());
		try {
			Pessoas p = ((Pessoas)repository.find(Integer.parseInt(arg2)));  
			return p;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null) {
			System.out.println(arg2.getClass().getName());

			return ((Pessoas) arg2).getId() == null ? "":((Pessoas) arg2).getId().toString();
		}
		return "";
	}
}