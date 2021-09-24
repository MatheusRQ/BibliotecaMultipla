package br.com.BibliotecaMultipla.Identificador;

public interface Identificacao {

	public abstract String getNome();
	
	public abstract Integer getId();
	
	public abstract void setID (Integer id);
	
	public abstract void setNome (String nome);
}
