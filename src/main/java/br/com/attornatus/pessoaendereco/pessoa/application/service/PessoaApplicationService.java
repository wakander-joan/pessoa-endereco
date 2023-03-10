package br.com.attornatus.pessoaendereco.pessoa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import br.com.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import br.com.attornatus.pessoaendereco.pessoa.application.api.PessoaAlteracaoRequest;
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
	private final EnderecoRepository enderecoRepository;

	@Override
	public PessoaResponse criarPessoa(@Valid PessoaRequest pessoaRequeste) {
		log.info("[inicia] PessoaApplicationService - criaPessoa");
		Pessoa pessoa = pessoaRepository.salva(new Pessoa(pessoaRequeste));
		log.info("[finaliza] PessoaApplicationService - criaPessoa");
		return PessoaResponse.builder().idPessoa(pessoa.getIdPessoa()).build();
	}

	@Override
	public PessoaDetalhadaResponse buscaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - buscaPessoa");
		Pessoa pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - buscaPessoa");
		return new PessoaDetalhadaResponse(pessoa);
	}

	@Override
	public List<PessoaListResponse> buscaTodasPessoas() {
		log.info("[inicia] PessoaApplicationService - buscaTodasPessoas");
		List<Pessoa> pessoas = pessoaRepository.buscaTodasPessoas();
		log.info("[finaliza] PessoaApplicationService - buscaTodasPessoas");
		return PessoaListResponse.converte(pessoas);
	}

	@Override
	public void deletaPessoaPorId(UUID idPessoa) {
		log.info("[inicia] PessoaApplicationService - deletaPessoaPorId");
		pessoaRepository.buscaPessoaPorId(idPessoa);
		List<Endereco> enderecos = enderecoRepository.buscaEnderecosDaPessoa(idPessoa);
		for (Endereco endereco : enderecos) {
			UUID id = endereco.getIdEndereco();
			enderecoRepository.deletaEndereco(id);
		}
		pessoaRepository.deletaPessoaPorId(idPessoa);
		log.info("[finaliza] PessoaApplicationService - deletaPessoaPorId");
	}

	@Override
	public void editaPessoaPorId(UUID idPessoa, @Valid PessoaAlteracaoRequest pessoaAlteracaoRequest) {
		log.info("[inicia] PessoaApplicationService - editaPessoaPorId");
		Pessoa pessoa = pessoaRepository.buscaPessoaPorId(idPessoa);
		pessoa.edita(pessoaAlteracaoRequest);
		pessoaRepository.salva(pessoa);
		log.info("[finaliza] PessoaApplicationService - editaPessoaPorId");
	}
}
