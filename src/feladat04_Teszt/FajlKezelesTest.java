package feladat04_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import feladat04.FajlKezeles;
import feladat04.Rendeles;

class FajlKezelesTest {
	
	@Test
	void ellenorizTeszt() {
		
		FajlKezeles fajlObj = new FajlKezeles();
		String[] tesztCsvSor = {"S0008","toll","100","4000","1"};
		
		assertTrue(fajlObj.ellenoriz(tesztCsvSor));
		
	}
	

	@Test
	void createCsvTest() {
		FajlKezeles fajlObj = new FajlKezeles();
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		rendelesek.add(new Rendeles("pswz3","toll",10,200,false));
		rendelesek.add(new Rendeles("pswz4","kapocs",30,2,true));
		
		assertTrue(fajlObj.writeCsvFile(rendelesek));
		
	}
	
	
	
	
	
}
