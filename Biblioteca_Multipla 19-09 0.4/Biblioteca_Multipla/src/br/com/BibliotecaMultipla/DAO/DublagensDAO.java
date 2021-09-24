package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.BibliotecaMultipla.Pessoa.Personagem;

public class DublagensDAO {

	Connection connection;

	public DublagensDAO(Connection connection) {
		this.connection = connection;
	}
	
	public Collection<Personagem> listarDublagens() {
		try {
			Collection<Personagem> personagens = new ArrayList<>();
			String sql = "SELECT A.ID, A.NOME, C.NOME AS ANIMACAO, D.NOME AS DUBLADOR FROM PERSONAGEM A INNER JOIN DUBLAGENS B ON A.ID = B.PERSONAGEM_ID INNER JOIN ANIMACAO C ON B.ANIMACAO_ID = C.ID INNER JOIN DUBLADOR D ON B.DUBLADOR_ID = D.ID";

			try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Personagem personagem = new Personagem(rst.getInt(1), rst.getString(2));
						personagens.add(personagem);
					}

				}
			}
			return Collections.unmodifiableCollection(personagens);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
