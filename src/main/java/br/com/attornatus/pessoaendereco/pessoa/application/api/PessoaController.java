package br.com.attornatus.pessoaendereco.pessoa.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PessoaController implements PessoaAPI {

	@Override
	public PessoaResponse criaPessoa(@Valid PessoaRequest clienteRequeste) {
		log.info("[inicia] PessoaController - criaPessoa");
		log.info("[finaliza] PessoaController - criaPessoa");
		return null;
	}

}
