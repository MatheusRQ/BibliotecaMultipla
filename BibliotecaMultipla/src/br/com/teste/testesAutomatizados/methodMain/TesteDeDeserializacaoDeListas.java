package br.com.teste.testesAutomatizados.methodMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.teste.corpo.GerenciadorDeListas;

public class TesteDeDeserializacaoDeListas {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teste2.bin"));
		GerenciadorDeListas gerenciador = (GerenciadorDeListas) ois.readObject();
		ois.close();
		System.out.println(gerenciador.getAnimes());
	}
}
