package br.com.BibliotecaMultipla.JUnit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;
import br.com.BibliotecaMultipla.DAO.Animacao_N_AssistidoDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;

public class TesteJDBC {

	@Test
	public void DeveInicializarEFecharUmaConexao() {
		try {
			ConnectionFactory factory = new ConnectionFactory();
			Connection connection = factory.recuperarConexao();
			
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * Teste necessita de manutenção
	 */
	@Test
	public void DeveRetornarTrue () {	
		Animacao_N_Assistido ana = new Animacao_N_Assistido(1, "Nome de teste", 2020, "Acao e fantasia", 12, 1, 'A', '+');
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		Animacao_N_AssistidoDAO anaDAO =  new Animacao_N_AssistidoDAO(connection);
		anaDAO.listar().forEach(animacao -> System.out.println(animacao.getNome().equals(ana.getNome())));
	}
}
