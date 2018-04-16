package exonChaining;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//this will be the main class of the program
public class Main {
	
	
	public static String DNA = "aatgcaagaatgaactccttcctggaataccccatacttagcagtggcgatgctcagcccgagcctacccctcggaccataggattacaactttccagtcagcgccaacagttgcggcggcgacgaccgcttcctagtgggcaggggggttcgccccaccaccaccaccaccaccaccatcgccacccccagccggctactccgggaacctgggggtgtcctactcccactcaagttgtggtccaagctaaacttcagtgcgccttacagcccctacgcgttaaatcaggaagcagacga";
	public static void main(String[] args)
	{
		
		ArrayList<ORF> ORFlist = new ArrayList<ORF>();
		
		findAllORFs(ORFlist, DNA);
		//findAllExons(ORFlist);
		//findBestExonChains(ORFlist);
		System.out.println(ORFlist.toString());
		
	}
	
	public static void findAllORFs(ArrayList<ORF> ORFlist, String DNA)
	{
		//find start and stop codons in DNA and record those positions in ORF objects and add to list
		String startCodon = "atg";
		Pattern startCodonPattern = Pattern.compile(startCodon);
		String endCodons = "taa|tag|tga";
		Pattern endCodonsPattern = Pattern.compile(endCodons);
		
		Matcher startMatcher = startCodonPattern.matcher(DNA);
		Matcher endMatcher = endCodonsPattern.matcher(DNA);
		
		while (startMatcher.find())
		{
			int startIndex = startMatcher.start();
			ORF newORF = new ORF(startIndex);
			//boolean endFound = false;
			//while (endFound == false && endMatcher.find())
			//{
				int endIndex = endMatcher.start();
				//if((endIndex-startIndex)%3 == 0)
				//{
					newORF.rIndex = endIndex+3;
					//add to list of end indexies
					//endFound = true;
				//}
			//}
			ORFlist.add(newORF);
		}
	}
	public static void findAllExons(ArrayList<ORF> ORFlist)
	{
		//find all exons in each ORF and append them to that ORF's list
		//weigh all exons.
		//Flanked by ag & gt, must have full triplet codons inside the dinucleotieds
	}
	public static void findBestExonChains(ArrayList<ORF> ORFlist)
	{
		//find the best weighted non-overlapping exon chains
	}
	public static void print()
	{
		
	}

}

