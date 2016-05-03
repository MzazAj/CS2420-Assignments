package assignment10;

/**
 * Good Hash Functor
 * 
 * @author Brian Rodriguez and Michael Kim
 *
 */
public class GoodHashFunctor implements HashFunctor
{
	@Override
	public int hash(String item) 
	{
		int half = 0;
		
		int otherHalf = 0;
		
		for(int i = 0; i < item.length();i++)
		{
			if(i >= item.length() / 2)
			{
				otherHalf = 31 * otherHalf + item.charAt(i);
			}
			else
			{
				half = 31 * half + item.charAt(i);
			}
		}
		return otherHalf + half;
	}
}
