package br.com.BibliotecaMultipla.Identificador;

public class Identificador {

	private Integer id;
	private String nome;

	public Identificador(Integer id, String nome) {
		if (id == 0 || nome == null) {
			throw new NullPointerException("Nome e id são informações essenciais!");
		}

		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
