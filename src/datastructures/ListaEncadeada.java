package datastructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import comparators.SearchByName;
import model.Aluno;



public class ListaEncadeada<T> {
	private Node<T> head;
	private Node<T> tail;

	public ListaEncadeada() {
		this.head = null;
		this.tail = null;
	}  

	public boolean isEmpty() {
		return this.head == null && this.tail == null;   
	}

	public void append(T dado) {
		Node<T> newNode = new Node<T>(dado, this.tail, null);
		if(isEmpty()) {
			this.head = newNode;
		} else {
		tail.setNext(newNode);
		}
		this.tail = newNode;
	}
	
	public void addFirst(T dado) {
		Node<T> newNode = new Node<T>(dado, null, this.head);
		if(isEmpty()) {
			this.tail = newNode;
		} else {
		head.setPrevious(newNode);
		}
		this.head = newNode;

	}
	
	public void printObjects(String msg) {
		int nc=141;
		int ne=0;
		Aluno.header00(nc,msg);
		Aluno.header01(nc);
		
		Node<T> i = head;
		while (i != null) {
			System.out.println(i.getData());
			i = i.getNext();
			ne++;
		}
		System.out.println(snf.Tools.repeatStr("=", nc));
		System.out.println(" >> Total de Elementos da Lista Encadeada: " + ne + "\n\n");
	}

	public static ListaEncadeada<Aluno> loadFromFile(FileReader arquivo) {
		ListaEncadeada<Aluno> le = new ListaEncadeada<Aluno>();
		final String SEPARADOR = ",";
		BufferedReader is = null;
		String linha = null;
		String[] dl;
		is = new BufferedReader(arquivo);
		try {
			while ((linha = is.readLine()) != null) {
				dl = linha.split(SEPARADOR);
				
				Aluno a = new Aluno(dl[0], dl[1], dl[2], Integer.parseInt(dl[3]), dl[4], dl[5], dl[6]);
				le.append(a);
//				System.out.println(a);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					snf.Tools.errormsg(e,true);	
				}
			}
		}
		return le;
	}

	public T search(T key, Comparator<T> cmp) {
		Node<T> i = head;
		T obj = null;
		while (i != null) {
			obj = i.getData();

			if (cmp.compare(key,obj) == 0)
				break;
			
			i = i.getNext();
		}
		return obj;
	}
	
	
	
	
}
