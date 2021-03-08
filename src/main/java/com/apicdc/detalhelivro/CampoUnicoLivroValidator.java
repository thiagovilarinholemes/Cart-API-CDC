package com.apicdc.detalhelivro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public abstract class CampoUnicoLivroValidator implements Validator {
	
	/* Metodos a serem implementados nas classes de verificação */
	public abstract Optional<Livro> buscaLivroPorCampo(NovoLivroForm novoLivroForm);
	protected abstract String getNomeCampoInvalido();	
	
	/* Especifica qual classe a ser verificada */
	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}	
	
	/* Verifica se o campo já existe */
	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;
		
		Optional<Livro> possivelLivro = buscaLivroPorCampo(form);
		
		if(possivelLivro.isPresent()) {
			String nomeCampoInvalido = getNomeCampoInvalido();
			errors.rejectValue(nomeCampoInvalido, null,nomeCampoInvalido+": Já existe um livro igual cadastrado");
		}
	}	
}
