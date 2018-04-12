package br.com.bebidasShazam.entites;

import java.util.ArrayList;

public class ClientePJ extends PessoaJuridica{
	private Integer id_clientePJ;
	private ArrayList<Pedidos> pedidos;
	private int endereco;
	public ClientePJ() {
		// TODO Auto-generated constructor stub
	}
	public ClientePJ(String nome, String telefone, Integer cnpj, String razaoSocial, Integer id_clientePJ,
			ArrayList<Pedidos> pedidos, int endereco) {
		super(nome, telefone, cnpj, razaoSocial);
		this.setId_clientePJ(id_clientePJ);
		this.setPedidos(pedidos);
		this.setEndereco(endereco);
	}
	public Integer getId_clientePJ() {
		return id_clientePJ;
	}
	public void setId_clientePJ(Integer id_clientePJ) {
		this.id_clientePJ = id_clientePJ;
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
	public void setEndereco(int endereco) {
		this.endereco = endereco;
	}
	
	
	
}
