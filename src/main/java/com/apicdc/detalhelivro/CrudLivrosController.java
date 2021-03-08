package com.apicdc.detalhelivro;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudLivrosController {
	
	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private Uploader uploader;
	@Autowired
	private LivroRepository livroRepository;
	
	/* Não deixa que ocorra o mesmo nome do Título e do ISBN */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(new IsbnUnicoValidator(livroRepository), new TituloLivroUnicoValidator(livroRepository) );
	}

	@PostMapping(value = "/api/livro")
	@Transactional
	public void novoLivro(@Valid NovoLivroForm form) {
		Livro livro = form.novoLivro(autorRepository, uploader);
		livroRepository.save(livro); 
	}
}
