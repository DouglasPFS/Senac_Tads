package br.com.bebidasShazam.persistence;

import java.util.ArrayList;

import br.com.bebidasShazam.entites.ClientePF;
import br.com.bebidasShazam.entites.ClientePJ;;

public class ClientePJDAO extends DAO{
	
	public void insertClientePj(ClientePJ cliente) throws Exception {
		abreConexao();

		String query = "insert into cliente_pj (nome, telefone, cnpj"
		+ ",endereco) values (?,?,?,?)";
		stmt = con.prepareStatement(query);

		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.setInt(3, cliente.getCnpj());
		stmt.setInt(4, cliente.getEndereco());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ClientePJ findByCpf(int cnpj) throws Exception {
		abreConexao();

		String query = "select * from cliente_pj where cnpj = ?";

		stmt = con.prepareStatement(query);

		stmt.setInt(1, cnpj);

		rs = stmt.executeQuery();

		ClientePJ cliente = new ClientePJ();

		while (rs.next()) {
			cliente.setId_clientePJ(rs.getInt("id_cliente_pf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCnpj(rs.getInt("cnpj"));
			cliente.setEndereco(rs.getInt("endereco"));
		}

		stmt.close();

		fechaConexao();

		return cliente;

	}

	public void deleteClientePf(int cnpj) throws Exception {

		abreConexao();

		String query = "delete from cliente_pj where cnpj = ?";

		stmt = con.prepareStatement(query);

		stmt.setInt(1, cnpj);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ArrayList<ClientePJ> findAll() throws Exception {

		String query = "select * from cliente_pj";

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		ClientePJ cliente = new ClientePJ();

		ArrayList<ClientePJ> lista = new ArrayList();

		while (rs.next()) {

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setInt(3, cliente.getCnpj());
			stmt.setInt(4, cliente.getEndereco());

			lista.add(cliente);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}
}


