package br.com.attornatus.pessoaendereco.endereco.application.api;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EnderecoRequest {
	@NotBlank
	private String logradouro;
	@NotBlank
	private String cep;
	@NotBlank
	private String numero;
	@NotBlank
	private String cidade;
}
