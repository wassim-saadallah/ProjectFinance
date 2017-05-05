
public class TableRow {
	public String Nom;
	public float Ouverture;
	public float Haut;
	public float Bas;
	public float VolTitres;
	public float VolDt;
	public float Dernier;
	public float Variation;
	public TableRow(String nom, float ouverture, float haut, float bas, float volTitres, float volDt, float dernier,
			float variation) {
		super();
		Nom = nom;
		Ouverture = ouverture;
		Haut = haut;
		Bas = bas;
		VolTitres = volTitres;
		VolDt = volDt;
		Dernier = dernier;
		Variation = variation;
	}
	@Override
	public String toString() {
		return "TableRow [Nom=" + Nom + ", Ouverture=" + Ouverture + ", Haut=" + Haut + ", Bas=" + Bas + ", VolTitres="
				+ VolTitres + ", VolDt=" + VolDt + ", Dernier=" + Dernier + ", Variation=" + Variation + "]";
	}
	
}
