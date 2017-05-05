import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;  
public class AnagramsSeq{  
    public static void main( String[] args ) throws IOException{ 
    			ArrayList<TableRow> result = getData();
    			ArrayList<TableRow> PalmaresHaut = new ArrayList<>();
    			ArrayList<TableRow> PalmaresBas = new ArrayList<>();
    			getPalmares(result,PalmaresHaut,PalmaresBas);
    			
    			ResumeMarche res = new ResumeMarche();
    			res.actives = result.size();
    			for (TableRow tr : result){
    				if(tr.Variation <0) res.basses++;
    				if(tr.Variation >=0) res.hausses++;
    				res.capitalBoursiere+= tr.VolDt;
    				res.titresEchangees+=tr.VolTitres;
    			}
    			System.out.println(res);
    			
    }

	private static void getPalmares(ArrayList<TableRow> result,ArrayList<TableRow> PalmaresHaut, ArrayList<TableRow> PalmaresBas) {
		Collections.sort(result, new Comparator<TableRow>() {

			@Override
			public int compare(TableRow o1, TableRow o2) {
				return Float.compare(o1.Variation, o2.Variation);
			}
		});
		PalmaresBas = new ArrayList(result.subList(0, 5));
		PalmaresHaut = new ArrayList<TableRow>(result.subList(result.size()-6, result.size()));
		System.out.println(PalmaresHaut.get(0));
	}

	private static ArrayList<TableRow> getData() throws IOException {
		ArrayList<TableRow> table = new ArrayList<>();
		Document doc = Jsoup.connect("http://www.ilboursa.com/marches/aaz.aspx").get();  
		Elements rows = doc.select("tbody.alri tr");
		for(Element e : rows){
			TableRow row = new TableRow(e.child(0).text(),
					Float.parseFloat(e.child(1).text()) ,
					Float.parseFloat(e.child(2).text()),
					Float.parseFloat(e.child(3).text()),
					Float.parseFloat(e.child(4).text()),
					Float.parseFloat(e.child(5).text()),
					Float.parseFloat(e.child(6).text()),
					Float.parseFloat(e.child(7).text().substring(0, e.child(7).text().length()-1))
					);
			table.add(row);
		}
		return table;
	}  
}  