package br.com.bebidasShazam.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import br.com.bebidasShazam.entites.ClientePF;

public class ClientePFDAO extends DAO {
	
	public void insertClientePf(ClientePF cliente) throws Exception {
		abreConexao();

		String query = "insert into cliente_pf (nome, telefone, cpf" + ",endereco) values (?,?,?,?)";
		stmt = con.prepareStatement(query);

		stmt.setString(1, cliente.getNome());
		stmt.setString(2, cliente.getTelefone());
		stmt.setInt(3, cliente.getCpf());
		stmt.setInt(4, cliente.getEndereco());

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ClientePF findByCpf(int cpf) throws Exception {
		abreConexao();

		String query = "select * from cliente_pf where cpf = ?";

		stmt = con.prepareStatement(query);

		stmt.setInt(1, cpf);

		rs = stmt.executeQuery();

		ClientePF cliente = new ClientePF();

		while (rs.next()) {
			cliente.setId_clientePF(rs.getInt("id_cliente_pf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setTelefone(rs.getString("telefone"));
			cliente.setCpf(rs.getInt("cpf"));
			cliente.setEndereco(rs.getInt("endereco"));
		}

		stmt.close();

		fechaConexao();

		return cliente;

	}

	public void deleteClientePf(int cpf) throws Exception {

		abreConexao();

		String query = "delete from cliente_pf where cpf = ?";

		stmt = con.prepareStatement(query);

		stmt.setInt(1, cpf);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ArrayList<ClientePF> findAll() throws Exception {

		String query = "select * from cliente_pf";

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		ClientePF cliente = new ClientePF();

		ArrayList<ClientePF> lista = new ArrayList();

		while (rs.next()) {

			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setInt(3, cliente.getCpf());
			stmt.setInt(4, cliente.getEndereco());

			lista.add(cliente);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}
}
