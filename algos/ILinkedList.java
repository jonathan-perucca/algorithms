package com.jpa.algos;

public interface ILinkedList<T> {

	public void first();
	public void last();
	public void next();
	public void prev();
	
	public boolean isEmpty();
	public boolean isFirst();
	public boolean isLast();
	
	public int size();
	
	public void moveCurrentNodeToFirst();
	public void moveCurrentNodeToLast();
	
	public void appendFront(Node<T> node);
	public void appendBack(Node<T> node);
	public void appendBeforeCurrent(Node<T> node);
	public void appendAfterCurrent(Node<T> node);
	
	public void replaceCurrentNode(Node<T> node);
	public void remove();
	public void removeAll();
}
