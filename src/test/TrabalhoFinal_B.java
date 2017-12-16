package test;

import java.io.FileNotFoundException;
import java.io.FileReader;

import comparators.SearchByAgeAndCity;
import comparators.SearchByEmail;
import comparators.SearchByName;
import datastructures.ListaEncadeada;
import model.Aluno;
import predicates.GenderAndAgePredicate;
import predicates.NamePredicate;

public class TrabalhoFinal_B {

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

		// TRABALHO CONCEITO "B" =============================================

		int nc=141;
		Aluno.header00(nc," Excluindo o seguinte objeto:");
		Aluno.header01(nc);
		System.out.println(lista.search(busca, new SearchByName()));
		lista.removeIf(new NamePredicate(name));
		
		System.out.println("\nTestando exclusão do objeto:");
		if (lista.search(busca, new SearchByName()) != null)
			System.out.println(name + " nao deveria estar na lista.");
		System.out.println(snf.Tools.repeatStr("=", nc));
		System.out.println("");


		// Lista nova, filtrada
		ListaEncadeada<Aluno> lista2 = lista.filter(new GenderAndAgePredicate("female", 20, 30));
		lista2.printObjects(" ** NOVA LISTA ENCADEADA - Filtrada - Mulheres entre 20 e 30 anos (inclusive) **");



	}
}