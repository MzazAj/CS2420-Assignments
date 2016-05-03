package assignment10;

/**
 * Mediocre Hash Functor
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class MediocreHashFunctor implements HashFunctor
{
	@Override
	public int hash(String item) 
	{
		int hashCode = 0;
		
		for (int i = 0; i <  item.length() ; i++) 
		{
		    hashCode = 17 * hashCode + item.charAt(i);
		}
		return hashCode;
	}
}
