package utilities;

import java.io.Serializable;

public class BSTreeNode<E extends Comparable<? super E>> implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6020744108920886282L;
	
	private BSTreeNode<E> parentNode;
	private BSTreeNode<E> leftChildNode;
	private BSTreeNode<E> rightChildNode;
	
	private E contents;

	public BSTreeNode()
	{
		this.parentNode = null;
		this.leftChildNode = null;
		this.rightChildNode = null;
		
		this.contents = null;
	}
	
	public BSTreeNode(E inputContents)
	{
		this();
		this.contents = inputContents;
	}
	
	public BSTreeNode(BSTreeNode<E> inputParentNode, BSTreeNode<E> inputLeftChildNode
						, BSTreeNode<E> inputRightChildNode, E inputContents)
	{
		this.parentNode = inputParentNode;
		this.leftChildNode = inputLeftChildNode;
		this.rightChildNode = inputRightChildNode;
		
		this.contents = inputContents;
	}
	
	/**
	 * @return the parentNode
	 */
	public BSTreeNode<E> getParentNode()
	{
		return parentNode;
	}

	/**
	 * @param inputParentNode the parentNode to set
	 */
	public void setParentNode(BSTreeNode<E> inputParentNode)
	{
		this.parentNode = inputParentNode;
	}

	/**
	 * @return the leftChildNode
	 */
	public BSTreeNode<E> getLeftChildNode()
	{
		return leftChildNode;
	}

	/**
	 * @param inputLeftChildNode the leftChildNode to set
	 */
	public void setLeftChildNode(BSTreeNode<E> inputLeftChildNode)
	{
		this.leftChildNode = inputLeftChildNode;
	}

	/**
	 * @return the rightChildNode
	 */
	public BSTreeNode<E> getRightChildNode()
	{
		return rightChildNode;
	}

	/**
	 * @param inputRightChildNode the rightChildNode to set
	 */
	public void setRightChildNode(BSTreeNode<E> inputRightChildNode)
	{
		this.rightChildNode = inputRightChildNode;
	}

	/**
	 * @return the contents
	 */
	public E getContents()
	{
		return contents;
	}

	/**
	 * @param inputContents the contents to set
	 */
	public void setContents(E inputContents)
	{
		this.contents = inputContents;
	}
}
