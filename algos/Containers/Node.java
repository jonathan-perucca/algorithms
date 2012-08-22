package com.jpa.algos;

public class Node<T> {
	T item;
	Node<T> next;
	
	public Node(T object){
		this.item = object;
		this.next = null;
	}
	
	public Node(T object, Node<T> next) {
		this.item = object;
		this.next = next;
	}
}
