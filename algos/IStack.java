package com.jpa.algos;

import java.util.NoSuchElementException;

public interface IStack<T> {

	public void push(T item);
	public T pop() throws NoSuchElementException;
	public T peek() throws NoSuchElementException;
	public boolean isEmpty();
	public int size();
}
