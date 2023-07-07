package feladat02;

public class Virag extends Noveny {

	private String viragszin;
	
	
	public Virag(String azonosito, String megnevezes, int felfedezesEve,String viragszin) {
		super(azonosito, megnevezes, felfedezesEve);
		this.viragszin=viragszin;
	}


	@Override
	public String toString() {
		return "Azonosító:" + super.getAzonosito() + ", megnevezés:" + super.getMegnevezes() + ", bekerüles éve:" + super.getBekerulesEve()+", szín: " + viragszin;  
	}
	
	

}
