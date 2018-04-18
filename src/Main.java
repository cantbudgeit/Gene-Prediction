

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//this will be the main class of the program
public class Main {
	
	
	public static String DNA = "ATCGCGATGCAGATCCTCAGCTTACCCGTATTGGGTTTTTTCCCGTACCTCACAGTCCGTCAGTTTGTCCGTTAG";
	public static void main(String[] args)
	{
		
		ArrayList<ORF> ORFlist = new ArrayList<ORF>();
		findAllORFs(ORFlist, DNA);
		findAllExons(ORFlist);
		findBestExonChains(ORFlist);
		print(ORFlist);
		
	}
	
	public static void findAllORFs(ArrayList<ORF> ORFlist, String DNA)
	{
		//find start and stop codons in DNA and record those positions in ORF objects and add to list
		String startCodon = "ATG";
		Pattern startCodonPattern = Pattern.compile(startCodon);
		String endCodons = "TAA|TAG|TGA";
		Pattern endCodonsPattern = Pattern.compile(endCodons);
		
		Matcher startMatcher = startCodonPattern.matcher(DNA);
		Matcher endMatcher = endCodonsPattern.matcher(DNA);
		
		while (startMatcher.find())
		{
			int startIndex = startMatcher.start();
			ORF newORF = new ORF(startIndex);
			endMatcher.find();
			int endIndex = endMatcher.start();
			newORF.rIndex = endIndex+3;

			ORFlist.add(newORF);
		}
	}
	public static void findAllExons(ArrayList<ORF> ORFlist)
	{
		//find all exons in each ORF and append them to that ORF's list
		//weigh all exons.
		//Flanked by ag & gt, must have full triplet codons inside the dinucleotieds
		String startDiNuc = "AG";
		Pattern startDiNucPattern = Pattern.compile(startDiNuc);
		String endDiNuc = "GT";
		Pattern endDiNucPattern = Pattern.compile(endDiNuc);
		
		for( ORF orf : ORFlist)
		{
			String orfString = DNA.substring(orf.lIndex, orf.rIndex);
			Matcher startExonMatcher = startDiNucPattern.matcher(orfString);
			Matcher endExonMatcher = endDiNucPattern.matcher(orfString);
			while(startExonMatcher.find())
			{
				int startIndex = startExonMatcher.start();
				boolean endFound = false;
				while(endFound == false && endExonMatcher.find())
				{
					int endIndex = endExonMatcher.start();
					if((endIndex-1 - startIndex+1)%3 ==0)
					{
						Exon newExon = new Exon(startIndex, endIndex+2, DNA);
						orf.exonList.add(newExon);
						endFound = true;
					}
				}
			}
		}
	}
	public static void findBestExonChains(ArrayList<ORF> ORFlist)
	{
		//find the best weighted non-overlapping exon chains
		for(ORF orf: ORFlist)
		{
			int[] s = new int[orf.rIndex - orf.lIndex];
			for(int i = 1; i <s.length; i++ )
			{
				for(Exon ex: orf.exonList)
				{
					if(ex.rIndex == i)
					{
						s[i]=Math.max((s[ex.lIndex] + ex.weight), s[i-1]);
						break;
					}
					else s[i] = s[i-1];
				}
			}
			for(int i = s.length - 1; i>0; i--)
			{
				if(s[i-1] < s[i])
				{
					for(Exon ex: orf.exonList)
					{
						if(ex.rIndex == i)
						{
							orf.chain.chain.add(ex);
							if(orf.chain.chain.size()==1)
							{
								orf.chain.weight = s[i];
							}
							i = ex.lIndex;
							break;
						}
					}
				}
			}
						
		}
	}
	public static void print(ArrayList<ORF> ORFlist)
	{
		for(ORF orf: ORFlist)
		{
			System.out.println(orf.toString());
		}
	}

}

