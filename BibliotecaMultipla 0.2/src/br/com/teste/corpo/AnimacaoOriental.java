package br.com.teste.corpo;

import java.io.Serializable;

/**
 * Representa o corpo de uma animação japonesa na BibliotecaMultipla
 * 
 * @author Matheus
 * @version 0.2
 */

public class AnimacaoOriental extends AudioVisual implements Serializable {

	private static final long serialVersionUID = 2L;
	private int numeroDeEpisodios = 0;

	public AnimacaoOriental(String nome, int anoDeLançamento, String genero, int numeroDeEpisodios) {
		super(nome, anoDeLançamento, genero);
		if(numeroDeEpisodios == 0) {
			throw new NullPointerException("Número de episodios é uma informação fundamental!");
		}
		this.numeroDeEpisodios = numeroDeEpisodios;
	}

	@Override
	public String toString() {
		return "[Nome: " + super.getNome() + ", episodios: " + this.numeroDeEpisodios + ", genero: "
				+ super.getGenero() + ", ano: " + super.getAnoDeLançamento() + ", registro: " + super.getDataDeRegistroConvertido();
	}

}