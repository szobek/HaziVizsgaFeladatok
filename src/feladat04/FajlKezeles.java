package feladat04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class FajlKezeles {
	
	public int beolvas(List<Rendeles> rendelesek, String fajlnev) throws IOException {
		
		int hibasTetelekSzama = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		while (br.ready()) {
			
			String csvSor[] = br.readLine().split(";");
			
			if (ellenoriz(csvSor)) {
				
				rendelesek.add(new Rendeles(csvSor));
				
			}
			else {
				
				hibasTetelekSzama++;
				
			}
			
		}
		
		br.close();
		return hibasTetelekSzama;
		
	}

	
	public boolean ellenoriz(String[] csvSor) {
		
		return csvSor.length == 5 && csvSor[0].length() >= 5;
		
	}
	public boolean writeCsvFile(List<Rendeles> rendelesek) {
String csvName = "UjSzallitoiRendelesek.csv";
		 try {
			 BufferedWriter writer = new BufferedWriter(new FileWriter(csvName));
			 writer.append("szallitoiAzonosito;megnevezes;menniseg;osszertek;surgos \n");
			 for(Rendeles rendeles:rendelesek) {
					writer.append(rendeles.getSzallitoiAzonosito()+ ";"+rendeles.getMegnevezes()+ ";"+rendeles.getMennyiseg()
					+ ";"+rendeles.getOsszertek()+ ";"+rendeles.isSurgos()+"\n");
				}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 File file = new File(csvName);
		 return file.exists();
		
	}


}
