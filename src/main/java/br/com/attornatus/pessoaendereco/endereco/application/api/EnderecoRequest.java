package br.com.attornatus.pessoaendereco.endereco.application.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EnderecoRequest {
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
}
