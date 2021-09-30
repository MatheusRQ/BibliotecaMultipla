package br.com.BibliotecaMultipla.Identificador;

/**
 * Interface responsavel por obrigar toda classe que tenha correlacao com o banco de dados de ter metodos para inserir e retornar ID e Nome.
 * @author Matheus
 * @version 0.2
 */
public interface Identificacao {

	public abstract String getNome();
	
	public abstract Integer getId();
	
	public abstract void setID (Integer id);
	
	public abstract void setNome (String nome);
}
