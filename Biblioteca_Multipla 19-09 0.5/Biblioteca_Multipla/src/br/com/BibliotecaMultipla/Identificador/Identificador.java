package br.com.BibliotecaMultipla.Identificador;

/**
 * Classe responsavel por trabalhar com ID e nome.
 * 
 * @author Matheus
 * @version 0.2
 */
public class Identificador {

	private Integer id;
	private String nome;

	/**
	 * Construtor do objeto identificador a partir de id e nome. Lancara uma
	 * exception caso algum dos itens seja nulo ou 0 no caso do id.
	 * 
	 */
	public Identificador(Integer id, String nome) {
		if (id == 0 || nome == null) {
			throw new NullPointerException("Nome e id são informações essenciais!");
		}

		this.id = id;
		this.nome = nome;
	}

	/**
	 * Construtor do objeto identificador a partir de nome. Lancara uma exception
	 * caso o item seja nulo.
	 */
	public Identificador(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome é uma informação essencial!");
		}
		this.nome = nome;
	}

	/**
	 * Construtor do objeto identificador a partir do ID. Lancara uma exception caso
	 * o item 0.
	 */
	public Identificador(Integer id) {
		if (id == 0) {
			throw new NullPointerException("ID é uma informação essencial!");
		}
		this.id = id;
	}

	/**
	 * 
	 * @return o nome.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome.
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return o id.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Define o id.
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
