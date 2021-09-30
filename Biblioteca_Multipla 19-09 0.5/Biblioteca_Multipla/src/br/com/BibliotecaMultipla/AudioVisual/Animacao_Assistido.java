package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

/**
 * Representa o corpo de uma animacao que ja fora assistida pelo usuario
 * 
 * @author Matheus
 * @version 0.3
 */

public class Animacao_Assistido extends Animacao {

	private Timestamp dataDeFinalizacao;
	private Double nota;

	/**
	 * Construtor de um objeto Animacao a partir do id, nome, ano de lancamento,
	 * genero, data de registro, categoria, numero de episodios e data de
	 * finalizacao. Utilizado para buscar informacoes no Banco de dados.
	 */
	public Animacao_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero,
			Timestamp data_de_registro, String categoria, Integer numeroEpisodios, Timestamp dataDeFinalizacao,
			Double nota) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, categoria, numeroEpisodios);
		this.dataDeFinalizacao = dataDeFinalizacao;
		this.nota = nota;
	}

	/**
	 * Construtor de um objeto Animacao_Assistido a partir do nome, ano de
	 * lancamento, genero, data de registro, categoria, numero de episodios e data
	 * de finalizacao. Utilizado para inserir informacoes no Banco de dados.
	 */
	public Animacao_Assistido(String nome, Integer ano_de_lancamento, String genero, Integer categoria,
			Integer numeroEpisodios, Double nota) {
		super(nome, ano_de_lancamento, genero, categoria, numeroEpisodios);
		this.nota = nota;
	}

	/**
	 * 
	 * @return a nota dada a animacao
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * toString que retorna todas as informacoes do toString de AudioVisual e
	 * Animacao, somando com a data do dia em que se terminou de assistir a animacao
	 * e a nota que se deseja dar.
	 */
	@Override
	public String toString() {
		return super.toString() + ", data de finalização: " + this.dataDeFinalizacao + ", nota: " + this.nota;
	}

}
