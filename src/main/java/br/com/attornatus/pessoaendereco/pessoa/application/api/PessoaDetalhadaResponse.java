package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaDetalhadaResponse {
	private UUID idPessoa;
	private String nomePessoa;
	private LocalDate dataNascimento;

	public PessoaDetalhadaResponse(Pessoa pessoa) {
		this.idPessoa = pessoa.getIdPessoa();
		this.nomePessoa = pessoa.getNomePessoa();
		this.dataNascimento = pessoa.getDataNascimento();
	}
}
