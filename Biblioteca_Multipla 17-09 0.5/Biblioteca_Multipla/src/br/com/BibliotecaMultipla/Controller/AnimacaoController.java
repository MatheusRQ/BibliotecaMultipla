package br.com.BibliotecaMultipla.Controller;

import java.util.Collection;

import br.com.BibliotecaMultipla.AudioVisual.Animacao;
import br.com.BibliotecaMultipla.AudioVisual.Animacao_Assistido;
import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;
import br.com.BibliotecaMultipla.DAO.AnimacaoDAO;
import br.com.BibliotecaMultipla.Factory.ConnectionFactory;

/**
 * Classe que representa o controlador da classe AnimacaoDAO.
 * 
 * @author Matheus
 * @version 0.1
 */
public class AnimacaoController {

	private AnimacaoDAO animacaoDAO;

	/**
	 * Construtor que inicia uma AnimacaoDAO a partir de uma conexao.
	 */
	public AnimacaoController() {
		this.animacaoDAO = new AnimacaoDAO(new ConnectionFactory().recuperarConexao());
	}

	/**
	 * Metodo que salva uma animacao nao assistida a partir do mesmo metodo na
	 * AnimacaoDAO.
	 */
	public void salvarNaoAssistido(Animacao_N_Assistido animacao_N_Assistido) {
		this.animacaoDAO.registrarAnimacaoNAssistido(animacao_N_Assistido);
		System.out.println("Animacao " + animacao_N_Assistido.getNome() + " registrada!");
	}

	/**
	 * @return o metodo de listar animacaoes nao assistidas da AnimacaoDAO.
	 */
	public Collection<Animacao_N_Assistido> listarNaoAssistidos() {
		return this.animacaoDAO.listarNaoAssistido();
	}

	/**
	 * Metodo que salva uma animacao assistida a partir do mesmo metodo na
	 * AnimacaoDAO.
	 * 
	 * @param animacao_Assistido
	 */
	public void salvarAssistido(Animacao_Assistido animacao_Assistido) {
		this.animacaoDAO.registrarAnimacaoAssistido(animacao_Assistido);
		System.out.println("Animacao " + animacao_Assistido.getNome() + " registrada!");
	}

	/**
	 * 
	 * @return o metodo de listar animacaoes assistidas da AnimacaoDAO.
	 */
	public Collection<Animacao_Assistido> listarAssistidos() {
		return this.animacaoDAO.listarAssistido();
	}

	/**
	 * 
	 * @return o metodo de listar todas as animacoes do banco de dados da
	 *         AnimacaoDAO.
	 */
	public Collection<Animacao> listarAnimacoes() {
		return this.animacaoDAO.listarAnimacoes();
	}

	/**
	 * Metodo que troca uma animacao de nao assistida para assistida a partir do
	 * mesmo metodo da AnimacaoDAO.
	 * 
	 * @param id
	 * @param nota
	 */
	public void finalizacaoDeAnimacao(Integer id, Double nota) {
		this.animacaoDAO.finalizaAnimacao(id, nota);
		System.out.println("Animacao " + id + " alterada!");
	}

}
