package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.BibliotecaMultipla.Pessoa.Personagem;

public class PersonagemDAO {

	Connection connection;

	public PersonagemDAO(Connection connection) {
		this.connection = connection;
	}

	public Collection<Personagem> listar() {
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

	public void registrar(Personagem personagem) {
		try {
			String sql = "CALL REGISTROPERSONAGEM(?, ?, ?)";
			
			try(PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
}
