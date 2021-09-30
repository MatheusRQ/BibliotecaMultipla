package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.BibliotecaMultipla.Pessoa.Dublagens;
import br.com.BibliotecaMultipla.Pessoa.Personagem;

/**
 * Classe que representa o controle da tabela de personagens do banco de dados,
 * a partir do programa.
 * 
 * @author Matheus
 * @version 0.3
 */
public class PersonagemDAO {

	Connection connection;

	/**
	 * Construtor do objeto DubladorDAO a partir de uma conexao.
	 */
	public PersonagemDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return uma lista de personagens do Banco de Dados. A lista será uma
	 *         UnmodifiableCollection.
	 */
	public Collection<Personagem> listar() {
		try {
			Collection<Personagem> personagens = new ArrayList<>();
			String sql = "SELECT A.ID, A.NOME, B.NOME AS DUBLADOR, C.NOME AS ANIMACAO FROM PERSONAGEM A INNER JOIN DUBLADOR B ON A.DUBLADOR_ID = B.ID INNER JOIN ANIMACAO C ON A.ANIMACAO_ID = C.ID";
			try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Personagem personagem = new Personagem(rst.getInt(1), rst.getString(2), rst.getString(3),
								rst.getString(4));
						personagens.add(personagem);
					}

				}
			}
			return Collections.unmodifiableCollection(personagens);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Registra um personagem no Banco de Dados.
	 * 
	 * @param personagem
	 */
	public void registrar(Personagem personagem) {
		try {
			String sql = "INSERT INTO PERSONAGEM (NOME, ANIMACAO_ID, DUBLADOR_ID) VALUES (?, ?, ?);";

			try (PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, personagem.getNome());
				pstm.setInt(2, personagem.getOrigem().getId());
				pstm.setInt(3, personagem.getDubladorAtor().getId());
				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						personagem.setID(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * O objetivo desse metodo e buscar uma lista de dubladores e animacoes, usando
	 * a mesma conexao usada para iniciar esse objeto. Assim, o numero de conexoes
	 * abertas sera menor.
	 * 
	 * @return uma lista de dubladores e animacoes.
	 */
	public Dublagens buscaAudioVisualEDublador() {
		AnimacaoDAO animacaoDAO = new AnimacaoDAO(connection);
		DubladorDAO dubladorDAO = new DubladorDAO(connection);
		Dublagens dublagens = new Dublagens(animacaoDAO.listarAnimacoes(), dubladorDAO.listar());
		return dublagens;
	}
}
