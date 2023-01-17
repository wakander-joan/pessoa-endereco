package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Value;

@Value
public class PessoaListResponse {
	private UUID idPessoa;
	private String nomePessoa;
	private LocalDate dataNascimento;
}
