package assignment10;

import java.util.Collection;

/**
 * Creates a Hash Table that utilizes quadratic probing
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class QuadProbeHashTable implements Set<String> 
{
	private String[] storage;
	private HashFunctor functor;
	private int size;
	private int capacity;
	private int collisionCount;
	private static final double LOADFACTOR = 0.5;

	
	/**
	 * Constructs a hash table of the given capacity that uses the hashing
	 * function specified by the given functor.
	 */
	public QuadProbeHashTable(int capacity, HashFunctor functor)
	{
		if (!isPrime(capacity)) 
		{
			int nextPrime = nextPrime(capacity);
			storage = new String[nextPrime];
			this.capacity = nextPrime;
		} 
		else 
		{
			storage = new String[capacity];
			this.capacity = capacity;
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
		//Rehash if size is bigger than capacity times load factor
		if (size >= (capacity * LOADFACTOR)) 
		{
			rehashStorage();
		}
		
		//get hashcode
		int hashCode = (functor.hash(item) % capacity);
		//check to see if it is negative if yes then make positive
		if(Math.signum(hashCode) == -1.0f)
		{
			hashCode = -hashCode;
		}
		//if the index at storage is not null then check to see if it is equal to the item
		//else do a quadratic probe
		if(storage[hashCode] != null)
		{
			if(storage[hashCode].equals(item))
			{
				return false;
			}
			else
			{
				int index = quadraticProbe(item);
				
				if(index == -1 || index == 0)
				{
					return false;
				}
				else
				{
					storage[index] = item;
					size++;
					return true;
				}
			}
		}
		//if it is null just add it
		else
		{
			size++;
			storage[hashCode] = item;
			return true;
		}
	}

	/**
	 * Performs quadratic probe
	 * @param item
	 * @return
	 */
	private int quadraticProbe(String item) 
	{
		//get hash function and set probe to 1
		int probe = 1;
		
		int index = functor.hash(item) % capacity;
		//check to see if it is negative if yes then make positive
		if(Math.signum(index) == -1.0f)
		{
			index = -index;
		}
		//while the index at storage is not null perform quadratic probing
		while(storage[index] != null)
		{
			collisionCount++;
			
			index = (index + (probe * probe)) % capacity;
			
			if(Math.signum(index) == -1.0f)
			{
				index = -index;
			}

			if(storage[index] == null)
			{
				return index;
			}
			else if(storage[index].equals(item))
			{
				return -1;
			}
			probe++;
		}
		return 0;
	}
	/**
	 * Rehashes the storage
	 */
	private void rehashStorage() 
	{		
		//Finds nxt prime number
		this.capacity = nextPrime(capacity * 2); 
		
		int hashCode;
		//creates new storage
		String[] newStorage = new String[capacity];
		
		//for each item in the storage finds a new hash code and
		//adds them into the new storage
		for(String item : storage)
		{
			if(item == null)
			{
				
			}
			else
			{
				hashCode = functor.hash(item) % capacity;
				
				if(Math.signum(hashCode) == -1.0f)
				{
					hashCode = -hashCode;
				}
				
				if(newStorage[hashCode] == null)
				{
					newStorage[hashCode] = item;
				}
				else
				{
					if(newStorage[hashCode] != null)
					{
						int probe = 1;
						
						int index = functor.hash(item) % capacity;
						
						if(Math.signum(index) == -1.0f)
						{
							index = -index;
						}
						
						while(newStorage[index] != null)
						{
							index = (index + (probe * probe)) % capacity; 
							
							if(Math.signum(index) == -1.0f)
							{
								index = -index;
							}
	
							if(newStorage[index] == null)
							{
								newStorage[index] = item;
								break;
							}
							probe++;
						}					
					}
				}
			}
		}

		this.storage = newStorage;
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
	@Override
	public void clear() 
	{
		storage = new String[capacity];
		this.size = 0;
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
		int hashCode = (functor.hash(item)  % capacity);
		//checks to see if it is negative if yes then make it positive
		if(Math.signum(hashCode) == -1.0f)
		{
			hashCode = -hashCode;
		}
		//if index is null it doesn't contain it
		if(storage[hashCode] == null)
		{
			return false;
		}
		//else if it equals the item then return true
		else if(storage[hashCode].equals(item))
		{
			return true;
		}
		//else use quadratic probing to find the item
		else
		{	
			int index = quadraticProbe(item);
			if(index == -1)
			{
				return true;
			}
			else
			{
				return false;
			}
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
	 */

	@Override
	public boolean containsAll(Collection<? extends String> items) 
	{
		for(String item: items)
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
		return this.size == 0;
	}

	/**
	 * Returns the number of items in this set.
	 */
	@Override
	public int size() 
	{
		return this.size;
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
