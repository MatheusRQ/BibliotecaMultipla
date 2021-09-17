package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;

public class Animacao_N_AssistidoDAO {

	private Connection connection;

	public Animacao_N_AssistidoDAO(Connection connection) {
		this.connection = connection;
	}

	public List<Animacao_N_Assistido> listar() {
		try {
			List<Animacao_N_Assistido> anas = new ArrayList<>();
			String sql = "SELECT ID, NOME, ANO_DE_LANCAMENTO, GENERO, NUMERO_EPISODIOS, CATEGORIA_ID, DATA_DE_REGISTRO, RELEVANCIA, PRIORIDADE FROM ANIMACAO_N_ASSISTIDO";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Animacao_N_Assistido ana = new Animacao_N_Assistido(rst.getInt(1), rst.getString(2),
								rst.getInt(3), rst.getString(4), rst.getTimestamp(5), rst.getInt(6), rst.getInt(7),
								rst.getString(8).charAt(0), rst.getString(9).charAt(0));

						anas.add(ana);
					}
				}
			}
			return anas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
