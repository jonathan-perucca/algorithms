package com.jpa.algos;

import java.util.NoSuchElementException;

public interface IQueue<T> {

	public boolean isEmpty();
	public int size();
	public T peek() throws NoSuchElementException;
	public void enqueue(T item) throws NoSuchElementException;
	public T dequeue();
}
