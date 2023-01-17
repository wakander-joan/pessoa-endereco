package br.com.attornatus.pessoaendereco.pessoa.application.api;

import java.util.List;
import java.util.UUID;

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

	@Override
	public PessoaDetalhadaResponse buscaPessoa(UUID idPessoa) {
		log.info("[inicia] PessoaController - buscaPessoaAtravesId");
		PessoaDetalhadaResponse pessoa = pessoaService.buscaPessoa(idPessoa);
		log.info("[finaliza] PessoaController - buscaPessoaAtravesId");
		return pessoa;
	}

	@Override
	public List<PessoaListResponse> buscarTodasPessoas() {
		log.info("[inicia] PessoaController - buscarTodasPessoas");
		List<PessoaListResponse> lista = pessoaService.buscaTodasPessoas();
		log.info("[finaliza] PessoaController - buscarTodasPessoas");
		return null;
	}

}
