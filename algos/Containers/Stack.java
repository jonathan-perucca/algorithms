package com.jpa.algos;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements IStack<T>, Iterable<T>{

	private int size;
    private Node first;

    private class Node {
        private T item;
        private Node next;
        
        public Node(T item, Node next){
        	this.item = item;
        	this.next = next;
        }
    }

    public Stack() {
        first = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        Node firstHolder = first;
        first = new Node(item, firstHolder);
        size++;
    }

    public T pop() throws NoSuchElementException{
        if (isEmpty()) 
        	throw new NoSuchElementException();
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public T peek() throws NoSuchElementException{
        if (isEmpty()) 
        	throw new NoSuchElementException();
        return first.item;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T item : this)
        	builder.append(item + " ");
        return builder.toString();
    }
       
    public Iterator<T> iterator()  { 
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

        public T next() {
            if(!hasNext()) 
            	throw new NoSuchElementException();
            T item = current.item;
            current = current.next; 
            return item;
        }
    }
}
