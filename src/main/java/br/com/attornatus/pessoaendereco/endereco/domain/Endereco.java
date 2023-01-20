package br.com.attornatus.pessoaendereco.endereco.domain;

import static br.com.attornatus.pessoaendereco.endereco.domain.Prioridade.PRINCIPAL;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private UUID idPessoa;
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
	private Prioridade Prioridade = PRINCIPAL ;
	
	public Endereco(UUID idPessoa ,EnderecoRequest enderecoRequest) {
		this.idPessoa = idPessoa;
		this.logradouro = enderecoRequest.getLogradouro();
		this.cep = enderecoRequest.getCep();
		this.numero = enderecoRequest.getNumero();
		this.cidade = enderecoRequest.getCidade();
	}
	
	
}









