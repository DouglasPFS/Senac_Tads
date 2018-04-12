package br.com.bebidasShazam.entites;

public abstract class PessoaFisica extends Pessoa {

	private Integer cpf;

	public PessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public PessoaFisica(Integer cpf, String nome, String telefone) {
		super(nome, telefone);
		this.setCpf(cpf);
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

}
