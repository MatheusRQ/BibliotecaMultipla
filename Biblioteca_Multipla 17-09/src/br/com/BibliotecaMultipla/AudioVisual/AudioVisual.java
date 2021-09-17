package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Representa o corpo de um item Áudio visual
 * 
 * @author Matheus
 * @version 0.1
 */

public abstract class AudioVisual {

	private Integer id;
	private String nome;
	private Integer ano_de_lancamento;
	private String genero;
	private Timestamp data_de_registro;

	public AudioVisual(Integer id, String nome, Integer ano_de_lancamento, String genero, Timestamp data_de_registro) {
		this.id = id;
		this.nome = nome;
		this.ano_de_lancamento = ano_de_lancamento;
		this.genero = genero;
		this.data_de_registro = data_de_registro;
	}
	
	public AudioVisual(Integer id, String nome, Integer ano_de_lancamento, String genero) {
		this.id = id;
		this.nome = nome;
		this.ano_de_lancamento = ano_de_lancamento;
		this.genero = genero;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getAno_de_lancamento() {
		return ano_de_lancamento;
	}

	public String getGenero() {
		return genero;
	}

	public Timestamp getData_de_registro() {
		return data_de_registro;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + ", nome: " + this.nome + ", Ano de Lançamento: " + this.ano_de_lancamento + ", Generos: " + this.genero + ", Data de Registro: " + this.data_de_registro;
	}

}
