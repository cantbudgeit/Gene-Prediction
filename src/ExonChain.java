import java.util.ArrayList;

public class ExonChain {
	public ArrayList<Exon> chain;
	public int weight;
	public ExonChain()
	{
		this.chain = new ArrayList<Exon>();
	}
	public String toString()
	{
		String str = "Exon Intervals: \n";
		for(Exon ex: this.chain)
		{
			str = str + "( " + ex.lIndex + ", " + ex.rIndex + ") with weight: " + ex.weight + "\n";
		}
		str = str +"Total weight: " + this.weight;
		return str;
	}

}
