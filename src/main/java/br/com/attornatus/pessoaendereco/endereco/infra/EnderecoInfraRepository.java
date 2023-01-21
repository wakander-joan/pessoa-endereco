package br.com.attornatus.pessoaendereco.endereco.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2	
public class EnderecoInfraRepository implements EnderecoRepository {
	private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;
	
	@Override
	public Endereco salva(Endereco enderecoCriado) {
		log.info("[inicia] EnderecoInfraRepository  - salva");
		enderecoSpringDataJPARepository.save(enderecoCriado);
		log.info("[finaliza] EnderecoInfraRepository  - salva");
		return enderecoCriado;
	}

	@Override
	public List<Endereco> buscaEnderecosDaPessoa(UUID idPessoa) {
		log.info("[inicia] EnderecoInfraRepository  - buscaEnderecosDaPessoa");
		List<Endereco> enderecos = enderecoSpringDataJPARepository.findAllByIdPessoa(idPessoa);
		log.info("[finaliza] EnderecoInfraRepository  - buscaEnderecosDaPessoa");
		return enderecos;
	}

}
