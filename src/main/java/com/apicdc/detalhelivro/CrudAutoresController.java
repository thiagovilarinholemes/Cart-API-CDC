package com.apicdc.detalhelivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudAutoresController {
	
	/* Cria a persistencia de dados no BD */
//	@PersistenceContext
//	private EntityManager manager;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping(value = "/api/autor")
	@Transactional
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		autorRepository.save(novoAutor);
	}
}
