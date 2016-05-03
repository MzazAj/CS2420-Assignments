package assignment08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Creates a Binary Search Tree
 * 
 * @author Brian Rodriguez and Michael Kim
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> 
{
	
	private BinaryNode root;

	/**
	 * Creates an empty BinarySearchTree();
	 */
	public BinarySearchTree()
	{
		root = null;
	}
	
	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually inserted); otherwise, returns
	 *         false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean add(T item) 
	{
		if(item == null)
		{
			throw new NullPointerException();
		}
		if(root == null)
		{
			root = new BinaryNode(item);
			return true;
		}
		else
		{
			return add(item, root);
		}
	}

	/**
	 * Recursive method for add
	 * @param item
	 * @param node
	 * @return
	 */
	private boolean add(T item, BinaryNode node) 
	{
		if(item.equals(node.item))
		{
			return false;
		}
		else if(item.compareTo(node.item) < 0)
		{
			if(node.left == null)
			{
				node.left = new BinaryNode(item);
				return true;
			}
			else
			{
				return add(item, node.left);
			}
		}
		else
		{
			if(node.right == null)
			{
				node.right = new BinaryNode(item);
				return true;
			}
			else
			{
				return add(item, node.right);
			}
		}
	}
	
	  /**
	   * Ensures that this set contains all items in the specified collection.
	   * 
	   * @param items
	   *          - the collection of items whose presence is ensured in this set
	   * @return true if this set changed as a result of this method call (that is,
	   *         if any item in the input collection was actually inserted);
	   *         otherwise, returns false
	   * @throws NullPointerException
	   *           if any of the items is null
	   */
	@Override
	public boolean addAll(Collection<? extends T> items) 
	{	
		boolean hasChanged = false;
		
		for(T item: items)
		{
			if(item == null)
			{
				throw new NullPointerException();
			}
			if(this.add(item))
			{
				hasChanged = true;
			}
		}
		return hasChanged;
	}
	

	/**
	 * Removes all items from this set. The set will be empty after this method
	 * call.
	 */
	@Override
	public void clear() 
	{
		root = null;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item
	 *            - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input
	 *         item; otherwise, returns false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	@Override
	public boolean contains(T item)
	{
		if(item == null)
		{
			throw new NullPointerException();
		}
		return contains(root,item);
	}

	/**
	 * Recursive contains method
	 * @param node
	 * @param item
	 * @return
	 */
	private boolean contains(BinaryNode node,T item) 
	{
		if(node == null)
		{
			return false;
		}
		else if(item.equals(node.item))
		{
			return true;
		}
		else if(item.compareTo(node.item) < 0)
		{
			return contains(node.left, item);
		}
		else
		{
			return contains(node.right, item);
		}
	}

	/**
	 * Determines if for each item in the specified collection, there is an item
	 * in this set that is equal to it.
	 * 
	 * @param items
	 *            - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an
	 *         item in this set that is equal to it; otherwise, returns false
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean containsAll(Collection<? extends T> items) 
	{
		for(T item : items)
		{
			if(item == null)
			{
				throw new NullPointerException();
			}
			if(!this.contains(item))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the first (i.e., smallest) item in this set.
	 * 
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public T first() throws NoSuchElementException 
	{
		if(size() == 0)
		{
			throw new NoSuchElementException();
		}
		
		return first(root);
	}

	/**
	 * Recursive method for first
	 * @param node
	 * @return
	 */
	private T first(BinaryNode node) 
	{
		if(node.left == null)
		{
			return node.item;
		}
		
		return first(node.left);
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty() 
	{
		return root == null;
	}

	/**
	 * Returns the last (i.e., largest) item in this set.
	 * 
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public T last() throws NoSuchElementException 
	{
		if(size() == 0)
		{
			throw new NoSuchElementException();
		}	
		return last(root);
	}
	
	/**
	 * Recursive call for last
	 * @param node
	 * @return
	 */
	private T last(BinaryNode node)
	{
		if(node.right == null)
		{
			return node.item;
		}
		
		return last(node.right);
	}

	/**
	 * Ensures that this set does not contain the specified item.
	 * 
	 * @param item
	 *            - the item whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually removed); otherwise, returns
	 *         false
	 * @throws NullPointerException
	 *             if the item is null
	 */
	public boolean remove(T item) 
	{
		if(item == null)
		{
			throw new NullPointerException();
		}
		else if(root == null)
		{
			return false;
		}
//		else if(!this.contains(item))
//		{
//			return false;
//		}
		else
		{
			return remove(item, root);
		}
	}
	
	private boolean remove(T item, BinaryNode node)
	{
		
			BinaryNode parent = null;
			
			while(true)
			{
		
				if(node == null)
				{
					return false;
				}
				else if(item.compareTo(node.item) < 0)
				{
					parent = node;
					node = node.left;
				}
				else if(item.compareTo(node.item) > 0)
				{
					parent = node;
					node = node.right;
				}
				else
				{
					if(node.left == null && node.right == null)
					{
						if(parent == null)
						{
							this.root = null;
						}
						else if(node.equals(parent.left))
						{
							parent.left = null;
						}
						else if(node.equals(parent.right))
						{
							parent.right = null;
						}
					}
					else if(node.left == null)
					{
						if(parent == null)
						{
							this.root = node.right;
						}
						else if(node.equals(parent.left))
						{
							parent.left = node.right;
						}
						else
						{
							parent.right = node.right;
						}
					}
					else if(node.right == null)
					{
						if(parent == null)
						{
							this.root = node.left;
						}
						else if(node.equals(parent.left))
						{
							parent.left = node.left;
						}
						else
						{
							parent.right = node.left;
						}
					}
					else
					{
						BinaryNode successor = node.right; 
						BinaryNode successorparent = node;
						while(successor.left != null)
						{
							successorparent = successor;
							successor = successor.left;
						}
						if(parent == null)
						{
							root = successor;
						}
						else if(node.equals(parent.left))
						{
							parent.left = successor;
						}
						else
						{
							parent.right = successor;
						}
						if(successor.equals(successorparent.left))
						{
							successorparent.left = successor.right;
						}
						else
						{
							successorparent.right = successor.right;
						}
						successor.right = node.right;
						successor.left = node.left;
					}
					return true;
				}
			}
	}
	

	/**
	 * Ensures that this set does not contain any of the items in the specified
	 * collection.
	 * 
	 * @param items
	 *            - the collection of items whose absence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually removed);
	 *         otherwise, returns false
	 * @throws NullPointerException
	 *             if any of the items is null
	 */
	@Override
	public boolean removeAll(Collection<? extends T> items) 
	{
		boolean hasChanged = false;
		
		for(T item: items)
		{
			if(item == null)
			{
				throw new NullPointerException();
			}
			if(this.remove(item))
			{
				hasChanged = true;
			}
		}
		
		return hasChanged;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size()
	{
		return size(root);
	}

	private int size(BinaryNode node) 
	{
		return node == null ? 0 : (size(node.left) + size(node.right) + 1);
	}

	/**
	 * Returns an ArrayList containing all of the items in this set, in sorted
	 * order.
	 */
	@Override
	public ArrayList<T> toArrayList() 
	{
		ArrayList<T> BSTList = new ArrayList<>();
		
		return toArrayList(BSTList, root);
	}

	/**
	 * Recursive method for toArrayList
	 * @param BSTList
	 * @param node
	 * @return
	 */
	private ArrayList<T> toArrayList(ArrayList<T> BSTList, BinaryNode node) 
	{
		if(node == null)
		{
			return BSTList;
		}
		else
		{
			toArrayList(BSTList, node.left);
			BSTList.add(node.item);
			toArrayList(BSTList, node.right);
		}
		return BSTList;
	}
	
	// Driver for writing this tree to a dot file
	public void writeDot(String filename)
	{
		try {
			// PrintWriter(FileWriter) will write output to a file
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			
			// Set up the dot graph and properties
			output.println("digraph BST {");
			output.println("node [shape=record]");
			
			if(root != null)
				writeDotRecursive(root, output);
			// Close the graph
			output.println("}");
			output.close();
		}
		catch(Exception e){e.printStackTrace();}
	}

	
	// Recursive method for writing the tree to  a dot file
	private void writeDotRecursive(BinaryNode node, PrintWriter output) throws Exception
	{
		output.println(node.item + "[label=\"<L> |<D> " + node.item + "|<R> \"]");
		if(node.left != null)
		{
			// write the left subtree
			writeDotRecursive(node.left, output);
			
			// then make a link between n and the left subtree
			output.println(node.item + ":L -> " + node.left.item + ":D" );
		}
		if(node.right != null)
		{
			// write the left subtree
			writeDotRecursive(node.right, output);
			
			// then make a link between n and the right subtree
			output.println(node.item + ":R -> " + node.right.item + ":D" );
		}
		
	}
	
	/**
	 *BinaryNode class to add elements to the tree
	 *
	 * @param <E>
	 */
	private class BinaryNode 
	{
		T item;
		BinaryNode left;
		BinaryNode right;
		
		BinaryNode(T element)
		{
			this.item = element;
			this.left = null;
			this.right = null;
		}
	}

}
