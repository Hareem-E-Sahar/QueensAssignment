package nuces.aim.wordLocator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] array=new char[10][10];
		char[] word=new char[4];
		//word[]='A';
		word[0]='S';
		word[1]='E';
		word[2]='E';
		//word[3]='B';
		//word[4]='D';
		
		array[0][0]='A';
		array[0][1]='B';
		array[0][2]='C';
		array[0][3]='E';
		
		array[1][0]='S';
		array[1][1]='F';
		array[1][2]='A';
		array[1][3]='S';
		
		array[2][0]='A';
		array[2][1]='D';
		array[2][2]='E';
		array[2][3]='E';
		
		
		
		WordLocator obj = new WordLocator();
		System.out.print("Word:");
		for(int i=0;i<4;i++)
			System.out.println(word[i]);
		boolean b=obj.findWord(array, 4, 4, word, 5);
		System.out.println("Result:"+b);
		
		
	}

}
