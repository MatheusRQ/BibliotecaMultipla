package br.com.teste.testesAutomatizados.methodMain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.teste.corpo.AnimacaoOriental;
import br.com.teste.corpo.GerenciadorDeListas;

public class TesteDeSerializacaoGerenciadorDeListas {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		GerenciadorDeListas gerenciador = new GerenciadorDeListas();
		gerenciador.adiciona(new AnimacaoOriental("Nome teste", 1, null, 2021));
		gerenciador.adiciona(new AnimacaoOriental("Nome teste 2", 2, null, 2021));
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teste2.bin"));
		oos.writeObject(gerenciador);
		oos.close();
	}
}
