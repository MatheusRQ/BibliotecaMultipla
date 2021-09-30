package br.com.BibliotecaMultipla.Controller;

import java.util.Collection;
import java.util.Map;

import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;
import br.com.BibliotecaMultipla.DAO.DubladorDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;
import br.com.BibliotecaMultipla.Pessoa.Dublador;
import br.com.BibliotecaMultipla.Pessoa.Personagem;

/**
 * Classe que representa o controlador da classe DubladorDAO.
 * 
 * @author Matheus
 * @version 0.1
 */
public class DubladorController {

	private DubladorDAO dubladorDAO;

	/**
	 * Construtor que inicia uma DubladorDAO a partir de uma conexao.
	 */
	public DubladorController() {
		this.dubladorDAO = new DubladorDAO(new ConnectionFactory().recuperarConexao());
	}

	/**
	 * @return o metodo de listar dubladores da DubladorDAO.
	 */
	public Collection<Dublador> listarDubladores() {
		return this.dubladorDAO.listar();
	}

	/**
	 * Metodo que registra um dublador a partir do mesmo metodo na DubladorDAO.
	 */
	public void registrarDublador(Dublador dublador) {
		this.dubladorDAO.registrar(dublador);
	}

	/**
	 * Metodo que mapeia as dublagens do dublador, usando personagens e audio
	 * visuais, a partir do mesmo metodo na DubladorDAO.
	 */
	public Map<Personagem, AudioVisual> listarDublagens(Integer id) {
		return this.dubladorDAO.listarDublagens(id);
	}
}
