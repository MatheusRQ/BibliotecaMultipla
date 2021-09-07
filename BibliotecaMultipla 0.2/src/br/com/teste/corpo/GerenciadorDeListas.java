package br.com.teste.corpo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Encarregado de gereciar as listas da BibliotecaMultipla
 * 
 * @author Matheus
 * @version 1.0
 */

public class GerenciadorDeListas implements Serializable {

	private static final long serialVersionUID = 1L;
	private Collection<AnimacaoOriental> animes = new ArrayList<>();

	public Collection<AnimacaoOriental> getAnimes() {
		return Collections.unmodifiableCollection(animes);
	}

	public void adiciona(AnimacaoOriental anime) {
		this.animes.add(anime);		
	}
	
	
}
