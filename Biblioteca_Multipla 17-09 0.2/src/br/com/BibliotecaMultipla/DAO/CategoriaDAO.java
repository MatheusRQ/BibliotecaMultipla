package br.com.BibliotecaMultipla.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.BibliotecaMultipla.Categoria.Categoria;

public class CategoriaDAO {

	private Connection connection;

	public CategoriaDAO(Connection connection) {
		this.connection = connection;
	}

	public Collection<Categoria> listar() {
		try {
			Collection<Categoria> categorias = new ArrayList<>();
			String sql = "SELECT ID, NOME FROM CATEGORIA";

			try (PreparedStatement pstm = this.connection.prepareStatement(sql)) {
				pstm.execute();

				try (ResultSet rst = pstm.getResultSet()) {
					while (rst.next()) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));

						categorias.add(categoria);
					}
				}
			}
			return Collections.unmodifiableCollection(categorias);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
