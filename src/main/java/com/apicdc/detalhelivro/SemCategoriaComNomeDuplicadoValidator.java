package com.apicdc.detalhelivro;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SemCategoriaComNomeDuplicadoValidator implements Validator {

	private CategoriaRepository categoriaRepository;;
			
	public SemCategoriaComNomeDuplicadoValidator(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	/* Qual classe deve ser aplicado o supports */
	@Override
	public boolean supports(Class<?> clazz) {		
		return NovaCategoriaForm.class.isAssignableFrom(clazz);
	}

	/* Faz a validação */
	@Override
	public void validate(Object target, Errors errors) {
		NovaCategoriaForm form = (NovaCategoriaForm) target;
		Optional<Categoria> possivelCategoria =  categoriaRepository.findByNome(form.getNome());
		
		if(possivelCategoria.isPresent()) {
			errors.rejectValue("nome", "", "Já existe uma categoria com esse nome");
		}
	}
		

}
