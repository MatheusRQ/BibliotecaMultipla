package br.com.teste.testesAutomatizados.methodMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import br.com.teste.corpo.AnimacaoOriental;

public class TesteDeDeserializacao {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teste.bin"));
		AnimacaoOriental animes = (AnimacaoOriental) ois.readObject();
		ois.close();
		System.out.println(animes);
	}
}