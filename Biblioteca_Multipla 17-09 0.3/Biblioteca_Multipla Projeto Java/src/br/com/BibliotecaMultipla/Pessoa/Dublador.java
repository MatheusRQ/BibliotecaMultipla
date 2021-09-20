package br.com.BibliotecaMultipla.Pessoa;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;

/**
 * Represeta um Dublador
 * 
 * @author Matheus
 * @version 0.1
 **/
public class Dublador {

	private Integer id;
	private String nome;
	private Date dataDeAniversario;
	private Map<Personagem, AudioVisual> dublagens = new HashMap<>();
	// Map<Dado um personagem, ele vai ter um AudioVisual correspondente>

	public Dublador(Integer id, String nome, Date dataDeAniversario) {
		this.id = id;
		this.nome = nome;
		this.dataDeAniversario = dataDeAniversario;
	}

	public void setDublagens(Map<Personagem, AudioVisual> dublagens) {
		this.dublagens = dublagens;
	}
}
