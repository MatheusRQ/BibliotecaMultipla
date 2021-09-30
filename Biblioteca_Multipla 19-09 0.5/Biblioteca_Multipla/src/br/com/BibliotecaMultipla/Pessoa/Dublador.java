package br.com.BibliotecaMultipla.Pessoa;

import java.sql.Date;

import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

/**
 * Represeta um Dublador
 * 
 * @author Matheus
 * @version 0.3
 **/
public class Dublador implements Identificacao {

	Identificador identificador;
	private Date dataDeNascimento;
	//private Map<Personagem, AudioVisual> dublagens = new HashMap<>();

	/**
	 * Construtor para inicializar um objeto do tipo Dublador a partir de id, nome e
	 * data de nascimento. Usado para buscar informacoes no Banco de Dados.
	 */
	public Dublador(Integer id, String nome, Date dataDeNascimento) {
		this.identificador = new Identificador(id, nome);
		this.dataDeNascimento = dataDeNascimento;
	}

	/**
	 * Construtor para inicializar um objeto do tipo Dublador a partir de nome e
	 * data de nascimento. Usado para inserir informacoes no Banco de Dados.
	 */
	public Dublador(String nome, Date dataDeNascimento) {
		this.identificador = new Identificador(nome);
		this.dataDeNascimento = dataDeNascimento;
	}

	/**
	 * Construtor para inicializar um objeto do tipo Dublador a partir de ID. Usado
	 * para buscar informacoes no Banco de Dados.
	 */
	public Dublador(Integer id) {
		this.identificador = new Identificador(id);
	}

	/**
	 * Construtor para inicializar um objeto do tipo Dublador a partir de nome.
	 * Usado para inserir informacoes no Banco de Dados.
	 * 
	 * @param id
	 */
	public Dublador(String nome) {
		this.identificador = new Identificador(nome);
	}

	/**
	 * Metodo com a funcao de registrar um mapa com os personagens dublados pelo
	 * dublador, justo de suas respectivas origens.
	 * 
	 * @param dublagens
	 */
//	public void setDublagens(Map<Personagem, AudioVisual> dublagens) {
//		this.dublagens = dublagens;
//	}

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
	 * @return a data de nascimento do dublador.
	 */
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	/**
	 * toString que retorna o id, nome e data de nascimento do objeto.
	 */
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", nome: " + this.getNome() + ", data de nascimento: " + this.dataDeNascimento;
	}

}
