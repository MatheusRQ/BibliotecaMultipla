package br.com.teste.testesAutomatizados.JUnit;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.teste.corpo.AnimacaoOriental;
import br.com.teste.corpo.GerenciadorDeListas;

public class ColecoesTester {	
	@Test
	public void DeveJogarUmaExceptionPorTentarAdicionarElementosEmUmaUnmodifiableCollection() {
		GerenciadorDeListas gerenciador = new GerenciadorDeListas();
		AnimacaoOriental anime = new AnimacaoOriental("Teste", 1, null, 2021);
		Assert.assertThrows(UnsupportedOperationException.class,
				() -> gerenciador.getAnimes().add(anime));
	}
	
	@Test
	public void DeveAdicionarAlgoNaListaSemLancarException() {
		GerenciadorDeListas gerenciador = new GerenciadorDeListas();
		AnimacaoOriental anime = new AnimacaoOriental("Teste", 1, null, 2021);
		
		try {
			gerenciador.adiciona(anime);
		} catch (Exception e) {
			fail();
		}
	}
}
