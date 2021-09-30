package br.com.BibliotecaMultipla.JUnit;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_Assistido;
import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;
import br.com.BibliotecaMultipla.Categoria.CategoriaEnum;
import br.com.BibliotecaMultipla.DAO.AnimacaoDAO;
import br.com.BibliotecaMultipla.DAO.DubladorDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;
import br.com.BibliotecaMultipla.Pessoa.Dublador;

public class TesteJDBC {
	
	private Connection connection;
	private Timestamp timestamp;
	private Date date;
	Animacao_N_Assistido ana;
	
	@BeforeEach
	public void Inicialização() {
		this.connection = new ConnectionFactory().recuperarConexao();
		int myYear = 2014;
		int myMonth = 3;
		int myDay = 24;
		this.timestamp = Timestamp.valueOf(String.format("%04d-%02d-%02d 00:00:00", myYear, myMonth, myDay));
		this.date = Date.valueOf(String.format("%04d-%02d-%02d", myYear, myMonth, myDay));
		ana = new Animacao_N_Assistido(2, "Nome de teste", 2020, "Acao e fantasia", timestamp,
				CategoriaEnum.ANIMACAO_ORIENTAL.categoriaNome(), 12, "++", "A");
	}

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
	public void DeveRetornarTrue() {
		AnimacaoDAO anaDAO = new AnimacaoDAO(connection);
		anaDAO.listarNaoAssistido().forEach(animacao -> Assert.assertEquals(animacao.getNome(), ana.getNome()));
	}

	@Test
	public void DeveRetornarUmaExceptionPorSerUmaUnmodifiableCollection() {
		AnimacaoDAO anaDAO = new AnimacaoDAO(connection);
		Assert.assertThrows(UnsupportedOperationException.class, () -> anaDAO.listarNaoAssistido().add(ana));
	}

	/**
	 * Teste necessita de manutenção
	 */
//	@Test
//	public void DeveRetornarTrueParaAssistidos() {
//		Animacao_Assistido aa = new Animacao_Assistido(3, "Nome de teste ASSISTIDO", 2020, "Acao e fantasia", timestamp,
//				"ANIMACAO ORIENTAL", 12, timestamp, 6.0);
//		AnimacaoDAO anaDAO = new AnimacaoDAO(connection);
//		anaDAO.listarAssistido().forEach(animacao -> Assert.assertEquals(animacao.getNome(), aa.getNome()));
//	}

	@Test
	public void TemInserirInformacoesNaTabelaDeNaoAssistidoDoMySQL() {
		AnimacaoDAO anaDAO = new AnimacaoDAO(connection);
		anaDAO.registrarAnimacaoNAssistido(ana);
	}

	@Test
	public void TemInserirInformacoesNaTabelaDeAssistidoDoMySQL() {
		AnimacaoDAO anaDAO = new AnimacaoDAO(connection);
		Animacao_Assistido aa = new Animacao_Assistido(2, "Nome de teste", 2020, "Acao e fantasia", timestamp,
				CategoriaEnum.ANIMACAO_ORIENTAL.categoriaNome(), 12, timestamp, 6.7);
		anaDAO.registrarAnimacaoAssistido(aa);
	}

	@Test
	public void TemQueInserirUmDubladorNoMySQL() {
		try {
			DubladorDAO dubladorDAO = new DubladorDAO(connection);

			Dublador dublador = new Dublador(1, "Dublador de Teste", date);
			dubladorDAO.registrar(dublador);
		} catch (Exception e) {
			e.getStackTrace();
			fail();
		}
	}
}
