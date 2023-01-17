package br.com.attornatus.pessoaendereco.pessoa.application.service;

import javax.validation.Valid;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;

public interface PessoaService {
	PessoaResponse criarPessoa(@Valid PessoaRequest pessoaRequeste);
}
