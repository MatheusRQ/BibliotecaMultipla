package br.com.BibliotecaMultipla.Pessoa;

import java.util.Collection;

import br.com.BibliotecaMultipla.AudioVisual.Animacao;

/**
 * Classe com a funcao de trabalhar com uma lista de animacoes e dubladores,
 * para auxiliar a classe PersonagemDAO.
 * 
 * @author Matheus
 * @version 0.1
 */
public class Dublagens {

	private Collection<Animacao> animacoes;
	private Collection<Dublador> dubladores;

	/**
	 * Construtor para inicializar um objeto Dublagens a partir de uma colecao de
	 * animacoes e uma de dubladores.
	 */
	public Dublagens(Collection<Animacao> animacoes, Collection<Dublador> dubladores) {
		this.animacoes = animacoes;
		this.dubladores = dubladores;
	}

	/**
	 * 
	 * @return uma colecao de animacoes.
	 */
	public Collection<Animacao> getAnimacoes() {
		return animacoes;
	}

	/**
	 * 
	 * @return uma colecao de dubladores.
	 */
	public Collection<Dublador> getDubladores() {
		return dubladores;
	}

}
