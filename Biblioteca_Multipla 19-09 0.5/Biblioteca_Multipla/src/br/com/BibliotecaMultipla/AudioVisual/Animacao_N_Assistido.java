package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

/**
 * Representa o corpo de uma animação que ainda não fora assistida pelo usuário
 * 
 * @author Matheus
 * @version 0.3
 */

public class Animacao_N_Assistido extends Animacao {

	private String prioridade;
	private String relevancia;

	/**
	 * Construtor de um objeto Animacao_N_Assistido a partir do id, nome, ano de
	 * lancamento, genero, data de registro, categoria, numero de episodios,
	 * prioridade e relevancia. Utilizado para buscar informacoes no Banco de dados.
	 */
	public Animacao_N_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero,
			Timestamp data_de_registro, String categoria, Integer numeroEpisodios, String prioridade,
			String relevancia) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, categoria, numeroEpisodios);
		this.prioridade = prioridade;
		this.relevancia = relevancia;
	}

	/**
	 * Construtor de um objeto Animacao_Assistido a partir do nome, ano de
	 * lancamento, genero, data de registro, categoria, numero de episodios,
	 * prioridade e relevancia. Utilizado para inserir informacoes no Banco de
	 * dados.
	 */
	public Animacao_N_Assistido(String nome, Integer ano_de_lancamento, String genero, Integer categoria,
			Integer numeroEpisodios, String prioridade, String relevancia) {
		super(nome, ano_de_lancamento, genero, categoria, numeroEpisodios);
		this.prioridade = prioridade;
		this.relevancia = relevancia;
	}

	/**
	 * @return A prioridade para assistir a animacao.
	 */
	public String getPrioridade() {
		return prioridade;
	}

	/**
	 * @return a relevancia da animacao. Geralmente, a qualidade que o usuario ja
	 *         sabe de antimao.
	 */
	public String getRelevancia() {
		return relevancia;
	}

	/**
	 * toString que retorna todas as informacoes do toString de AudioVisual e
	 * Animacao, somando com a prioridade e relevancia que o usuario deu para a
	 * animacao
	 */
	@Override
	public String toString() {
		return super.toString() + ", prioridade: " + this.prioridade + ", relevancia: " + this.relevancia;
	}

}
