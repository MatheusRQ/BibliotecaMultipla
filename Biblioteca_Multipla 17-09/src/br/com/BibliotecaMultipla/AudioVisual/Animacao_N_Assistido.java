package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

public class Animacao_N_Assistido extends Animacao {

	private char prioridade;
	private char relevancia;

	public Animacao_N_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero, Timestamp data_de_registro,
			Integer numeroEpisodios, Integer categoriaID, char prioridade, char relevancia) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, numeroEpisodios, categoriaID);
		this.prioridade = prioridade;
		this.relevancia = relevancia;
	}
	
	public Animacao_N_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero,
			Integer numeroEpisodios, Integer categoriaID, char prioridade, char relevancia) {
		super(id, nome, ano_de_lancamento, genero, numeroEpisodios, categoriaID);
		this.prioridade = prioridade;
		this.relevancia = relevancia;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", prioridade: " + this.prioridade + ", relevancia: " + this.relevancia;
	}

}
