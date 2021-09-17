package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Representa o corpo de uma animação que já fora assistida pelo usuário
 * 
 * @author Matheus
 * @version 0.1
 */

public class Animacao_Assistido extends Animacao {

	private LocalDateTime dataDeFinalizacao;
	private Double nota;

	public Animacao_Assistido(Integer id, String nome, Integer ano_de_lancamento, String genero, Timestamp data_de_registro,
			Integer numeroEpisodios, Integer categoriaID, LocalDateTime dataDeFinalizacao, Double nota) {
		super(id, nome, ano_de_lancamento, genero, data_de_registro, numeroEpisodios, categoriaID);
		this.dataDeFinalizacao = dataDeFinalizacao;
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", data de finalização: " + this.dataDeFinalizacao + ", nota: " + this.nota;
	}

}
