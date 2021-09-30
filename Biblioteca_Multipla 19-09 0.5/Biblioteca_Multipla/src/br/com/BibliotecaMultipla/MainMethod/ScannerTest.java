package br.com.BibliotecaMultipla.MainMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import br.com.BibliotecaMultipla.Categoria.CategoriaEnum;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o nome do anime: ");
		String nome = sc.nextLine();
		System.out.print("Insira o ano de lancamento: ");
		Integer ano = sc.nextInt();
		System.out.print("Insira o(s) genero(s): ");
		String genero = sc.next();
		System.out.println("Insira a categoria que deseja: ");
		List<CategoriaEnum> enums = new ArrayList<>(Arrays.asList(CategoriaEnum.values()));
		for (CategoriaEnum categoriaEnum : enums) {
			System.out.println(categoriaEnum.categoriaId() + " - " + categoriaEnum.categoriaNome());
		}
		Integer categoria = sc.nextInt();
		System.out.print("Insira o numero de episodios: ");
		Integer episodios = sc.nextInt();
		System.out.println("Insira sua nota entre 0 e 10: ");
		Double nota = sc.nextDouble();
	}
}
