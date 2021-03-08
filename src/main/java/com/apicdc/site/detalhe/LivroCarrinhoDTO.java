package com.apicdc.site.detalhe;

import java.math.BigDecimal;


import com.apicdc.detalhelivro.Livro;

public class LivroCarrinhoDTO {

	private String titulo;
	private BigDecimal preco;
	private String linkCapaLivro;

	public LivroCarrinhoDTO(Livro livro) {
		titulo = livro.getTitulo();
		preco = livro.getPreco();
		linkCapaLivro = livro.getLinkCapaLivro();
	}
	
	@Deprecated
	public LivroCarrinhoDTO() {
		super();
	}

	public String getTitulo() {
		return titulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [titulo=" + titulo + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}
	
	
}
