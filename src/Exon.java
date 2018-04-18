public class Exon {
	public int lIndex;
	public int rIndex;
	public int weight;
	public String exonString;
	public Exon(int l, int r, String dna)
	{
		this.lIndex = l;
		this.rIndex = r;
		this.exonString = dna.substring(l, r);
		this.weight = (int) exonString.chars().filter(ch -> ch =='C').count();
	}
}
