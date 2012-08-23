package com.jpa.algos;

public interface IBinaryTreeNode<T> {

	public T getValue();
	public void setValue(T value);
	public boolean isValueChanged();
	
	public IBinaryTreeNode<T> getParent();
	public IBinaryTreeNode<T> getLeftChild();
	public IBinaryTreeNode<T> getRightChild();
	public IBinaryTreeNode<T> getGrandParent();
    	public IBinaryTreeNode<T> getUncle();

	public void setParent(IBinaryTreeNode<T> node);
	public void setRightChild(IBinaryTreeNode<T> node);
	public void setLeftChild(IBinaryTreeNode<T> node);
	
	public boolean isSimplePoint();
	public boolean isDoublePoint();
	public boolean isLeaf();
	
	public boolean isLeftChild();
	public boolean isRightChild();
	
	public void rotateLeft();
	public void rotateRight();
	
	public String getPath();
	public int getLevel();
}
