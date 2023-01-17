package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PessoaRequest {
	@NotBlank
	private String nomePessoa;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
}
