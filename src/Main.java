import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this will be the main class of the program

public class Main {
	
	public static void main(String[] args)
	{
		File file = new File("gene.txt");
		
		String gene = "";
		try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine())
			{
				gene = scan.next();
			}
			scan.close();
		}
		
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
			
		
	}

}
