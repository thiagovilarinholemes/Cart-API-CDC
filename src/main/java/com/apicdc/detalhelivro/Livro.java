package com.apicdc.detalhelivro;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 100)
	private String titulo;
	@NotBlank
	@Size(max = 50)
	private String subTitulo;
	@Min(20)
	private BigDecimal preco;
	@NotBlank
	private String conteudo;
	@NotBlank
	private String sumario;
	@Min(100)
	private int numeroPaginas;
	@NotBlank
	private String isbn;
	@NotBlank 
	@URL
	private String linkCapaLivro;
	
	@NotNull
	@ManyToOne
	private Autor autor;
	
	@Deprecated
	public Livro() {
		super();
	}
	public Livro(@NotBlank @Size(max = 100) String titulo, @NotBlank @Size(max = 50) String subTitulo,
			@Min(20) BigDecimal preco, @NotBlank String conteudo, @NotBlank String sumario, @Min(100) int numeroPaginas,
			@NotBlank String isbn, @NotBlank @URL String linkCapaLivro, @NotNull Autor autor) {
		super();
		this.titulo = titulo;
		this.subTitulo = subTitulo;
		this.preco = preco;
		this.conteudo = conteudo;
		this.sumario = sumario;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.linkCapaLivro = linkCapaLivro;
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", subTitulo=" + subTitulo + ", preco=" + preco + ", conteudo=" + conteudo
				+ ", sumario=" + sumario + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", linkCapaLivro="
				+ linkCapaLivro + ", autor=" + autor + "]";
	}
	public Long getId() {
		return id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public Autor getAutor() {
		return autor;
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
		return sumario;
	}
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	public String getIsbn() {
		return isbn;
	}
	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}
	
	
}
