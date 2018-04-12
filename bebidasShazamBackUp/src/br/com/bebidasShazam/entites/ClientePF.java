package br.com.bebidasShazam.entites;

import java.util.ArrayList;

public class ClientePF extends PessoaFisica {
	private Integer id_clientePF;
	private ArrayList<Pedidos> pedidos;
	private int endereco;

	public ClientePF() {
		// TODO Auto-generated constructor stub
	}

	public ClientePF(Integer cpf, String nome, String telefone, Integer id_clientePF, ArrayList<Pedidos> pedidos,
			int endereco) {
		super(cpf, nome, telefone);
		this.setId_clientePF(id_clientePF);
		this.setPedidos(pedidos);
		this.setEndereco(endereco);
	}

	public Integer getId_clientePF() {
		return id_clientePF;
	}

	public void setId_clientePF(Integer id_clientePF) {
		this.id_clientePF = id_clientePF;
	}

	public ArrayList<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}

	public int getEndereco() {
		return endereco;
	}

	public void setEndereco(int idEndereco) {
		this.endereco = idEndereco;
	}

}
