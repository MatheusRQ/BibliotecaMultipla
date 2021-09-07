package br.com.teste.testesAutomatizados.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import br.com.teste.corpo.AnimacaoOriental;
import br.com.teste.corpo.GerenciadorDeListas;

public class ExportacaoTest {

	@Test
	public void DeveRetornarOMesmoToStringDeAnimacaoOriental() throws Exception {
		AnimacaoOriental animes = new AnimacaoOriental("Nome Teste", 15, "Ação/Aventura", 2021);
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("testeJUnit.bin"));
		oss.writeObject(animes);
		oss.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testeJUnit.bin"));
		AnimacaoOriental animes2 = (AnimacaoOriental) ois.readObject();
		ois.close();
		
		assertEquals(animes.toString(), animes2.toString());
	}
	
	@Test
	public void DeveRetornarOMesmoToStringDeGerenciadorDeListasDeAnimacaoOriental() throws Exception {
		GerenciadorDeListas gerenciador = new GerenciadorDeListas();
		gerenciador.adiciona(new AnimacaoOriental("Nome teste", 1, null, 2021));
		gerenciador.adiciona(new AnimacaoOriental("Nome teste 2", 2, null, 2021));
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testeJUnit.bin"));
		oos.writeObject(gerenciador);
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testeJUnit.bin"));
		GerenciadorDeListas gerenciador2 = (GerenciadorDeListas) ois.readObject();
		ois.close();
		
		assertEquals(gerenciador.getAnimes().toString(), gerenciador2.getAnimes().toString());
	}
	
}
