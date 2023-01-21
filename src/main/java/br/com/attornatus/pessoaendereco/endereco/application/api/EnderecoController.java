package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus.pessoaendereco.endereco.application.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class EnderecoController implements EnderecoAPI {
	private final EnderecoService enderecoService;

	@Override
	public EnderecoResponse criaEndereco(UUID idPessoa ,@Valid EnderecoRequest enderecoRequest) {
		log.info("[inicia] EnderecoController  - criaEndereco");
		EnderecoResponse endereco = enderecoService.criaEndereco(idPessoa , enderecoRequest);
		log.info("[finaliza] EnderecoController  - criaEndereco");
		return endereco;
	}

	@Override
	public List<EnderecoListResponse> buscaEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoController  - buscaEnderecosDaPessoa");
		List<EnderecoListResponse> enderecos = enderecoService.buscaEnderecosDaPessoa(idPessoa);
		log.info("[finaliza] EnderecoController  - buscaEnderecosDaPessoa");
		return enderecos;
	}

	@Override
	public void priorizaEndereco(UUID idPessoa, UUID idEndereco) {
		log.info("[inicia] EnderecoController  - priorizaEndereco");
		log.info("[finaliza] EnderecoController  - priorizaEndereco");
	}
}
