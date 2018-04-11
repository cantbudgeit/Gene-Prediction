import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this will be the main class of the program

public class Main {
	
	public static void main(String[] args)
	{
		File file = new File("gene.txt");
		int index = 0;		
		char char1 = 'z';
		char char2 = 'z';
		char char3 = 'z';
				
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				char3 = char2;
				char2 = char1;
				char1 = scan.next().charAt(index);
				index++;
				String temp = ""+char3+char2+char1;
				if(temp.equals("ATG"))
				{
					ORF orf = new ORF(index);
				}
			}
			scan.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
			
		
	}

}
