package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EnderecoResponse {
	private UUID idEndereco;
}
