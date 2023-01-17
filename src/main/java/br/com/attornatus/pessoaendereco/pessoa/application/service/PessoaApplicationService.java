package br.com.attornatus.pessoaendereco.pessoa.application.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {

	@Override
	public PessoaResponse criarPessoa(@Valid PessoaRequest pessoaRequeste) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return null;
	}

}
