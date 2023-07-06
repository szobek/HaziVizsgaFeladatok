package feladat04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PapirBoltFoprogram {

	public static void main(String[] args) throws IOException {
		
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		FajlKezeles fajlObj = new FajlKezeles();
		fajlObj.beolvas(rendelesek, "SzallitoiRendelesek.csv");
		
		System.out.println("Fájl beolvasva. Hibás tételek száma: "+fajlObj.beolvas(rendelesek,"SzallitoiRendelesek.csv"));

		
		// d feladat...
		rendelesek.add(new Rendeles("pswz3","toll",10,200,false));
		rendelesek.add(new Rendeles("pswz4","kapocs",30,2,true));
		
		for(Rendeles rendeles:rendelesek) {
			System.out.println(rendeles);
		}
		fajlObj.writeCsvFile(rendelesek);
	}

}
