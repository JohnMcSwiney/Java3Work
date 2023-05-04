/**
 * 
 */
package utilities;

import java.util.NoSuchElementException;

import abstract_data_types.BSTreeADT;
import abstract_data_types.IteratorADT;

import exceptions.TreeException;
import sorting.SortArray;


public class BSTReferencedBased<E extends Comparable<? super E>> implements BSTreeADT<E>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7015805146407625167L;
	
	private int height;
	private int size;
	
	private BSTreeNode<E> rootNode;
	
	/**
	 * 
	 */
	public BSTReferencedBased()
	{
		this.height = 0;
		this.size = 0;
		this.rootNode = null;
	}

	@Override
	public BSTreeNode<E> getRoot() throws TreeException
	{
		if (this.rootNode == null)
		{
			throw new TreeException();
		}
		
		return this.rootNode;
	}

	@Override
	public int getHeight()
	{
		return this.height;
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public boolean isEmpty()
	{
		if (this.rootNode == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clear()
	{
		this.rootNode = null;
		this.size = 0;
		this.height = 0;
	}

	@Override
	public boolean contains(E inputEntry) throws TreeException
	{
		if (this.search(inputEntry) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public BSTreeNode<E> search(E inputEntry) throws TreeException
	{
		if (this.rootNode == null)
		{
			throw new TreeException();
		}
		
		BSTreeNode<E> currentNode = this.rootNode;
		
		while (currentNode != null)
		{
			if (inputEntry.compareTo(currentNode.getContents()) == 0)
			{
				return currentNode;
			}
			else if (inputEntry.compareTo(currentNode.getContents()) < 0)
			{
				currentNode = currentNode.getLeftChildNode();
			}
			else if (inputEntry.compareTo(currentNode.getContents()) > 0)
			{
				currentNode = currentNode.getRightChildNode();
			}
		}
		
		return null;
	}

	@Override
	public boolean add(E inputNewEntry) throws NullPointerException
	{
		if (inputNewEntry == null)
		{
			throw new NullPointerException();
		}
		
		if (this.rootNode == null)
		{
			BSTreeNode<E> tempNode = new BSTreeNode<>(inputNewEntry);
			
			this.rootNode = tempNode;
			
			this.height++;
			this.size++;
			
			return true;
		}
		else
		{
			int currentLevel = 1;
			BSTreeNode<E> currentNode = this.rootNode;
			BSTreeNode<E> previousNode = null;
			boolean leftTraversal = false;
			
			while (currentNode != null)
			{
				if (inputNewEntry.compareTo(currentNode.getContents()) < 0)
				{
					previousNode = currentNode;
					currentNode = currentNode.getLeftChildNode();
					currentLevel++;
					leftTraversal = true;
				}
				else if (inputNewEntry.compareTo(currentNode.getContents()) > 0)
				{
					previousNode = currentNode;
					currentNode = currentNode.getRightChildNode();
					currentLevel++;
					leftTraversal = false;
				}
			}
			
			//if the spot found for the new node is on a level greater than the current height of the tree
			//increment the height by 1
			if (currentLevel > this.getHeight())
			{
				this.height++;
			}
			
			currentNode = new BSTreeNode<>(inputNewEntry);
			
			currentNode.setParentNode(previousNode);
			
			if (leftTraversal)
			{
				previousNode.setLeftChildNode(currentNode);
			}
			else
			{
				previousNode.setRightChildNode(currentNode);
			}
			
			this.size++;
			
			return true;
		}
	}

	@Override
	public IteratorADT<E> inorderIterator()
	{
		return new orderedIterator("in");
	}

	@Override
	public IteratorADT<E> preorderIterator()
	{
		return new orderedIterator("pre");
	}

	@Override
	public IteratorADT<E> postorderIterator()
	{
		return new orderedIterator("post");
	}
	
	public IteratorADT<E> alphabetisedIterator()
	{
		return new orderedIterator("alpha");
	}
	
	/*****************************PRIVATE CLASSES*****************************/
	private class orderedIterator implements IteratorADT<E>
	{
		private MyArrayList<E> nodeList = new MyArrayList<>();
		private int currentPosition;
		
		public orderedIterator(String inputOrderType)
		{
			switch (inputOrderType)
			{
				case "pre":		generatePreOrderList(BSTReferencedBased.this.rootNode);
								break;
				case "post":	generateInOrderList(BSTReferencedBased.this.rootNode);
								break;
				case "in":		generatePostOrderList(BSTReferencedBased.this.rootNode);
								break;
				case "alpha":	generateInOrderList(BSTReferencedBased.this.rootNode);
								alphabetiseList();
								break;
			}
			this.currentPosition = 0;
		}
		
		@Override
		public boolean hasNext()
		{
			if (this.currentPosition < this.nodeList.size())
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		@Override
		public E next() throws NoSuchElementException
		{
			if (this.nodeList.size() <=0 || this.currentPosition >= this.nodeList.size())
			{
				throw new NoSuchElementException();
			}
			else
			{
				E nextElement = this.nodeList.get(this.currentPosition);
				
				this.currentPosition++;
				
				return nextElement;
			}
		}
		
		private void generateInOrderList(BSTreeNode<E> inputNode)
		{
			//reached an empty node, don't do anything and go back a level.
			if (inputNode == null)
			{
				return;
			}
			
			//go down the left side until you hit a null node
			generateInOrderList(inputNode.getLeftChildNode());
			
			//only reaches here if it's hit a null node and then continues
			//add node contents to the arrayList
			nodeList.add(inputNode.getContents());
			
			//left side was null, we've added current node to arraylist
			//now go down the right side
			generateInOrderList(inputNode.getRightChildNode());
		}
		
		private void generatePreOrderList(BSTreeNode<E> inputNode)
		{
			//reached an empty node, don't do anything and go back a level.
			if (inputNode == null)
			{
				return;
			}
			
			//add node contents to the arrayList
			nodeList.add(inputNode.getContents());
			
			//go down the left side until you hit a null node
			generatePreOrderList(inputNode.getLeftChildNode());
			
			//left side was null, we've added current node to arraylist
			//now go down the right side
			generatePreOrderList(inputNode.getRightChildNode());
		}
		
		private void generatePostOrderList(BSTreeNode<E> inputNode)
		{
			//reached an empty node, don't do anything and go back a level.
			if (inputNode == null)
			{
				return;
			}
			
			//go down the left side until you hit a null node
			generatePreOrderList(inputNode.getLeftChildNode());
			
			//left side was null, we've added current node to arraylist
			//now go down the right side
			generatePreOrderList(inputNode.getRightChildNode());
			
			//add node contents to the arrayList
			// since nodes get added as the last step, ultimately root will always be the last node
			nodeList.add(inputNode.getContents());
		}
		
		@SuppressWarnings("unchecked")
		private void alphabetiseList()
		{
			E[] tempArray = (E[]) new Comparable[0];
			
			tempArray = this.nodeList.toArray(tempArray);
			
			SortArray.mergeSort(tempArray);
			
			this.nodeList = new MyArrayList<E>();
			
			for (int i = tempArray.length - 1 ; i > -1 ; i--)
			{
				if (tempArray[i].compareTo((E) new Word("")) == 0)
				{
					System.out.println("Blank found, index " + i + " in tempArray during alphabetise");
				}
				this.nodeList.add(tempArray[i]);
			}
		}
	}
	/*************************END OF PRIVATE CLASSES**************************/
}
