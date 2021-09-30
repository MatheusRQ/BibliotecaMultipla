package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

/**
 * Representa o corpo de uma animação que já fora assistida pelo usuário
 * 
 * @author Matheus
 * @version 0.2
 */

public class Animacao_Assistido extends Animacao {

	private Timestamp dataDeFinalizacao;
	private Double nota;

	public Animacao_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero,
			Timestamp data_de_registro, String categoria, Integer numeroEpisodios, Timestamp dataDeFinalizacao,
			Double nota) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, categoria, numeroEpisodios);
		this.dataDeFinalizacao = dataDeFinalizacao;
		this.nota = nota;
	}

	public Double getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return super.toString() + ", data de finalização: " + this.dataDeFinalizacao + ", nota: " + this.nota;
	}

}
