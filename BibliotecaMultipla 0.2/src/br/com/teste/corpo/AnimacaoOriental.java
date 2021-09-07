package br.com.teste.corpo;

import java.io.Serializable;

/**
 * Representa o corpo de uma anima��o japonesa na BibliotecaMultipla
 * 
 * @author Matheus
 * @version 0.2
 */

public class AnimacaoOriental extends AudioVisual implements Serializable {

	private static final long serialVersionUID = 2L;
	private int numeroDeEpisodios = 0;

	public AnimacaoOriental(String nome, int anoDeLan�amento, String genero, int numeroDeEpisodios) {
		super(nome, anoDeLan�amento, genero);
		if(numeroDeEpisodios == 0) {
			throw new NullPointerException("N�mero de episodios � uma informa��o fundamental!");
		}
		this.numeroDeEpisodios = numeroDeEpisodios;
	}

	@Override
	public String toString() {
		return "[Nome: " + super.getNome() + ", episodios: " + this.numeroDeEpisodios + ", genero: "
				+ super.getGenero() + ", ano: " + super.getAnoDeLan�amento() + ", registro: " + super.getDataDeRegistroConvertido();
	}

}