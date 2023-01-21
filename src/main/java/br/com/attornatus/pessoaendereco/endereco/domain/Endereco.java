package br.com.attornatus.pessoaendereco.endereco.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", name = "id", updatable = false, unique = true, nullable = false)
	private UUID idEndereco;
	@Column(columnDefinition = "uuid", name = "idPessoa", updatable = false, unique = false, nullable = false)
	@NotNull
	private UUID idPessoa;
	@NotNull
	private String logradouro;
	@NotNull
	private String cep;
	@NotNull
	private String numero;
	@NotBlank
	private String cidade;
	private boolean Principal = false;
	
	public Endereco(UUID idPessoa,@Valid EnderecoRequest enderecoRequest) {
		this.idPessoa = idPessoa;
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
	}
	
	
}









