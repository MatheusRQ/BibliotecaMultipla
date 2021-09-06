package br.com.teste.testesAutomatizados.methodMain;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.teste.corpo.AnimacaoOriental;

public class TesteDeSerializacao {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		AnimacaoOriental animes = new AnimacaoOriental("Nome Teste", 15, "Ação/Aventura", 2021);
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("teste.bin"));
		oss.writeObject(animes);
		oss.close();
	}
}