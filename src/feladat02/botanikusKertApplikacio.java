package feladat02;

public class botanikusKertApplikacio {
	public static Noveny[] novenyek = new Noveny[4];

	public static void main(String[] args) {

		novenyek[0] = new Noveny("001", "Fikusz", 2000);
		novenyek[1] = new Noveny("002", "Leander", 1911);
		novenyek[2] = new Virag("003", "Büdöske", 1877, "sárga");
		novenyek[3] = new Noveny("004", "petúnia", 1962);
		writeAllData();
	}

	private static void writeAllData() {
		for (Noveny noveny : novenyek) {
			System.out.println(noveny+" "+noveny.hanyHonapjaLatogathato() + " hónapja látogatható. "+noveny.getClass());
		}

	}

}
