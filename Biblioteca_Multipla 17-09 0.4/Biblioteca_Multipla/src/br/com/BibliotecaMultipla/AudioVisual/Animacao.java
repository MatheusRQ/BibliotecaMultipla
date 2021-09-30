package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

/**
 * Representa o corpo de uma animação
 * 
 * @author Matheus
 * @version 0.2
 */

public abstract class Animacao extends AudioVisual {

	private Integer numeroEpisodios;

	public Animacao(Integer id, String nome, Integer ano_de_lancamento, String genero, Timestamp data_de_registro,
			String categoria, Integer numeroEpisodios) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, categoria);
		this.numeroEpisodios = numeroEpisodios;
	}

	public Integer getNumeroEpisodios() {
		return numeroEpisodios;
	}

	@Override
	public String toString() {
		return super.toString() + ", numero de episodios: " + this.numeroEpisodios;
	}

}
