package br.com.attornatus.pessoaendereco.pessoa.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.attornatus.pessoaendereco.pessoa.domain.Pessoa;

public interface PessoaRepository {
	Pessoa salva(Pessoa pessoa);
	Pessoa buscaPessoa(UUID idPessoa);
	List<Pessoa> buscaTodasPessoas();
}
