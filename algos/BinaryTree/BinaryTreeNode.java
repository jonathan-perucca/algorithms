package com.jpa.algos;

public class BinaryTreeNode<T> implements IBinaryTreeNode<T>{

	private T value;
	private boolean changed = false;
	private IBinaryTreeNode<T> parent, left, right;
	
	public BinaryTreeNode(T value) {
		this.value = value;
	}

	public IBinaryTreeNode<T> getGrandParent() {
		return (null != parent && null != parent.getParent()) ? parent.getParent() : null;
	}

	public IBinaryTreeNode<T> getLeftChild() {
		return left;
	}

	public int getLevel() {
		return (null != parent) ? parent.getLevel() + 1 : 0;
	}

	public IBinaryTreeNode<T> getParent() {
		return parent;
	}

	public String getPath() {
		return (null != parent) ? parent.getPath() + (isLeftChild() ? "0" : "1") : "";
	}

	public IBinaryTreeNode<T> getRightChild() {
		return right;
	}

	public IBinaryTreeNode<T> getUncle() {
		IBinaryTreeNode<T> grandParent = getGrandParent();
		if(null != grandParent)
			return (parent.isLeftChild()) ? grandParent.getRightChild() : grandParent.getLeftChild();
		return null;
	}

	public boolean isDoublePoint() {
		return (null != left && null != right);
	}

	public boolean isLeaf() {
		return (null == left && null == right);
	}

	public boolean isLeftChild() {
		return (null != parent && this == parent.getLeftChild());
	}

	public boolean isRightChild() {
		return (null != parent && this == parent.getRightChild());
	}

	public boolean isSimplePoint() {
		return (null == left ^ null == right);
	}

	public boolean isValueChanged() {
		return changed;
	}

	public void rotateLeft() {
		if(null != right){
			if(null != parent){
				if(this.isRightChild())
					parent.setRightChild(right);
				else
					parent.setLeftChild(right);
			}
			IBinaryTreeNode<T> leftHolder = right.getLeftChild();
			right.setLeftChild(this);
			setRightChild(leftHolder);
		}
	}

	public void rotateRight() {
		if(null != left){
			if(null != parent){
				if(this.isRightChild())
					parent.setRightChild(left);
				else
					parent.setLeftChild(left);
			}
			IBinaryTreeNode<T> rightHolder = left.getRightChild();
			left.setRightChild(this);
			setLeftChild(rightHolder);
		}
	}

	public void setLeftChild(IBinaryTreeNode<T> node) {
		if(null != node)
			node.setParent(this);
		left = node;
	}

	public void setParent(IBinaryTreeNode<T> node) {
		this.parent = node;
	}

	public void setRightChild(IBinaryTreeNode<T> node) {
		if(node != right)
			node.setParent(this);
		right = node;
	}

	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}

}
