package br.com.BibliotecaMultipla.MainMethod;

import java.sql.Connection;

import br.com.BibliotecaMultipla.DAO.AnimacaoDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;

public class TestandoDAO {

	public static void main(String[] args) {
//		Animacao_N_Assistido ana = new Animacao_N_Assistido(1, "Nome de teste", 2020, "Acao e fantasia", null , 12, 1, 'A', '+');
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		AnimacaoDAO anaDAO =  new AnimacaoDAO(connection);
		anaDAO.listarNaoAssistido().forEach((System.out::println));

	}

}
