package com.apicdc.detalhelivro;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.URL;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @NotBlank String nome;
	private @NotBlank @URL String linkGithub;
	
	/* instante em que foi criado */
	@PastOrPresent
	private LocalDateTime createdAt = LocalDateTime.now(); 
	
	@Deprecated
	public Autor() {
	}

	public Autor(@NotBlank String nome, @NotBlank @URL String linkGithub) {
		this.nome = nome;
		this.linkGithub = linkGithub;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", linkGithub=" + linkGithub + ", createdAt=" + createdAt + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
