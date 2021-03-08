package com.apicdc.site.detalhe;

import com.apicdc.detalhelivro.Autor;

public class AutorLivroDetalheDTO {

	private String nome;
	private String descricao;

	public AutorLivroDetalheDTO(Autor autor) {
		nome = autor.getNome();
		descricao = "Aqui precisa vir uma descrição";
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	

}
