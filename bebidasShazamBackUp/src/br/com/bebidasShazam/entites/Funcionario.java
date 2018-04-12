package br.com.bebidasShazam.entites;

public class Funcionario extends PessoaFisica{
	private Integer id_funcionario;
	private Integer cargo;
	private Endereco endereco;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario(Integer cargo, Endereco endereco, Integer cpf, String nome, String telefone) {
		super(cpf, nome, telefone);
		this.cargo = cargo;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getCargo() {
		return cargo;
	}
	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}
	public Integer getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
}
