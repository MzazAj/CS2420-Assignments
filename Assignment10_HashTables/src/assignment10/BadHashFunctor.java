package assignment10;

/**
 * Really Bad Hash Functor
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class BadHashFunctor implements HashFunctor 
{
	@Override
	public int hash(String item) 
	{
		int hashCode = 0;
		
		for(int i = 0; i < item.length();i++)
		{
			hashCode += item.charAt(i);
		}
		return hashCode;
	}
}
