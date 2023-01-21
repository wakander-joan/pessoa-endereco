package br.com.attornatus.pessoaendereco.endereco.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;


public interface EnderecoRepository {
	Endereco salva(Endereco endereco);
	List<Endereco> buscaEnderecosDaPessoa(UUID idPessoa);
}
