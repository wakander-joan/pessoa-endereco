package br.com.attornatus.pessoaendereco.pessoa.domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idPessoa;
	@NotBlank
	private String nomePessoa;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	
	public Pessoa(PessoaRequest pessoaRequest) {
		this.nomePessoa = pessoaRequest.getNomePessoa();
		this.dataNascimento = pessoaRequest.getDataNascimento();
	}


	public void edita(@Valid PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		this.nomePessoa = pessoaAlteracaoRequest.getNomePessoa();
		this.dataNascimento = pessoaAlteracaoRequest.getDataNascimento();
	}
	
	
}
