package br.com.BibliotecaMultipla.MainMethod;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.BibliotecaMultipla.DAO.AnimacaoDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;

public class TestandoTrocaAnimacao {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			AnimacaoDAO dao = new AnimacaoDAO(connection);
			dao.finalizaAnimacao(1, 8.0);
		}
	}
}
