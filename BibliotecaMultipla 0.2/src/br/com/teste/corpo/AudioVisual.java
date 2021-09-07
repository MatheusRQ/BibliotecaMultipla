package br.com.teste.corpo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa todo elemento global para Audio-visual
 * 
 * @author Matheus
 * @version 0.1
 */
public class AudioVisual implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private int anoDeLan�amento;
	private String genero;
	private LocalDateTime dataDeRegistro = LocalDateTime.now();
	private String dataDeRegistroConvertido;
	
	public AudioVisual(String nome, int anoDeLan�amento, String genero) {
		if (nome == null) {
			throw new NullPointerException("Nome � uma informa��o fundamental!");
		}
		
		this.nome = nome;
		this.anoDeLan�amento = anoDeLan�amento;
		this.genero = genero;
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		this.dataDeRegistroConvertido = formatador.format(dataDeRegistro);
	}

	public String getNome() {
		return nome;
	}

	public int getAnoDeLan�amento() {
		return anoDeLan�amento;
	}

	public String getGenero() {
		return genero;
	}

	public String getDataDeRegistroConvertido() {
		return dataDeRegistroConvertido;
	}
	
}