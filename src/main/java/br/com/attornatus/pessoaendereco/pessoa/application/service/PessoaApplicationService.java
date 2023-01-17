package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaDetalhadaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaListResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaRequest;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaResponse;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaApplicationService implements PessoaService {
	private final PessoaRepository pessoaRepository;
	
	@Override
	public PessoaResponse criarPessoa(@Valid PessoaRequest pessoaRequeste) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequeste));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder().idPessoa(pessoa.getIdPessoa()).build();
	}

	@Override
	public PessoaDetalhadaResponse buscaPessoa(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaPessoa");
		Pessoa pessoa = pessoaRepository.buscaPessoa(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaPessoa");
		return new PessoaDetalhadaResponse(pessoa);
	}

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
		log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
		return null;
	}

}
