package com.jpa.algos;

public class LinkedList<T> implements ILinkedList<T>{

	private int size;
	private Node<T> head;
	private Node<T> current;
	
	public LinkedList(){
		this.head = this.current = null;
		size = 0;
	}

	private boolean isOperable(){
		return size > 1;
	}
	
	public void appendAfterCurrent(Node<T> node) {
		if(isEmpty())
			current = head = node;
		else{
			node.next = current.next;
			current.next = node;
		}
	}

	public void appendBack(Node<T> node) {
		if(isEmpty())
			current = head = node;
		else{
			Node<T> cursor = current;
			while(null != cursor.next)
				cursor = cursor.next;
			cursor.next = node;
			node.next = null;
		}
		size++;
	}

	public void appendBeforeCurrent(Node<T> node) {
		if(isEmpty())
			current = head = node;
		else{
			Node cursor = head;
			while(null != cursor.next && cursor.next != current)
				cursor = cursor.next;
			
			cursor.next = node;
			node.next = current;
		}
		size++;
	}

	public void appendFront(Node<T> node) {
		if(isEmpty())
			current = head = node;
		else{
			node.next = head;
			head = node;
		}
		size++;
	}

	public void first() {
		if(isOperable() && current != head)
			current = head;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFirst() {
		return current == head;
	}

	public boolean isLast() {
		return current.next == null;
	}

	public void last() {
		if(isOperable())
			while(null != current.next)
				current = current.next;
	}

	public void moveCurrentNodeToFirst() {
		if(!isOperable()) return;
		
		Node cursor = head;
		while(null != cursor.next && cursor.next != current)
			cursor = cursor.next;
		
		cursor.next = current.next;
		current.next = head;
		head = current;
	}

	public void moveCurrentNodeToLast() {
		if(!isOperable()) return;
		
		if(current == head){
			Node<T> cursor = head;
			head = head.next;
			last();
			current.next = cursor;
			cursor.next = null;
		}else{
			Node<T> cursor = current;

			while(null != cursor.next && cursor.next != current)
				cursor = cursor.next;

			cursor.next = current.next;
			cursor = current;
			last();
			current.next = cursor;
			last();
		}
	}

	public void next() {
		if(isOperable())
			current = current.next;
	}

	public void prev() {
		if(isOperable()){
			Node<T> cursor = head;
			while(null != cursor.next && cursor.next != current)
				cursor = cursor.next;
			current = cursor;
		}
	}

	public void remove() {
		if(isEmpty()) return;
		if(size == 1){
			head = current = null;
			return;
		}else{
			Node<T> cursor = head;
			while(null != cursor.next && cursor.next != current)
				cursor = cursor.next;
			
			cursor.next = current.next;
			current = cursor;
		}
		size--;
	}

	public void removeAll() {
		current = null;
		head = null;
		size = 0;
	}

	public void replaceCurrentNode(Node<T> node) {
		if(isEmpty()) return;
		if(size == 1){
			head = node;
			node = null;
		}
		
		Node<T> cursor = head;
		while(cursor.next != current)
			cursor = cursor.next;
		
		cursor.next = node;
		node.next = current.next;
		current = node;
	}

	public int size() {
		return size;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		if(isEmpty())
			result.append("This linkedlist is empty");
		else{
			result.append("The current Node is : " + this.current.item + "\n");
			Node cursor = this.head;
			result.append("Head("+cursor.item+")");
			while(null != cursor.next){
				result.append("-->[" + cursor.next.item + "]");
				cursor = cursor.next;
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		Node<String> node1 = new Node<String>("Node1");
		Node<String> node2 = new Node<String>("Node2");
		Node<String> node3 = new Node<String>("Node3");
		Node<String> node4 = new Node<String>("Node4");
		Node<String> nodeAfterTheCurrent = new Node<String>("NodeAfterTheCurrent");
		Node<String> newNode = new Node<String>("New Node");
		Node<String> nodeBeforeTheCurrent = new Node<String>("NodeBeforeTheCurrent");
		LinkedList<String> linkedlist = new LinkedList<String>();

		if(linkedlist.isEmpty())
		System.out.println("LinkedList Empty!");

		/* Adding nodes */
		System.out.println("Appending nodes...\n-------------------------");
		linkedlist.appendFront(node1);
		linkedlist.appendBack(node2);
		linkedlist.appendFront(node3);
		linkedlist.appendFront(node4);
		linkedlist.appendAfterCurrent(nodeAfterTheCurrent);
		linkedlist.appendBeforeCurrent(nodeBeforeTheCurrent);
		System.out.println(linkedlist);

		/* replacing actions */
		System.out.println("Replacing current node...\n-------------------------");
		linkedlist.replaceCurrentNode(newNode);
		System.out.println(linkedlist);

		/* Cursor movements */
		System.out.println("Cursor movements \n-------------------------");
		linkedlist.next();
		System.out.println(linkedlist);
		linkedlist.first();
		System.out.println(linkedlist);
		linkedlist.last();
		System.out.println(linkedlist);
		linkedlist.prev();
		System.out.println(linkedlist);

		/* Node movements */
		System.out.println("Node movements \n-------------------------");
		linkedlist.moveCurrentNodeToFirst();
		System.out.println(linkedlist);
		linkedlist.moveCurrentNodeToLast();
		System.out.println(linkedlist);

		/* Node deletion */
		System.out.println("Node deletion\n-------------------------");
		linkedlist.remove();
		System.out.println(linkedlist);
		linkedlist.removeAll();
		System.out.println(linkedlist);
	}
}
