package feladat03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FoprogramAutoSzerviz {

	public static List<SzervizMunka> works = new ArrayList<SzervizMunka>();
	public static Map<String, Integer> worksMap = new HashMap<String, Integer>();
	public static int oradij = 8000;
	public static void main(String[] args) {

		
		createWorks();
	}

	public static void createWorks() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Visz fel?");
			String ujmunka = sc.nextLine();
			
			while (!ujmunka.equals("")) {
				System.out.print("munka neve: ");
				String wname = sc.nextLine();
				System.out.print("munkaóra: ");
				try {
					int whour = Integer.parseInt(sc.nextLine());
					works.add(new SzervizMunka(wname, whour));
				}catch(NumberFormatException e2) {}
				System.out.println("Újabb?");
				ujmunka=sc.nextLine();
			}
		} catch (Exception e) {
			System.out.println("Hiba");
		}
		int windex = searchLongerWorks();
		System.out.println("A leghosszabb : "+works.get(windex).getSzervizTevekenyseg()+ " ("+works.get(windex).getMunkaOra()+" óra)");
		generateMap();
	}

	public static int searchLongerWorks() {
		int windex=0;
		for(int i=1;i<works.size();i++) {
			if(works.get(i).getMunkaOra()>works.get(windex).getMunkaOra()) {
				windex=i;
			}
		}
		return windex;
		
	}
	private static void generateMap() {
		for(SzervizMunka work:works) {
			worksMap.put(work.getSzervizTevekenyseg(), work.arKepzes(oradij));
		}
		for(Entry<String, Integer> work: worksMap.entrySet()) {
			System.out.println(work);
		}
	}
}
