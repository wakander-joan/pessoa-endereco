package br.com.attornatus.pessoaendereco.endereco.application.service;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoRequest;
import br.com.attornatus.pessoaendereco.endereco.application.api.EnderecoResponse;
import br.com.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.pessoa.application.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class EnderecoApplicationService implements EnderecoService {
	private final EnderecoRepository enderecoRepository;
	private final PessoaRepository pessoaRepository;
	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa, @Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoApplicationService - criaEndereco");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		Endereco endereco = enderecoRepository.salva(new Endereco(idPessoa, enderecoRequest));
		log.info("[finaliza] EnderecoApplicationService - criaEndereco");
		return EnderecoResponse.builder().idEndereco( endereco.getIdEndereco()).build();
	}

}
