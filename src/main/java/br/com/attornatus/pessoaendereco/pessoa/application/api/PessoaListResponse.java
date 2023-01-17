package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.Value;

@Value
public class PessoaListResponse {
	private UUID idPessoa;
	private String nomePessoa;
	private LocalDate dataNascimento;
	
	public static List<PessoaListResponse> converte(List<Pessoa> pessoa) {
		return pessoa.stream().map(c -> new PessoaListResponse(c)).collect(Collectors.toList());
	}

	public PessoaListResponse(Pessoa pessoa) {
		super();
		this.idPessoa = pessoa.getIdPessoa();
		this.nomePessoa = pessoa.getNomePessoa();
		this.dataNascimento = pessoa.getDataNascimento();
	}

	
}
