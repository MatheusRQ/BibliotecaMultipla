package br.com.BibliotecaMultipla.MainMethod;

import java.sql.Connection;
import java.util.Comparator;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;
import br.com.BibliotecaMultipla.DAO.Animacao_N_AssistidoDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;

public class TestandoDAO {

	public static void main(String[] args) {
//		Animacao_N_Assistido ana = new Animacao_N_Assistido(1, "Nome de teste", 2020, "Acao e fantasia", null , 12, 1, 'A', '+');
		Connection connection = new ConnectionFactory().recuperarConexao();
		
		Animacao_N_AssistidoDAO anaDAO =  new Animacao_N_AssistidoDAO(connection);
		anaDAO.listar().forEach((System.out::println));

	}

}
