package com.apicdc.site;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apicdc.detalhelivro.Livro;
import com.apicdc.detalhelivro.LivroRepository;

@RestController
public class HomeController {

	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping(value = "/api/home")
	public Collection<LivroParaHome> lista() { // Iterable é o que retorna do repository
		return livroRepository.findAll().stream().map(LivroParaHome :: new).collect(Collectors.toList());
	}

}
