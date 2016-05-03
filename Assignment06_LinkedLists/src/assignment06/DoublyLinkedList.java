package assignment06;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 * @param <E>
 */
public class DoublyLinkedList<E> implements List<E>, Iterable<E>
{
	private int size = 0;
		
	private Node<E> first;
	
	private Node<E> last;
	
	/**
	 * Creates an empty DoublyLinkedList();
	 */
	public DoublyLinkedList()
	{
		
	}
	
	/**
	 * * Inserts the specified element at the beginning of the list. * O(1) for
	 * a doubly-linked list.
	 */
	@Override
	public void addFirst(E element) 
	{
		//
		Node<E> start = first;
		//This node will be the new first in the list
		Node<E> newFirst = new Node<E>(null, element, start);
		//first is now = to new first
		first = newFirst;
		
		if(start == null)
		{
			last = newFirst;
		}
		else
		{
			start.prev = newFirst;
		}
		size++;
	}

	/**
	 * * Inserts the specified element at the end of the list. * O(1) for a
	 * doubly-linked list.
	 */
	@Override
	public void addLast(E element) 
	{
		Node<E> end = last;
		
		Node<E> newLast = new Node<E>(end, element, null);
		
		last = newLast;
		
		if(end == null)
		{
			first = newLast;
		}
		else
		{
			end.next = newLast;
		}
		size++;
	}

	/**
	 * * Inserts the specified element at the specified position in the list. *
	 * Throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 * index > size()) O(N) for a doubly-linked list.
	 */
	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}
		if(index == size)
		{
			this.addLast(element);
		}
		else
		{
			Node<E> current = getNode(index);
			
			Node<E> prev = current.prev;
			
			Node<E> newNode = new Node<E>(prev, element, current);
			
			current.prev = newNode;
			
			if(prev == null)
			{
				first = newNode;
			}
			else
			{
				prev.next = newNode;
			}
			size++;
		}
	}

	/**
	 * * Returns the first element in the list. * Throws NoSuchElementException
	 * if the list is empty. * O(1) for a doubly-linked list.
	 */
	@Override
	public E getFirst() throws NoSuchElementException 
	{
		if(size <= 0)
		{
			throw new NoSuchElementException();
		}
		
		return first.item;
	}

	/**
	 * * Returns the last element in the list. * Throws NoSuchElementException
	 * if the list is empty. * O(1) for a doubly-linked list.
	 */
	@Override
	public E getLast() throws NoSuchElementException 
	{
		if(size <= 0)
		{
			throw new NoSuchElementException();
		}
		return last.item;
	}

	/**
	 * * Returns the element at the specified position in the list. * Throws
	 * IndexOutOfBoundsException if index is out of range (index < 0 || index >=
	 * size()) O(N) for a doubly-linked list.
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> node;
		
		if(index > size / 2)
		{
			node = last;
			
			for(int i = size - 1; i > index;i--)
			{
				node = node.prev;
			}
		}
		else
		{
			node = first;

			for (int i = 0; i < index; i++) 
			{
				node = node.next;
			}
		}
		
		return node.item;
	}

	/**
	 * * Removes and returns the first element from the list. * Throws
	 * NoSuchElementException if the list is empty. * O(1) for a doubly-linked
	 * list.
	 */
	@Override
	public E removeFirst() throws NoSuchElementException 
	{
		if(first == null)
		{
			throw new NoSuchElementException();
		}
		
		return unlinkNode(first);
	}

	/**
	 * * Removes and returns the last element from the list. * Throws
	 * NoSuchElementException if the list is empty. * O(1) for a doubly-linked
	 * list.
	 */
	@Override
	public E removeLast() throws NoSuchElementException 
	{
		if(this.isEmpty() == true)
		{
			throw new NoSuchElementException();
		}
		
		return unlinkNode(last);
	}

	/**
	 * * Removes and returns the element at the specified position in the list.
	 * * Throws IndexOutOfBoundsException if index is out of range (index < 0 ||
	 * index >= size()) O(N) for a doubly-linked list.
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException 
	{
		if(index < 0 || index >=size)
		{
			throw new NoSuchElementException();
		}

		return unlinkNode(getNode(index));
	}

	/**
	 * * Returns the index of the first occurrence of the specified element in
	 * the list, or -1 if this list does not contain the element. * O(N) for a
	 * doubly-linked list.
	 */
	@Override
	public int indexOf(E element) 
	{
		Node<E> node = first;
				
		for(int index = 0;index < size;index++)
		{
			if(node.item == null && element == null)
			{
				return index;
			}
			else if(node.item == null)
			{
				
			}
			else if(node.item.equals(element))
			{
				return index;
			}
			
			node = node.next;
		}
		
		return -1;
	}

	/**
	 * * Returns the index of the last occurrence of the specified element in
	 * this list, or -1 if this list does not contain the element. * O(N) for a
	 * doubly-linked list.
	 */
	@Override
	public int lastIndexOf(E element) 
	{
		Node<E> node = first;
		
		int indexOfLastOcc = -1;
		
		for(int i = 0; i < size;i++)
		{
			if(node.item == null && element == null)
			{
				indexOfLastOcc = i;
			}
			else if(node.item == null)
			{
				
			}
			else if(node.item.equals(element))
			{
				indexOfLastOcc = i;
			}
			node = node.next;
		}
		
		if(indexOfLastOcc == -1)
		{
			return indexOfLastOcc;
		}
		else
		{
			return indexOfLastOcc;
		}
	}

	/**
	 * * Returns the number of elements in this list. * O(1) for a doubly-linked
	 * list.
	 */
	@Override
	public int size() 
	{
		return this.size;
	}

	/**
	 * * Returns true if this collection contains no elements. * O(1) for a
	 * doubly-linked list.
	 */
	@Override
	public boolean isEmpty() 
	{
		return size == 0;
	}

	/**
	 * * Removes all of the elements from this list. * O(1) for a doubly-linked
	 * list.
	 */
	@Override
	public void clear() 
	{
		first = null;
		last = null;
		this.size = 0;
	}

	/**
	 * * Returns an array containing all of the elements in this list in proper
	 * sequence (from first to last element). * O(N) for a doubly-linked list.
	 */
	@Override
	public Object[] toArray() 
	{		
		Object [] nodeArray;
		
		if(size == 0)
		{
			return nodeArray = new Object [0];
		}
		else
		{
			nodeArray = new Object [size];
		}
		
		Node<E> node = first;
		
		for(int i = 0; i < nodeArray.length;i++)
		{
			nodeArray[i] = node.item;
			
			node = node.next;
		}
		
		return nodeArray;
	}

	/**
	 * Creates an ascending Iterator for the specific DoublyLinkedList
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return new Iterator<E> ()
		{

			Node<E> lastNodeReturned;
			Node<E> nextNode = first;
			private int index;
			
			@Override
			public boolean hasNext() 
			{
				if(index < size)
				{
					return true;
				}
				else
				{
					return false;
				}
			}

			@Override
			public E next() 
			{
				if(hasNext() == false)
				{
					throw new NoSuchElementException();
				}
				lastNodeReturned = nextNode;
				nextNode = nextNode.next;
				index++;
				return lastNodeReturned.item;
			}

			@Override
			public void remove() 
			{
				if(lastNodeReturned == null)
				{
					throw new IllegalStateException();
				}
				
				Node<E> lastNext = lastNodeReturned.next;
				unlinkNode(lastNodeReturned);
				if(nextNode == lastNodeReturned)
				{
					nextNode = lastNext;
				}
				else
				{
					index--;
				}
				lastNodeReturned = null;
			}
		};
	}
	
	/**
	 * Node class to add elements to the Doubly Linked List
	 *
	 * @param <E>
	 */
    private static class Node<E> 
    {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) 
        {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Unlinks the specified node
     * @param node
     * @return returns the item being removed
     */
    private E unlinkNode (Node<E> node)
    {
    	E item = node.item;
    	
    	Node<E> next = node.next;
    	
    	Node<E> prev = node.prev;
    	
    	//this is checking to see if we are at index 0
    	if(prev == null)
    	{
    		first = next;
    	}
    	else
    	{
    		prev.next = next;
    		node.prev = null;
    	}
    	//this is checking if we are at the last index
    	if(next == null)
    	{
    		last = prev;
    	}
    	else
    	{
    		next.prev = prev;
    		node.next = null;
    	}
    	
    	node.item = null;
    	size--;
    	return item;
    }
    
    /**
     * Gets the node at the specified index
     * @param index
     * @return returns the node at the specific index
     */
    private Node<E> getNode(int index)
    {
    	Node<E> node;
    	
		if(index > size / 2)
		{
			node = last;
			
			for(int i = size - 1; i > index;i--)
			{
				node = node.prev;
			}
		}
    	else
    	{
    		node = first;
    		
    		for(int i = 0; i < index;i++)
    		{
    			node = node.next;
    		}
    	}
    	return node;
    }

}