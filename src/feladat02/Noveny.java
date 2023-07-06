package feladat02;

import java.time.LocalDate;

public class Noveny {

	private String azonosito;
	private String megnevezes;
	private int bekerulesEve;

	public Noveny(String azonosito, String megnevezes, int felfedezesEve) {

		this.azonosito = azonosito;
		this.megnevezes = megnevezes;
		this.bekerulesEve = felfedezesEve;

	}

	public String getAzonosito() {
		return azonosito;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public int getBekerulesEve() {
		return bekerulesEve;
	}

	@Override
	public String toString() {
		return "Azonosító:" + azonosito + ", megnevezés:" + megnevezes + ", bekerüles éve:" + bekerulesEve ;
	}

	public int hanyHonapjaLatogathato() {

		return (LocalDate.now().getYear() - bekerulesEve) * 12;

	}

}
