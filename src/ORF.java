import java.util.*;

public class ORF {
	public int lIndex;
	public int rIndex;
	public ArrayList<Exon> exonList;
	public ExonChain chain;
	
	public ORF(int l)
	{
		this.lIndex = l;
		this.exonList = new ArrayList<Exon>();
		this.chain = new ExonChain();
	}
	
	public String toString()
	{
		String str = "This Open reading frame's interval was: ( " + this.lIndex + ", " + this.rIndex + ")\n";
		str = str + "----Exon Chain---\n" + this.chain.toString();
		return str;
	}
}
