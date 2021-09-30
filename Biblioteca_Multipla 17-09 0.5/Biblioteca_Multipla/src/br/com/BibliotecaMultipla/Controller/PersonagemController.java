package br.com.BibliotecaMultipla.Controller;

import java.util.Collection;

import br.com.BibliotecaMultipla.DAO.PersonagemDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;
import br.com.BibliotecaMultipla.Pessoa.Dublagens;
import br.com.BibliotecaMultipla.Pessoa.Personagem;

/**
 * Classe que representa o controlador da classe PersonagemDAO.
 * 
 * @author Matheus
 * @version 0.3
 */
public class PersonagemController {

	PersonagemDAO personagemDAO;

	/**
	 * Construtor que inicia uma PersonagemDAO a partir de uma conexao.
	 */
	public PersonagemController() {
		this.personagemDAO = new PersonagemDAO(new ConnectionFactory().recuperarConexao());
	}

	/**
	 * @return o metodo de listar personagens da PersonagemDAO.
	 */
	public Collection<Personagem> listarPersonagens() {
		return this.personagemDAO.listar();
	}

	/**
	 * Metodo que registra um personagem a partir do mesmo metodo na PersonagemDAO.
	 */
	public void registrarPersonagem(Personagem personagem) {
		this.personagemDAO.registrar(personagem);
	}

	/**
	 * @return o metodo que mostra as dublagens e audio visuais da classe
	 *         PersonagemDAO.
	 */
	public Dublagens devolveDublagem() {
		return this.personagemDAO.buscaAudioVisualEDublador();
	}
}
