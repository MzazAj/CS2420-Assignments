package assignment03;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
/**
 * 
 * @author Brian Rodriguez and Chasen Chamberlain
 *
 * @param <E>
 */
public class BinarySearchSet<E> implements SortedSet<E>, Iterable<E>
{
	Comparator<? super E> mComparator;
	
	E[] typeArray;
	
	private int size;
	
	//Comparable
	public BinarySearchSet()
	{
		typeArray = (E[])new Object[20];
		mComparator = null;
		size = 0;
	}
	
	//Comparator
	
	public BinarySearchSet (Comparator<? super E> comparator)
	{
		this();
		mComparator = comparator;
	}
	
	/**
	 * @return The comparator used to order the elements in this set, or null if
	 *         this set uses the natural ordering of its elements (i.e., uses
	 *         Comparable).
	 */
	@Override
	public Comparator<? super E> comparator() 
	{
		if(mComparator == null)
		{
			return null;
		}
		else
		{
			return mComparator;
		}
	}

	/**
	 * @return the first (lowest, smallest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E first() throws NoSuchElementException 
	{
		if(typeArray[0] == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return typeArray[0];
		}
	}

	/**
	 * @return the last (highest, largest) element currently in this set
	 * @throws NoSuchElementException
	 *             if the set is empty
	 */
	@Override
	public E last() throws NoSuchElementException 
	{
		if(size == 0 || typeArray[size - 1] == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			return typeArray[size - 1];
		}
	}

	/**
	 * Adds the specified element to this set if it is not already present and
	 * not set to null.
	 * 
	 * @param o
	 *            -- element to be added to this set
	 * @return true if this set did not already contain the specified element
	 */
	@Override
	public boolean add(E element) 
	{	
		if (size == typeArray.length) 
		{
			typeArray = grow(typeArray);
		}

		if (this.contains(element) || element == null) 
		{
			return false;
		}
		int index = binarySearch(typeArray, element);

		if (typeArray[index] == null) 
		{
			this.size++;
			typeArray[index] = element;
			return true;
		} 
		else 
		{
			for (int i = size; i >= index; i--) 
			{
				if (i != 0) 
				{
					typeArray[i] = typeArray[i - 1];
				}
			}
			this.size++;
			typeArray[index] = element;
			return true;
		}
	}

	/**
	 * Adds all of the elements in the specified collection to this set if they
	 * are not already present and not set to null.
	 * 
	 * @param c
	 *            -- collection containing elements to be added to this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean addAll(Collection<? extends E> elements) 
	{	
		boolean changed = false;
		
		for(E object : elements)
		{
			if(changed == true)
			{
				this.add(object);
			}
			else
			{
				changed = this.add(object);
			}
		}
		if(changed)	
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Removes all of the elements from this set. The set will be empty after
	 * this call returns.
	 */
	@Override
	public void clear() 
	{
		for(int i = 0; i < size; i++)
		{
			typeArray[i] = null;	
		}
		size = 0;
	}

	/**
	 * @param o
	 *            -- element whose presence in this set is to be tested
	 * @return true if this set contains the specified element
	 */
	@Override
	public boolean contains(Object element) 
	{
		try
		{
			if(size == 0)
			{
				return false;
			}
			
			int index = binarySearch(typeArray, (E) element);
			
			if(typeArray[index] == null)
			{
				return false;
			}
			else if(myCompare(typeArray[index], (E) element) == 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(ClassCastException e)
		{
			return false;
		}
	}

	/**
	 * @param c
	 *            -- collection to be checked for containment in this set
	 * @return true if this set contains all of the elements of the specified
	 *         collection
	 */
	@Override
	public boolean containsAll(Collection<?> elements) 
	{
		for(Object object: elements)
		{
			if(this.contains(object))
			{
				
			}
			else
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * @return true if this set contains no elements
	 */
	@Override
	public boolean isEmpty() 
	{
		if(size == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return an iterator over the elements in this set, where the elements are
	 *         returned in sorted (ascending) order
	 */
	@Override
	public Iterator<E> iterator() 
	{
		return new Iterator<E> () 
		{
			int nextElementIndex; // index of next element to return
			int lastElementIndex = -1; // index of last element returned; -1 if there isnt any
			
			Object currentElement;
			
			@Override
			public boolean hasNext() 
			{				
				return nextElementIndex != size;
			}

			@Override
			public E next() 
			{
				int i = nextElementIndex;
				
				if( i >= size)
				{
					throw new NoSuchElementException();
				}
				nextElementIndex++;
				currentElement = BinarySearchSet.this.typeArray[lastElementIndex = i];
				return (E) BinarySearchSet.this.typeArray[lastElementIndex];
			}
			
			@Override
			public void remove ()
			{
				if(lastElementIndex < 0)
				{
					throw new IllegalStateException();
				}
				BinarySearchSet.this.remove(currentElement);
				nextElementIndex = lastElementIndex;
				lastElementIndex = -1;
			}
		};
	}

	/**
	 * Removes the specified element from this set if it is present.
	 * 
	 * @param o
	 *            -- object to be removed from this set, if present
	 * @return true if this set contained the specified element
	 */
	@Override
	public boolean remove(Object element) 
	{
		
		if(size == 0)
		{
			return false;
		}
		
		
		if(this.contains(element))
		{
			int index = binarySearch(typeArray, (E)element);
			for(int i = index; i < size; i++)
			{
				if(i != size -1)
				{
					typeArray[i] = typeArray[i + 1];
				}
				else
				{
					typeArray[i] = null;
				}
			}
			this.size--;
			return true;
		}
		else
		{
			return false;
		}
	}


	/**
	 * Removes from this set all of its elements that are contained in the
	 * specified collection.
	 * 
	 * @param c
	 *            -- collection containing elements to be removed from this set
	 * @return true if this set changed as a result of the call
	 */
	@Override
	public boolean removeAll(Collection<?> elements) 
	{
		boolean changed = false;
		
		for(Object object : elements)
		{
			if(changed == true)
			{
				this.remove(object);
			}
			else
			{
				changed = this.remove(object);
			}
		}
		if(changed)	
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	/**
	 * @return the number of elements in this set
	 */
	@Override
	public int size() 
	{
		return size;
	}

	/**
	 * @return an array containing all of the elements in this set, in sorted
	 *         (ascending) order.
	 */
	@Override
	public Object[] toArray() 
	{	
		Object[] array = null;
		
		if(size == 0)
		{
			return array;
		}
		else
		{
			array = new Object[size];
		}
		
		for(int i = 0; i < size;i++)
		{
			if(typeArray[i] == null)
			{
				break;
			}
			else
			{
				array[i] = typeArray[i];
			}
		}
		return array;
	}
	
	/**
	 * Compares two items, left and right. If it is using a comparator then use the ordering of the
	 * comparator. Else use the natural ordering of the ASCII scale
	 * @param left
	 * @param right
	 * @return 0 if the items are equal, 1 if the left object is greater than the object on the left.
	 * -1 if the object on the right is greater than the object on the left
	 */
	private int myCompare(E left, E right)
	{
		if(mComparator != null)
		{
			return mComparator.compare(left, right);
		}
		return ((Comparable<E>)left).compareTo(right);
	}
	
	/**
	 * Takes in an array and grows the array
	 * @param array
	 * @return
	 */
	private E[] grow (E[] array)
	{
		E[] tmpArray = (E[]) new Object[array.length*2];
		
		for(int i = 0; i < array.length;i++)
		{
			tmpArray[i] = array[i];
		}
		
		return array = tmpArray;
		
		}
	/**
	 * Takes in an array and an object and calculates the index in which the item needs
	 * be placed in.
	 * @param typeArray
	 * @param object
	 * @return the index in which the item needs to be placed into
	 */
	private int binarySearch (E[] typeArray, E object)
	{
		if(size == 0)
		{
			return 0;
		}
		
		int low = 0;
		int high = size ;
		int mid;
		
		while(low < high)
		{
			mid = (low + high) / 2;
			
			if(myCompare(typeArray[mid], object) < 0)
			{
				low = mid + 1;
			}
			else if(myCompare(typeArray[low], object) > 0)
			{
				high = mid - 1;
			}
			else
			{
				high = mid;
			}
		}
		return low;
	}

}
