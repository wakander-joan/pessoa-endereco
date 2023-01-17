package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PessoaDetalhadaResponse {
	private UUID idPessoa;
	private String nomePessoa;
	private LocalDate dataNascimento;
}
