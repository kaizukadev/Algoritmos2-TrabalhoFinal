package datastructures;

import java.io.FileReader;
import java.util.Comparator;

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
	
	public T search(T key, Comparator<T> cmp)
	{
		return null;
	}
	public void printObjects()
	{}

	public static ListaEncadeada<model.Aluno> loadFromFile(FileReader arquivo)
	{
		return null;
	}
}
