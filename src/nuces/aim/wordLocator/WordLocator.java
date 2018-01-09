package nuces.aim.wordLocator;
/**
 * 
 */

/**
 * @author HP
 *
 */
public class WordLocator {
	
	int rows;
	 int cols;
	 Cell [] matchingIndex;
	 boolean [][] visited;
	 char [][] array;
	 char [] word;
	

	 WordLocator()
	 {	 rows=100;
	 cols=100;
	 matchingIndex=new Cell[20];
	 array=new char[rows][cols];
	 word=new char[15];
	 visited= new boolean[rows][cols];}
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
public boolean findWord(char [][] array, int row, int col, String word, int siz)
{

	int count=0;				//counts number of matches
	boolean flag=false;
	for(int i=0; i<row; i++)	//horizontal traversal of array
	{ 
		for(int j=0; j<col; j++) //vertical traversal of array
		{
			if(word.charAt(0)==array[i][j])
			{
				count++;			//inc if there is a match
				Cell temp=new Cell();
				temp.row=i;
				temp.col=j;
				matchingIndex[0]=temp;	   //save the location of first match
				
				//System.out.println("Index of Ist match:"+i+" "+j);
				
				count=remainingMatches(array, row, col,word,siz);		//count number of matches in string other than ist char
				
				System.out.println(count+" out of "+word.length()+" matches");
				if(count==word.length())
				{
					flag=true; 
					return true;
				}
				else 
				{	
					flag=false;        //intentionally not returning false here
				}
				
			}
			
		}
				
 	}
	return flag;
}
	

boolean checkAdjacentCell(char [][]array,String word, int rowIndex, int colIndex,int currLoc)
{	
	Cell temp=new Cell();
	if( word.charAt(currLoc)==array[rowIndex][colIndex] && (!visited[rowIndex][colIndex]))
	{
		//System.out.println("value at next location:"+word.charAt(currLoc)+" "+array[rowIndex][colIndex]);
		temp.row=rowIndex;
		temp.col=colIndex;
		matchingIndex[currLoc]=temp; 
		//System.out.println("Index of next match:"+matchingIndex[currLoc].row+" "+ matchingIndex[currLoc].col);
		System.out.println();
		//count++;
		visited[rowIndex][colIndex]=true;
		return true;
	}
	return false;
}


int remainingMatches(char[][]array, int row, int col, String word, int siz)//Remaining char matches
{ 
	int count=1;
	Cell temp=new Cell();
	for(int k=1; k<siz; k++)		//goes until the length of remaining word
	{
		//System.out.println("K:"+k);
	
		int rowIndex=matchingIndex[k-1].row;
		int colIndex=matchingIndex[k-1].col;
	//	System.out.println("Index of previous match:"+rowIndex+" "+colIndex); //saves match location and checks its adjacent cells
	
		if(colIndex + 1 <= col && checkAdjacentCell(array, word,rowIndex,colIndex+1,k)) //check Right cell
			count++;
		else if(colIndex - 1 >= 0 && checkAdjacentCell(array, word,rowIndex,colIndex-1,k)) //checks Left cell
			count++;
		else if(rowIndex+1 <= row && checkAdjacentCell(array, word,rowIndex+1,colIndex,k)) //checks Down cell
			count++;
		else
			return count;			//if no match then return from this fun and start anew 
	}
		return count;

	}//ends function
}
