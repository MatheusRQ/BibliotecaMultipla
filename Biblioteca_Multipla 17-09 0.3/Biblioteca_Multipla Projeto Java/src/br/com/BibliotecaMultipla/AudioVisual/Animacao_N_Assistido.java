package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

public class Animacao_N_Assistido extends Animacao {

	private String prioridade;
	private String relevancia;

	
	
	



	public Animacao_N_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero,
			Timestamp data_de_registro, String categoria, Integer numeroEpisodios, String prioridade,
			String relevancia) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, categoria, numeroEpisodios);
		this.prioridade = prioridade;
		this.relevancia = relevancia;
	}







	@Override
	public String toString() {
		return super.toString() + ", prioridade: " + this.prioridade + ", relevancia: " + this.relevancia;
	}

}
