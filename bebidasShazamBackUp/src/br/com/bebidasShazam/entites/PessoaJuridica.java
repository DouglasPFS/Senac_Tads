package br.com.bebidasShazam.entites;

public abstract class PessoaJuridica extends Pessoa {

	private Integer cnpj;
	private String razaoSocial;

	public PessoaJuridica(String nome, String telefone, Integer cnpj, String razaoSocial) {
		super(nome, telefone);
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
	}

	public PessoaJuridica() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
