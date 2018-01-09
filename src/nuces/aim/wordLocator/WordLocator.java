package nuces.aim.wordLocator;
/**
 * 
 */

/**
 * @author HP
 *
 */
public class WordLocator {
 int rows=100;
 int cols=100;
 char [][] array= new char[rows][cols];
 char [] word=new char [15];

public int getRows() {
	return rows;
}
public void setRows(int rows) {
	this.rows = rows;
}
public int getCols() {
	return cols;
}
public void setCols(int cols) {
	this.cols = cols;
}
public char[][] getArray() {
	return array;
}
public void setArray(char[][] array) {
	this.array = array;
}
public char[] getWord() {
	return word;
}
public void setWord(char[] word) {
	this.word = word;
}
//
public boolean findWord(char [][] array, int r, int c, char[] word, int s)
{
	int count=1;
	int [] matchingIndexRow=new int[10];
	int [] matchingIndexCol=new int[10];
	
	boolean flag=false;
	for(int i=0; i<r; i++)	//horizontal traversal of array
	{ 
		for(int j=0; j<c; j++) //vertical traversal of array
		{
			if(word[0]==array[i][j])
			{
				matchingIndexRow[0]=i; //save the location of match
				matchingIndexCol[0]=j; 
				
				System.out.println("Index of Ist match:"+i+" "+j);
				flag=true;
				break;		//break on match 
			}
	
		}
			if(flag==true)	//break outer loop as well on match
				break;
			else 
				return false;
			
 	}
					//if the first letter does not match, do not check ahead
	for(int k=1; k<s; k++)		//goes until the length of remaining word
	{
		int rowIndex=matchingIndexRow[k-1];
		int colIndex=matchingIndexCol[k-1];
		System.out.println("Index of previous match:"+rowIndex+" "+colIndex);
		
		rowIndex=matchingIndexRow[k-1];
		colIndex=matchingIndexCol[k-1];
		
		if(colIndex+1 <= c && word[k]==array[rowIndex][colIndex+1])
		{
			matchingIndexRow[k]=rowIndex;
			matchingIndexCol[k]=colIndex+1;
			System.out.println("Index of nextRight match:"+matchingIndexRow[k]+" "+ matchingIndexCol[k]);
			System.out.println("value at nextRight:"+word[k]+" "+array[rowIndex][colIndex+1]);
			System.out.println();
			count++;
			
		}
		else if (colIndex-1 >=0 && word[k]==array[rowIndex][colIndex-1])
		{
			matchingIndexRow[k]=rowIndex;
			matchingIndexCol[k]=colIndex-1;
			System.out.println("Index of nextLeft match:"+matchingIndexRow[k]+" "+matchingIndexCol[k]);
			System.out.println("value at nextLeft:"+word[k]+" "+array[rowIndex][colIndex-1]);
			System.out.println();
			count++;
			
		}
		else if (rowIndex+1<=r &&word[k]==array[rowIndex+1][colIndex])
		{
			matchingIndexRow[k]=rowIndex+1;
			matchingIndexCol[k]=colIndex;
			System.out.println("Index of nextDown match:"+matchingIndexRow[k]+" "+matchingIndexCol[k]);
			System.out.println("value at nextDown:"+word[k]+" "+array[rowIndex+1][colIndex]);
			System.out.println();
			count++;
			
		}
		
	}
	System.out.println(count+" "+word.length);
	if(count==word.length)
		return true;
	else
		return false;
}
	

}
