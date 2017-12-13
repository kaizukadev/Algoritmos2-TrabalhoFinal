/*
 * FACULDADE SENAC PORTO ALEGRE
 * Curso.....: Tecnologia em Análise e Desenvolvimento de Sistemas
 * Aluno.....: 631710016 - Sérgio Nunes Ferreira
 * Disciplina: Algoritmos e Programação II - 2017/2
 * Professor.: RAFAEL GUTERRES JEFFMAN
 * 
 * Atividade.: APS03 - Comparação de Objetos

 * Objetivo..: Nesta APS, você deve demonstrar duas comparações de objetos Alunos, 
 * 				a primeira utilizando o Nome, e a segunda, utilizando a Empresa e o Email. 
 * 
 */

import java.util.Comparator;
import comparators.SearchByName;
import comparators.SearchByCompanyAndEmail;
import model.Aluno;

public class APS03 {
	private static final Aluno a1 = new Aluno("dafd78c0","Romero Lane","romerolane@xylar.com",26,"male","XYLAR","Odessa");
	private static final Aluno a2 = new Aluno("fd8e4148","Marisol Shaw","marisolshaw@peticular.com",26,"female","PETICULAR","Knowlton");

	public static void main(String[] args) {
		int nc = 141;

		Aluno.header00(nc,"Comparação por Nome:");
		Aluno.header01(nc);

		comparador(a1, a2, new SearchByName());
		System.out.println(snf.Tools.repeatStr("-", nc));

		comparador(a1, a1, new SearchByName());
		System.out.println(snf.Tools.repeatStr("-", nc));

		comparador(a2, a1, new SearchByName());
		System.out.println(snf.Tools.repeatStr("-", nc));


		System.out.println("");
		Aluno.header00(nc,"Comparação por Empresa+Email:");
		Aluno.header01(nc);

		comparador(a1, a2, new SearchByCompanyAndEmail());
		System.out.println(snf.Tools.repeatStr("-", nc));

		comparador(a1, a1, new SearchByCompanyAndEmail());
		System.out.println(snf.Tools.repeatStr("-", nc));

		comparador(a2, a1, new SearchByCompanyAndEmail());
		System.out.println(snf.Tools.repeatStr("-", nc));
		
	}

	private static void comparador(Aluno a1, Aluno a2,  Comparator<Aluno> cmp) {
		System.out.println(a1);
		System.out.println(mensagemComparativa(cmp.compare(a1,a2)));
		System.out.println(a2);
	}

	private static String mensagemComparativa(int i) {
		String msg = "*** É ";
		if (i<0)
			msg += "MENOR DO QUE";
		else if (i==0)
			msg += "IGUAL A";
		else msg += "MAIOR DO QUE";
		return msg += " ***";
	}

}
