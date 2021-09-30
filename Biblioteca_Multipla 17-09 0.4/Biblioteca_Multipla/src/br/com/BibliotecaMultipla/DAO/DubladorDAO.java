package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.BibliotecaMultipla.Pessoa.Dublador;

public class DubladorDAO {

	Connection connection;

	public DubladorDAO(Connection connection) {
		this.connection = connection;
	}
	
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

	public void registrar(Dublador dublador) {
		try {
			String sql = "INSERT INTO DUBLADOR(NOME, NASCIMENTO) VALUES (?, ?)";
			
			try(PreparedStatement pstm = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
}
