package br.com.BibliotecaMultipla.JUnit;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;
import br.com.BibliotecaMultipla.Categoria.Categoria;
import br.com.BibliotecaMultipla.DAO.Animacao_N_AssistidoDAO;
import br.com.BibliotecaMultipla.DAO.CategoriaDAO;
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
	
	@Test
	public void DeveRetornarTrue () {
		//2, nome: Nome de teste, Ano de Lançamento: 2020, Generos: Acao e fantasia, Data de Registro: 2021-09-16 06:57:43.0, numero de episodios: 12, categoria: , prioridade: ++, relevancia: A
		int myYear = 2014;
		int myMonth = 3;
		int myDay = 24;
		Timestamp ts = Timestamp.valueOf(String.format("%04d-%02d-%02d 00:00:00", 
		                                                myYear, myMonth, myDay));

		Animacao_N_Assistido ana = new Animacao_N_Assistido(2, "Nome de teste", 2020, "Acao e fantasia", ts, "ANIMACAO ORIENTAL", 12 , "++", "A");
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		Animacao_N_AssistidoDAO anaDAO =  new Animacao_N_AssistidoDAO(connection);
		anaDAO.listar().forEach(animacao -> Assert.assertEquals(animacao.getNome(), ana.getNome()));
	}
	
	@Test
	public void DeveRetornarTrueSobreCategorias() {
		Categoria categoria = new Categoria(1, "ANIMACAO ORIENTAL");
		
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
		categoriaDAO.listar().forEach(ctgr -> Assert.assertEquals(ctgr.getNome(), categoria.getNome()));
	}
	
	@Test
	public void DeveRetornarUmaExceptionPorSerUmaUnmodifiableCollection() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		Animacao_N_AssistidoDAO anaDAO =  new Animacao_N_AssistidoDAO(connection);
		
		int myYear = 2014;
		int myMonth = 3;
		int myDay = 24;
		Timestamp ts = Timestamp.valueOf(String.format("%04d-%02d-%02d 00:00:00", 
		                                                myYear, myMonth, myDay));
		Animacao_N_Assistido ana = new Animacao_N_Assistido(2, "Nome de teste", 2020, "Acao e fantasia", ts, "ANIMACAO ORIENTAL", 12 , "++", "A");
		
		Assert.assertThrows(UnsupportedOperationException.class, () -> anaDAO.listar().add(ana));
	}
}
