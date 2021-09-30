package br.com.BibliotecaMultipla.Categoria;

import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

/**
 * Classe que representa a lista de categoria do Banco de Dados.
 * 
 * @author Matheus
 * @version 0.2
 */
public class Categoria implements Identificacao {

	Identificador identificador;

	/**
	 * Construtor de um objeto do tipo Categoria a partir do seu id e nome. Usado
	 * para buscar informacoes no Banco de Dados.
	 */
	public Categoria(Integer id, String nome) {
		Identificador identificador = new Identificador(id, nome);
		this.identificador = identificador;
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

}
