package br.com.teste.corpo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa o corpo de uma animação japonesa na BibliotecaMultipla
 * 
 * @author Matheus
 * @version 0.1
 */

public class AnimacaoOriental implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private int numeroDeEpisodios;
	private int ano;
	private String genero;
	private LocalDateTime dataDeRegistro = LocalDateTime.now();
	private String dataDeRegistroConvertido;
	
	public AnimacaoOriental(String nome, int numeroDeEpisodios, String genero, int ano) {
		if (nome == null || numeroDeEpisodios == 0) {
			throw new NullPointerException("Nome e numero de episodios sao informacoes fundamentais!");
		}
		this.nome = nome;
		this.numeroDeEpisodios = numeroDeEpisodios;
		this.ano = ano;
		this.genero = genero;
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		this.dataDeRegistroConvertido = formatador.format(dataDeRegistro);
	}
	
	@Override
	public String toString() {
		return "[Nome: " + this.nome + ", episodios: " + this.numeroDeEpisodios + ", genero: "
				+ this.genero + ", ano: " + this.ano + ", registro: " + dataDeRegistroConvertido;
	}
}