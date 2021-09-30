package br.com.BibliotecaMultipla.MainMethod;

import java.sql.Timestamp;

import br.com.BibliotecaMultipla.AudioVisual.Animacao_Assistido;

public class TestaInsercao {

	public static void main(String[] args) {
		int myYear = 2014;
		int myMonth = 3;
		int myDay = 24;
		Timestamp ts = Timestamp.valueOf(String.format("%04d-%02d-%02d 00:00:00", 
		                                                myYear, myMonth, myDay));
		Animacao_Assistido aa = new Animacao_Assistido(3, "Nome de teste ASSISTIDO", 2020, "Acao e fantasia", ts, "ANIMACAO_ORIENTAL", 12, ts, 6.0);
		
		System.out.println(aa.toString());
		
	}
}
