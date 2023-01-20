package br.com.attornatus.pessoaendereco.endereco.infra;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.attornatus.pessoaendereco.endereco.application.repository.EnderecoRepository;
import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2	
public class EnderecoInfraRepository implements EnderecoRepository {
	private final EnderecoSpringDataJPARepository enderecoSpringDataJPARepository;
	
	@Transactional(readOnly = true)
	@Override
	public Endereco salva(Endereco endereco) {
		log.info("[inicia] EnderecoInfraRepository  - salva");
		enderecoSpringDataJPARepository.save(endereco);
		log.info("[finaliza] EnderecoInfraRepository  - salva");
		return endereco;
	}

}
