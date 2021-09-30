package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;
import br.com.BibliotecaMultipla.Pessoa.Dublador;
import br.com.BibliotecaMultipla.Pessoa.Personagem;

/**
 * Classe que representa o controle da tabela de dubladores do banco de dados, a
 * partir do programa.
 * 
 * @author Matheus
 * @version 0.1
 */
public class DubladorDAO {

	Connection connection;

	/**
	 * Construtor do objeto DubladorDAO a partir de uma conexao.
	 */
	public DubladorDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @return uma lista de dubladores do Banco de Dados. A lista será uma
	 *         UnmodifiableCollection.
	 */
	public Collection<Dublador> listar() {
		try {
			Collection<Dublador> dubladores = new ArrayList<>();
			String sql = "SELECT ID, NOME, NASCIMENTO FROM DUBLADOR";

			try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Dublador dublador = new Dublador(rst.getInt(1), rst.getString(2), rst.getDate(3));
						dubladores.add(dublador);
					}

				}
			}
			return Collections.unmodifiableCollection(dubladores);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Registra um dublador no Banco de dados.
	 * 
	 * @param dublador
	 */
	public void registrar(Dublador dublador) {
		try {
			String sql = "INSERT INTO DUBLADOR(NOME, NASCIMENTO) VALUES (?, ?)";

			try (PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				pstm.setString(1, dublador.getNome());
				pstm.setDate(2, dublador.getDataDeNascimento());
				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						dublador.setID(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @param id
	 * @return uma lista das dublagens feitas pelo dublador. Vai mostrar o
	 *         personagem e seu audio visual de origem.
	 */
	public Map<Personagem, AudioVisual> listarDublagens(Integer id) {
		try {
			Map<Personagem, AudioVisual> dublagens = new HashMap<Personagem, AudioVisual>();
			String slq = "SELECT A.NOME, C.NOME AS ANIMACAO FROM PERSONAGEM A INNER JOIN DUBLADOR B ON B.ID = A.DUBLADOR_ID INNER JOIN ANIMACAO C ON A.ANIMACAO_ID = C.ID WHERE B.ID = ?";

			try (PreparedStatement pstm = this.connection.prepareStatement(slq)) {
				pstm.setInt(1, id);
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Personagem personagem = new Personagem(rst.getString(1));
						AudioVisual audioVisual = new AudioVisual(rst.getString(2));
						dublagens.put(personagem, audioVisual);
					}
				}
			}
			return Collections.unmodifiableMap(dublagens);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
