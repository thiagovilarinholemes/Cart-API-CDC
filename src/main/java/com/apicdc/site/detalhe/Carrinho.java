package com.apicdc.site.detalhe;

import java.util.ArrayList;
import java.util.List;

import com.apicdc.detalhelivro.Livro;

public class Carrinho {
	
	private List<LivroCarrinhoDTO> livros = new ArrayList<>();

	public void adiciona(Livro livro) {
		livros.add(new LivroCarrinhoDTO(livro));		
	}

	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

	public List<LivroCarrinhoDTO> getLivros() {
		return livros;
	}

}
