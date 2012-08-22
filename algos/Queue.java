package com.jpa.algos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements IQueue<T>, Iterable<T>{

	private class Node{
		private T item;
		private Node next;
		
		public Node(T item){
			this.item = item;
			next = null;
		}
	}
	
	private int size;
	private Node first;
	private Node last;
	
	public boolean isEmpty() {
		return first == null;
	}

	public T peek() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException();
		return first.item;
	}

	public T dequeue() throws NoSuchElementException{
		if(isEmpty())
			throw new NoSuchElementException();
		T item = first.item;
		first = first.next;
		size--;
		if(isEmpty())
			last = null;
		return item;
	}

	public void enqueue(T item) {
		Node lastHolder = last;
		last = new Node(item);
		if(isEmpty())
			first = last;
		else
			lastHolder.next = last;
		size++;
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(T item : this)
			builder.append(item + " ");
		return builder.toString();
	}

	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	 private class ListIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
        	return current != null;
        }
        
        public void remove() { 
        	throw new UnsupportedOperationException();  
        }

        public T next() throws NoSuchElementException{
            if(!hasNext()) 
            	throw new NoSuchElementException();
            T item = current.item;
            current = current.next; 
            return item;
        }
    }
}
