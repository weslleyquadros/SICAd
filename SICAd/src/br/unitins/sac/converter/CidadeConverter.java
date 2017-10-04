package br.unitins.sac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.unitins.frame.application.ApplicationException;
import br.unitins.sac.factory.JPAFactory;
import br.unitins.sac.model.Cidade;
import br.unitins.sac.repository.CidadeRepository;

@FacesConverter(value = "cidadeConverter", forClass = Cidade.class)
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		CidadeRepository repository = new CidadeRepository(JPAFactory.getEntityManager());
		try {
			Cidade c = ((Cidade)repository.find(Integer.parseInt(arg2)));  
			return c;
		} catch (NumberFormatException | ApplicationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if(arg2 != null) {
			System.out.println(arg2.getClass().getName());

			return ((Cidade) arg2).getId() == null ? "":((Cidade) arg2).getId().toString();
		}
		return "";
	}
}