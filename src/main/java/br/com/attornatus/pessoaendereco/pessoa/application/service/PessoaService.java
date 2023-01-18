package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaDetalhadaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criarPessoa(@Valid PessoaRequest pessoaRequeste);
	PessoaDetalhadaResponse buscaPessoaPorId(UUID idPessoa);
	List<PessoaListResponse> buscaTodasPessoas();
	void deletaPessoaPorId(UUID idPessoa);
}
