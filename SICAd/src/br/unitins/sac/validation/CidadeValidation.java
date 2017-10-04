package br.unitins.sac.validation;

import java.util.ArrayList;
import java.util.List;

import br.unitins.frame.application.ValidationException;
import br.unitins.frame.validation.Validation;
import br.unitins.sac.model.Cidade;

public class CidadeValidation implements Validation<Cidade> {
	List<String> listMessages;
	
	@Override
	public void validate(Cidade t) throws ValidationException {
		
		if (t.getNome() == null || t.getNome().equals(""))
			getlistMessages().add("O nome deve ser informado!");
		
		if (getlistMessages().size() > 0)
			throw new ValidationException(getlistMessages());
	}

	public List<String> getlistMessages() {
		if (listMessages == null)
			listMessages = new ArrayList<String>();
		return listMessages;
	}

	public void setlistMessages(List<String> listMessages) {
		this.listMessages = listMessages;
	}
}
