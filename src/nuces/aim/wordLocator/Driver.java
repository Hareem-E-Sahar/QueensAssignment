package nuces.aim.wordLocator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] array=new char[3][4];
		
		String firstword="FCEDA";
		String secondword="SEE";
		String thirdword="ABCB";
	
				
		array[0][0]='A';
		array[0][1]='B';
		array[0][2]='C';
		array[0][3]='E';
		
		array[1][0]='S';
		array[1][1]='F';
		array[1][2]='C';
		array[1][3]='S';
		
		array[2][0]='A';
		array[2][1]='D';
		array[2][2]='E';
		array[2][3]='E';
		
		
		
		WordLocator obj = new WordLocator();
		boolean b=obj.findWord(array, firstword);
		System.out.println("Result:"+b);
		
		
	}
}
