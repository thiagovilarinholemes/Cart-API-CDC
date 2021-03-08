package com.apicdc.site.detalhe;

import java.math.BigDecimal;

import com.apicdc.detalhelivro.Livro;
import com.apicdc.shared.Markdown;

public class LivroDetalheDTO {

	private Long id;
	private String titulo;
	private String subTitulo;
	private BigDecimal preco;
	private String conteudo;
	private String sumarioOriginal;
	private int numeroPaginas;
	private String isbn;
	private AutorLivroDetalheDTO autor;
	private String sumarioHtml;

	public LivroDetalheDTO(Livro livro) {
		id = livro.getId();
		titulo = livro.getTitulo();
		subTitulo = livro.getSubTitulo();
		preco = livro.getPreco();
		conteudo = livro.getConteudo();
		sumarioOriginal = livro.getSumario();
		sumarioHtml = Markdown.renderHtml(livro.getSumario()); // O Markdown está localizado na classe /shared/Markdown
		autor = new AutorLivroDetalheDTO(livro.getAutor());
		numeroPaginas = livro.getNumeroPaginas();
		isbn = livro.getIsbn();
		
	}
	
	public String getSumarioHtml() {
		return sumarioHtml;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getSumario() {
		return sumarioOriginal;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public AutorLivroDetalheDTO getAutor() {
		return autor;
	}
	 
	public String getSumarioOriginal() {
		return sumarioOriginal;
	}
}
