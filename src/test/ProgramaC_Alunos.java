package test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;

public class ProgramaC_Alunos {

	private static final String name = "Francisca Bullock";
	private static final String email = "franciscabullock@glasstep.com";
	private static final int idade = 33;
	private static final String cidade = "Eastmont";
	
	public static void main(String[] args) {
		FileReader arquivo = null;
		try {
			arquivo = new FileReader("data/alunos.csv");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		ListaEncadeada<Aluno> lista = ListaEncadeada.loadFromFile(arquivo);
		
		lista.printObjects(" ** LISTA ENCADEADA - Original - Ordenada por leitura **");

		Aluno busca = new Aluno(name, email, idade, cidade);
		System.out.println("Dados para busca:");
		System.out.println(busca + "\n");
		
		
		System.out.println(">>> Busca por Nome:");
		System.out.println(lista.search(busca, new SearchByName()));
		System.out.println("");

		System.out.println(">>> Busca por Email:");
		System.out.println(lista.search(busca, new SearchByEmail()));
		System.out.println("");

		System.out.println(">>> Busca por Idade+Cidade:");
		System.out.println(lista.search(busca, new SearchByAgeAndCity()));
		System.out.println("");
	
	}

		


}