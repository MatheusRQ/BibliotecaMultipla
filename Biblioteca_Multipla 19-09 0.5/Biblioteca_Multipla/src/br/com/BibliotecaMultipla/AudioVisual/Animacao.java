package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

/**
 * Representa o corpo de uma animacao
 * 
 * @author Matheus
 * @version 0.3
 */

public class Animacao extends AudioVisual {

	private Integer numeroEpisodios;

	/**
	 * Construtor de um objeto Animacao a partir do id, nome, ano de lancamento,
	 * genero, data de registro, categoria e numero de episodios. Utilizado para
	 * buscar informacoes no Banco de dados.
	 */
	public Animacao(Integer id, String nome, Integer ano_de_lancamento, String genero, Timestamp data_de_registro,
			String categoria, Integer numeroEpisodios) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, categoria);
		this.numeroEpisodios = numeroEpisodios;
	}

	/**
	 * Construtor de um objeto Animacao a partir do nome, ano de lancamento, genero,
	 * data de registro, categoria e numero de episodios. Utilizado para inserir
	 * informacoes no Banco de dados.
	 */
	public Animacao(String nome, Integer ano_de_lancamento, String genero, Integer categoria, Integer numeroEpisodios) {
		super(nome, ano_de_lancamento, genero, categoria);
		this.numeroEpisodios = numeroEpisodios;
	}

	/**
	 * @return o numero de episodios da animacao.
	 */
	public Integer getNumeroEpisodios() {
		return numeroEpisodios;
	}

	/**
	 * toString que retorna todas as informacoes do toString de AudioVisual, somando
	 * com o numero de episodios da animacao.
	 */
	@Override
	public String toString() {
		return super.toString() + ", numero de episodios: " + this.numeroEpisodios;
	}

}
