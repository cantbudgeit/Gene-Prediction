import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

//this will be the main class of the program
public class Main {
	
	
	public static String DNA = "aatgcaagaatgaactccttcctggaataccccatacttagcagtggcgatgctcagcccgagcctacccctcggaccataggattacaactttccagtcagcgccaacagttgcggcggcgacgaccgcttcctagtgggcaggggggttcgccccaccaccaccaccaccaccaccatcgccacccccagccggctactccgggaacctgggggtgtcctactcccactcaagttgtggtccaagctaaacttcagtgcgccttacagcccctacgcgttaaatcaggaagcagacga";
	public static void main(String[] args)
	{
		
		ArrayList<ORF> ORFlist = new ArrayList<ORF>();
		findAllORFs(ORFlist, DNA);
		findAllExons(ORFlist);
		findBestExonChains(ORFlist);
		print();
		
	}
	public static int[] matchPattern()
	{
		Pattern
		return
	}
	public static void findAllORFs(ArrayList<ORF> ORFlist, String DNA)
	{
		//find start and stop codons in DNA and record those positions in ORF objects and add to list
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

}
