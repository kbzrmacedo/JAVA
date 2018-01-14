package br.com.resourceit.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.resourceit.bd.ConnectionFactory;
import br.com.resourceit.model.Dado;

public class DadoDao {

	//	a	conexão	com	o	banco	de	dados
	private	Connection connection;

	public DadoDao() {
		new ConnectionFactory();
		this.connection	= ConnectionFactory.getConnection();

	}
	public void adiciona(Dado dado) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql = "insert into Produto " +
				"(produto,valor,taxa,tipo)"	+
				"	values	(?,?,?,?)";
		try	{
			//	prepared statement para inserção
			stmt = con.prepareStatement(sql);
			//	seta os	valores
			stmt.setString(1,dado.getProduto()); // O 1 É REFERENTE A PRIMEIRA COLUNA
			stmt.setDouble(2,dado.getValor());
			stmt.setDouble(3,dado.getTaxa());
			stmt.setString(4,dado.getTipo());

			//	executa
			stmt.execute();
			stmt.close();
		}	catch (SQLException	e)	{
			throw new RuntimeException(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public List<Dado> getLista() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Dado> dados = new ArrayList<Dado>();
		try	{
			
			stmt = this.connection.
					prepareStatement("select * from Produto");
			rs = stmt.executeQuery();

			while (rs.next()) {
				//	criando	o objeto Contato
				Dado dado = new Dado();
				dado.setCod_prod(rs.getLong("cod_prod"));
				dado.setProduto(rs.getString("produto"));
				dado.setValor(rs.getDouble("valor"));
				dado.setTaxa(rs.getDouble("taxa"));
				dado.setTipo(rs.getString("tipo"));

				//	adicionando	o	objeto	à	lista
				dados.add(dado);
			}
		}catch (SQLException e)	{
			throw new RuntimeException(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return dados;

	}
	public void remover(Dado dado) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM produto WHERE cod_prod = ?");
			stmt.setLong(1, dado.getCod_prod());
			
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public void removerAll() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM produto WHERE cod_prod != ''; ");			
			
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	public void alterId() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {		
			stmt = con.prepareStatement("ALTER TABLE produto AUTO_INCREMENT = 1");
			
			stmt.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
}


