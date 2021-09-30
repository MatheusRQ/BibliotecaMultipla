package br.com.BibliotecaMultipla.Pessoa;

import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;
import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

/**
 * Representa um personagem, seja ela de um Live Action, seja ela de uma
 * animação 2D/3D
 * 
 * @author Matheus
 * @version 0.2
 */

public class Personagem implements Identificacao {

	Identificador identificador;
	private Dublador dubladorAtor;
	private AudioVisual origem;

	public Personagem(Integer id, String nome, Dublador dubladorAtor, AudioVisual origem) {
		this.identificador = new Identificador(id, nome);
		this.dubladorAtor = dubladorAtor;
		this.origem = origem;
	}

	public Personagem(Integer id, String nome) {
		this.identificador = new Identificador(id, nome);
	}

	@Override
	public String getNome() {
		return this.identificador.getNome();
	}

	@Override
	public Integer getId() {
		return this.identificador.getId();
	}

	@Override
	public void setID(Integer id) {
		this.identificador.setId(id);

	}

	@Override
	public void setNome(String nome) {
		this.identificador.setNome(nome);

	}

	public Dublador getDubladorAtor() {
		return dubladorAtor;
	}

	public AudioVisual getOrigem() {
		return origem;
	}

}
