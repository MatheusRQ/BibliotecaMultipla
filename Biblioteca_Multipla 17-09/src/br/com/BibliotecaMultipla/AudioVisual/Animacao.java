package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

/**
 * Representa o corpo de uma animação
 * 
 * @author Matheus
 * @version 0.1
 */

public abstract class Animacao extends AudioVisual {

	private Integer numeroEpisodios;
	private Integer categoriaID;

	public Animacao(Integer id, String nome, Integer ano_de_lancamento, String genero,Timestamp data_de_registro, Integer numeroEpisodios,
			Integer categoriaID) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro);
		this.numeroEpisodios = numeroEpisodios;
		this.categoriaID = categoriaID;
	}
	
	public Animacao(Integer id, String nome, Integer ano_de_lancamento, String genero, Integer numeroEpisodios,
			Integer categoriaID) {
		super(id, nome, ano_de_lancamento, genero);
		this.numeroEpisodios = numeroEpisodios;
		this.categoriaID = categoriaID;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", numero de episodios: " + this.numeroEpisodios + ", categoria: ";
	}

}
