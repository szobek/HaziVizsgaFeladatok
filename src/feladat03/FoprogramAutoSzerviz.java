package feladat03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FoprogramAutoSzerviz {

	static List<SzervizMunka> works = new ArrayList<SzervizMunka>();
	public static Map<String, Integer> worksMap = new HashMap<String, Integer>();
	
	public static void main(String[] args) {

		int oradij = 8000;
		createWorks(oradij);
	}

	private static void createWorks(int oradij) {
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
		}
		searchLongerWorks(oradij);
	}

	private static void searchLongerWorks(int oradij) {
		int windex=0;
		for(int i=0;i<works.size();i++) {
			if(works.get(i).getMunkaOra()>works.get(windex).getMunkaOra()) {
				windex=i;
			}
		}
		System.out.println("A leghosszabb : "+works.get(windex).getSzervizTevekenyseg()+ " ("+works.get(windex).getMunkaOra()+" óra)");
		generateMap(oradij);
	}
	private static void generateMap(int oradij) {
		for(SzervizMunka work:works) {
			worksMap.put(work.getSzervizTevekenyseg(), work.arKepzes(oradij));
		}
		for(Entry<String, Integer> work: worksMap.entrySet()) {
			System.out.println(work);
		}
	}
}