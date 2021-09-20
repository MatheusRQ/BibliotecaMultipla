package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;

public class Animacao_N_AssistidoDAO {

	private Connection connection;

	public Animacao_N_AssistidoDAO(Connection connection) {
		this.connection = connection;
	}

	public Collection<Animacao_N_Assistido> listar() {
		try {
			Collection<Animacao_N_Assistido> anas = new ArrayList<>();
			String sql = "SELECT A.ID, A.NOME, A.ANO_DE_LANCAMENTO, A.GENERO, A.DATA_DE_REGISTRO, B.NOME AS CATEGORIA, A.NUMERO_EPISODIOS, C.PRIORIDADE, C.RELEVANCIA FROM ANIMACAO A INNER JOIN CATEGORIA B ON A.CATEGORIA_ID = B.ID INNER JOIN ANIMACAO_N_ASSISTIDO C ON C.ANIMACAO_ID = A.ID  WHERE A.ASSISTIDO = 0";
					
			try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Animacao_N_Assistido ana = new Animacao_N_Assistido(rst.getInt(1), rst.getString(2),
								rst.getInt(3), rst.getString(4), rst.getTimestamp(5), rst.getString(6), rst.getInt(7),
								rst.getString(8), rst.getString(9));

						anas.add(ana);
					}
				}
			}
			return Collections.unmodifiableCollection(anas);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
