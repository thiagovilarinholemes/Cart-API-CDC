package com.apicdc.site.detalhe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apicdc.detalhelivro.Livro;
import com.apicdc.detalhelivro.LivroRepository;

@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO getMethodName(@PathVariable("id") Long id) {
		Livro livro = livroRepository.findById(id).get();
		
		/* Pode ser utilizado o orElseTrow para retornar um erro 404 */
//		Livro livro = livroRepository.findById(id).orElseThrow()->Criar_a_exception ;
		
		return new LivroDetalheDTO(livro);
	}

}
