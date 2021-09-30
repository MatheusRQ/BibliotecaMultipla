package br.com.BibliotecaMultipla.Factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Classe responsavel por iniciar nao so a DataSource, como tambem recuperar uma
 * conexao sempre que chamada.
 * 
 * @author Matheus
 * @version 0.1
 */
public class ConnectionFactory {

	private DataSource dataSource;

	/**
	 * Construtor do objeto, que tem como funcao iniciar a DataSorce, pegando o Url
	 * da conexao, o nome de usuario e a senha da conexao.
	 */
	public ConnectionFactory() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl("jdbc:mysql://localhost/biblioteca_multipla?useTimezone=true&serverTimezone=UTC");
		cpds.setUser("BibliotecaM");
		cpds.setPassword("BibliotecaM");

		this.dataSource = cpds;
	}

	/**
	 * @return uma conexao da dataSorce.
	 */
	public Connection recuperarConexao() {
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
