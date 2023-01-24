package br.com.attornatus.pessoaendereco.endereco.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.attornatus.pessoaendereco.endereco.domain.Endereco;
import lombok.Getter;
import lombok.Value;

@Getter
@Value
public class EnderecoListResponse {
	private UUID idEndereco;
	private UUID idPessoa;
	private String logradouro;
	private String cep;
	private String numero;
	private String cidade;
	private boolean Principal;

	public static List<EnderecoListResponse> converte(List<Endereco> enderecos) {
		return enderecos.stream().map(c -> new EnderecoListResponse(c)).collect(Collectors.toList());
	}

	public EnderecoListResponse(Endereco enderecos) {
		super();
		this.idEndereco = enderecos.getIdEndereco();
		this.idPessoa = enderecos.getIdPessoa();
		this.logradouro = enderecos.getLogradouro();
		this.cep = enderecos.getCep();
		this.numero = enderecos.getNumero();
		this.cidade = enderecos.getCidade();
		this.Principal = enderecos.isPrincipal();
	}
}