package assignment01;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int data[][])
	{
		numRows = data.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0) {
			numColumns = 0;
		} else {
			numColumns = data[0].length; // d[0] is the first 1D array
		}
		this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) { 
			for(int j=0; j < numColumns; j++) {
				this.data[i][j] = data[i][j];
			}
		}
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object other)
	{
		if(!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
			return false;
		}
		Matrix matrix = (Matrix)other; // if the above was not true, we know it's safe to treat 'o' as a Matrix

		if(matrix.numColumns == this.numColumns && matrix.numRows == this.numRows)
		{
			for(int i = 0;i < matrix.numRows; i++)
			{
				for(int j = 0; j < matrix.numColumns; j++)
				{
					if(matrix.data[i][j] != this.data[i][j])
					{
						return false;
					}
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{

		String result = "";
		
		for(int i = 0;i < this.numRows;i++)
		{
			for(int j = 0;j < this.numColumns;j++)
			{
				if(this.numColumns - 1 == j)
				{
					result = result + this.data[i][j] + " \n";
				}
				else
				{
					result = result + this.data[i][j] + " ";
				}
			}
		}
		
		return result; // placeholder
	}
	
	public Matrix times(Matrix matrix)
	{	
		int result[][];
				
		if(this.numColumns == matrix.numRows)
		{
			result = new int [this.numRows][matrix.numColumns];
			
			for(int i = 0; i < this.numRows;i++)
			{
				for(int j = 0; j < matrix.numColumns;j++)
				{
					for(int g = 0; g < this.numColumns;g++)
					{
						result[i][j] += this.data[i][g] * matrix.data[g][j];
					}
				}
			}
			return new Matrix(result);
		}
		else
		{
			return null;
		}
	}
	
	public Matrix plus(Matrix matrix)
	{
		int result[][] = new int [matrix.numRows][matrix.numColumns];
		
		if(this.numColumns == matrix.numColumns && this.numRows == matrix.numRows)
		{
			for(int i = 0; i < matrix.numRows;i++)
			{
				for(int j = 0; j < matrix.numColumns;j++)
				{
					result[i][j] = this.data[i][j] + matrix.data[i][j];
				}
			}
			return new Matrix(result);
		}
		return null;
	}
}
