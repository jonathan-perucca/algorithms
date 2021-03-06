package com.jpa.algos;

public interface ISorter<T> {
	
	public void insertionSort(T[] array);
	public void selectionSort(T[] array);
	public void bubbleSort(T[] array);
	public void quickSortWrapper(T[] array);
	public void mergeSortWrapper(T[] array);
}
