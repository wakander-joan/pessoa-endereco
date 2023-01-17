package br.com.attornatus.pessoaendereco.pessoa.application.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoaendereco.pessoa.application.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PessoaController implements PessoaAPI {
	private final PessoaService pessoaService;

	@Override
	public PessoaResponse criaPessoa(@Valid PessoaRequest pessoaRequeste) {
		log.info("[inicia] PessoaController - criaPessoa");
		PessoaResponse pessoa = pessoaService.criarPessoa(pessoaRequeste);
		log.info("[finaliza] PessoaController - criaPessoa");
		return pessoa;
	}

}
