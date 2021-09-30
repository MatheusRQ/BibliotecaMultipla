package br.com.BibliotecaMultipla.Pessoa;

import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;
import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

/**
 * Representa um personagem, seja ela de um Live Action, seja ela de uma
 * animação 2D/3D
 * 
 * @author Matheus
 * @version 0.3
 */

public class Personagem implements Identificacao {

	private Identificador identificador;
	private Dublador dubladorAtor;
	private AudioVisual origem;

	/**
	 * Construtor para inicializar um objeto do tipo Personagem a partir de id,
	 * nome, nome do dublador e nome da origem. Usado para buscar informacoes no
	 * Banco de Dados.
	 */
	public Personagem(Integer id, String nome, String dubladorAtorNome, String origemNome) {
		this.identificador = new Identificador(id, nome);
		this.dubladorAtor = new Dublador(dubladorAtorNome);
		this.origem = new AudioVisual(origemNome);
	}

	/**
	 * Construtor para inicializar um objeto do tipo Personagem a partir de nome, id
	 * do dublador e id da origem. Usado para inserir informacoes no Banco de Dados.
	 */
	public Personagem(String nome, Integer dubladorAtorID, Integer origemID) {
		this.identificador = new Identificador(nome);
		this.dubladorAtor = new Dublador(dubladorAtorID);
		this.origem = new AudioVisual(origemID);
	}

	/**
	 * onstrutor para inicializar um objeto do tipo Personagem a partir de nome.
	 * Usado para buscar informacoes no Banco de Dados.
	 */
	public Personagem(String nome) {
		this.identificador = new Identificador(nome);
	}

	/**
	 * Metodo que retorna o id baseado na classe Identificador.
	 */
	@Override
	public Integer getId() {
		return this.identificador.getId();
	}

	/**
	 * Metodo que define o id baseado na classe Identificador.
	 */
	@Override
	public void setID(Integer id) {
		this.identificador.setId(id);
	}

	/**
	 * Metodo que retorna o nome baseado na classe Identificador.
	 */
	@Override
	public String getNome() {
		return this.identificador.getNome();
	}

	/**
	 * Metodo que define o nome baseado na classe Identificador.
	 */
	@Override
	public void setNome(String nome) {
		this.identificador.setNome(nome);
	}

	/**
	 * 
	 * @return o dublador ou o ator do personagem.
	 */
	public Dublador getDubladorAtor() {
		return dubladorAtor;
	}

	/**
	 * 
	 * @return a origem do personagem.
	 */
	public AudioVisual getOrigem() {
		return origem;
	}

	/**
	 * toString que retorna o id, nome, origem e ator ou dublador do personagem.
	 */
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", nome: " + this.getNome() + ", origem: " + this.origem.getNome()
				+ ", dublador ou ator: " + this.dubladorAtor.getNome();
	}

}
