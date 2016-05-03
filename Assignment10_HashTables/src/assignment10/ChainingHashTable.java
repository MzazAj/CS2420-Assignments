package assignment10;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Creates a Hash Table utilizing separate chaining
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class ChainingHashTable implements Set<String>
{
    private LinkedList<String>[] storage;
    private int size;
    private int capacity;
    private int collisionCount;
    private HashFunctor functor;
    
	/**
	 * Creates the Chaining Hash Table
	 * @param capacity
	 * @param functor
	 */
	 @SuppressWarnings("unchecked")
	public ChainingHashTable(int capacity, HashFunctor functor)
	 {
		 if(!isPrime(capacity))
		 {
			 int nextPrime = nextPrime(capacity);
			 storage = (LinkedList<String>[]) new LinkedList[(nextPrime)];
			 this.capacity = nextPrime;
			 for(int i = 0; i < nextPrime;i++)
			 {
				 storage[i] = new LinkedList<String>();
			 }
		 }
		 else
		 {
			 storage = (LinkedList<String>[]) new LinkedList[capacity];
			 this.capacity = capacity;
			 for(int i = 0; i < capacity;i++)
			 {
				 storage[i] = new LinkedList<String>();
			 }
		 }
	     this.size = 0;
	     this.functor = functor;
	 }

	/**
	 * Ensures that this set contains the specified item.
	 * 
	 * @param item
	 *            - the item whose presence is ensured in this set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if the input item was actually inserted); otherwise, returns
	 *         false
	 */
	@Override
	public boolean add(String item) 
	{
		//get hash code
		int hashCode = (functor.hash(item) & 0x7fffffff) % capacity;
		
		//if the linked list at the index is empty just add the item
		if(storage[hashCode].isEmpty())
		{
			storage[hashCode].add(item);
			size++;
			return true;
		}
		//else if the item is contained in the linked list return false
		else
		{
			collisionCount++;
			if(storage[hashCode].contains(item))
			{
				return false;
			}
			//else just add the item to the linked list
			else
			{
				storage[hashCode].add(item);
				size++;
				return true;
			}
		}
	}

	/**
	 * Ensures that this set contains all items in the specified collection.
	 * 
	 * @param items
	 *            - the collection of items whose presence is ensured in this
	 *            set
	 * @return true if this set changed as a result of this method call (that
	 *         is, if any item in the input collection was actually inserted);
	 *         otherwise, returns false
	 */
	@Override
	public boolean addAll(Collection<? extends String> items) 
	{
		boolean hasChanged = false;
		
		for(String item : items)
		{
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
	@SuppressWarnings("unchecked")
	@Override
	public void clear() 
	{
		storage = (LinkedList<String>[]) new LinkedList[capacity];
		for(int i = 0; i < capacity;i++)
		{
			storage[i] = new LinkedList<String>();
		}
		size = 0;
		collisionCount = 0;
	}

	/**
	 * Determines if there is an item in this set that is equal to the specified
	 * item.
	 * 
	 * @param item
	 *            - the item sought in this set
	 * @return true if there is an item in this set that is equal to the input
	 *         item; otherwise, returns false
	 */
	@Override
	public boolean contains(String item) 
	{
		//gets hash code
		int hashCode = (functor.hash(item) & 0x7fffffff) % capacity;
		//gets the index of the linked list and sees if the item is contained in that list
		return 	storage[hashCode].contains(item);
	}

	/**
	 * Determines if for each item in the specified collection, there is an item
	 * in this set that is equal to it.
	 * 
	 * @param items
	 *            - the collection of items sought in this set
	 * @return true if for each item in the specified collection, there is an
	 *         item in this set that is equal to it; otherwise, returns false
	 */
	@Override
	public boolean containsAll(Collection<? extends String> items) 
	{
		for(String item : items)
		{
			if(!this.contains(item))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if this set contains no items.
	 */
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() 
	{
		return size;
	}
	
	/**
	 * Finds the next prime number after the given number
	 * @param number
	 * @return
	 */
	private int nextPrime(int n) 
	{
	    boolean isPrime = false;

	    int start = 2; // start at 2 and omit your if statement

	    while (!isPrime(n)) 
	    {
	        n += 1;
	        // redefine max boundary here
	        int m = (int) Math.ceil(Math.sqrt(n));

	        isPrime = true;
	        // increment i by 1, not 2
	        for (int i = start; i <= m; i++) 
	        {
	            if (n % i == 0) {
	                isPrime = false;
	                break;
	            } 
	        }
	    }
	    return n;
	}
	
	/**
	 * Checks to see if the number is prime
	 * @param num
	 * @return
	 */
	private boolean isPrime(int num) 
	{
		//if num is less than two it is not prime
        if (num < 2) 
        {
        	return false;
       	}
        //if it is equal to 2 then it is prime
        if (num == 2) 
       	{
        	return true;
        }
        //if the number is even then it is not prime
        if (num % 2 == 0)
        {
        	return false;
       	}
        //looks to see if the number is prime by modding num by i
        for (int i = 3; i * i <= num; i += 2)
        {
        	if (num % i == 0)
        	{
        		return false;        	
        	}
        }
        return true;
	}
	/**
	 * Gets the number of collisions
	 * @return
	 */
	public int getCollisions()
	{
		return collisionCount;
	}

}
