package br.com.BibliotecaMultipla.Categoria;

import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

public class Categoria implements Identificacao {

	Identificador identificador;

	public Categoria(Integer id, String nome) {
		Identificador identificador = new Identificador(id, nome);
		this.identificador = identificador;
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
	public void setNome(String nome) {
		this.identificador.setNome(nome);
	}
	
	@Override
	public void setID(Integer id) {
		this.identificador.setId(id);
	}
	
}
