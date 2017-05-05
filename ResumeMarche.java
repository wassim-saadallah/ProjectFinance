
public class ResumeMarche {
	public long titresEchangees;
	public long totalVolume;
	public long capitalBoursiere;
	public int hausses;
	public int basses;
	public int actives;
	public ResumeMarche() {
		super();
		// TODO Auto-generated constructor stub
		this.actives = 0;
		this.basses = 0;
		this.hausses = 0;
		this.capitalBoursiere = 0;
		this.totalVolume = 0;
		this.titresEchangees = 0;
	}
	@Override
	public String toString() {
		return "ResumeMarche [titresEchangees=" + titresEchangees + ", totalVolume=" + totalVolume
				+ ", capitalBoursiere=" + capitalBoursiere + ", hausses=" + hausses + ", basses=" + basses
				+ ", actives=" + actives + "]";
	}
	
	
	
}
