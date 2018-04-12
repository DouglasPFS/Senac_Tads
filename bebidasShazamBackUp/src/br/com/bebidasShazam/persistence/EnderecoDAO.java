package br.com.bebidasShazam.persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;

import br.com.bebidasShazam.entites.Endereco;

public class EnderecoDAO extends DAO {

	public Integer insertEndereco(Endereco endereco) throws Exception {

		abreConexao();

		int idEndereco = 0;

		String query = "insert into endereco(logradouro, bairro, " + "cep, cidade, estado) values (?,?,?,?,?)";

		stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

		stmt.setString(1, endereco.getLogradouro());
		stmt.setString(2, endereco.getBairro());
		stmt.setString(3, endereco.getCep());
		stmt.setString(4, endereco.getCidade());
		stmt.setString(5, endereco.getEstado());

		rs = stmt.getGeneratedKeys();

		while (rs.next()) {

			idEndereco = rs.getInt(1);

		}

		stmt.execute();

		stmt.close();

		fechaConexao();

		return idEndereco;

	}

	public Endereco findById(Integer idEndereco) throws Exception {

		abreConexao();

		String query = "select * from endereco where id_endereco = ?";

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idEndereco);

		rs = stmt.executeQuery();

		Endereco endereco = new Endereco();

		while (rs.next()) {

			endereco.setIdEndereco(rs.getInt("id_endereco"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCep(rs.getString("cep"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));

		}

		stmt.close();

		fechaConexao();

		return endereco;

	}

	public void deleteEndereco(Integer idEndereco) throws Exception {

		abreConexao();

		String query = "delete from endereco where id_endereco = ?";

		stmt = con.prepareStatement(query);

		stmt.setInt(1, idEndereco);

		stmt.execute();

		stmt.close();

		fechaConexao();

	}

	public ArrayList<Endereco> findAll() throws Exception {

		String query = "select * from endereco";

		stmt = con.prepareStatement(query);

		rs = stmt.executeQuery();

		Endereco endereco = new Endereco();

		ArrayList<Endereco> lista = new ArrayList<>();

		while (rs.next()) {

			endereco.setIdEndereco(rs.getInt("id_endereco"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCep(rs.getString("cep"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));

			lista.add(endereco);

		}

		stmt.close();

		fechaConexao();

		return lista;

	}

}
