package com.apicdc.site.detalhe;


import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.apicdc.detalhelivro.Livro;
import com.apicdc.detalhelivro.LivroRepository;


@RestController
public class DetalheLivroController {
	
	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/api/livro/{id}")
	public LivroDetalheDTO exibeDetalhesLivro(@PathVariable("id") Long id) {
		Livro livro = livroRepository.findById(id).get();
		
		/* Pode ser utilizado o orElseTrow para retornar um erro 404 */
//		Livro livro = livroRepository.findById(id).orElseThrow()->Criar_a_exception ;
		
		return new LivroDetalheDTO(livro);
	}
	
	/* HttpServletResponse response escreve no http */
	@PostMapping(value = "/api/carrinho/{idLivro}")
	public String adionaLivroCarrinho(@PathVariable("idLivro") Long idLivro, @CookieValue("carrinho") Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException { // @CookieValue("carrinho") recebe o cookie enviado pela web
		/* Mapea o objeto jsonCarrinho - json, vindo do cookie do cliente e mapea para a classe Carrinho.class 
		 * .orElse(new Carrinho()) se não tiver nada no carrinho cria um novo carrinho 
		 */
		Carrinho carrinho = jsonCarrinho.map(json -> {
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho()); //.orElse(new Carrinho()) se não tiver nada no carrinho cria um novo carrinho 
		
		/* Verifica se o carrinho foi criado */
//		System.out.print("carrinho criado");
		
		/* Adiciona o livro ao carrinho*/
		carrinho.adiciona(livroRepository.findById(idLivro).get());
		
		/* Adiciona um cookie na página enviada */
		Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
		
		/* O navegador cliente não irá escrever no cookie */
		cookie.setHttpOnly(true);
		
		/* Escreve no Header da resposta enviada */
		response.addCookie(cookie);
		return carrinho.toString();
		/*
		 * receber o carrinho pelo cookie(json)
		 * se não tiver ainda cookie para o carrinho, então cria um novo carrinho
		 * precisa de capa, titulo e preço do livro
		 */
	}

}
