package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PessoaAlteracaoRequest {
	private String nomePessoa;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
}
