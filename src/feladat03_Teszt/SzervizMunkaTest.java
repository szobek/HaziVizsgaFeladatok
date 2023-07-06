package feladat03_Teszt;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import feladat03.FoprogramAutoSzerviz;
import feladat03.SzervizMunka;

class SzervizMunkaTest {

	@Test
	void arKepzesTeszt() {
		
		int oradij = 8000;
		SzervizMunka tesztObj = new SzervizMunka("olajcsere", 2);
		int elvartErtek = 16000;
		
		assertEquals(elvartErtek,tesztObj.arKepzes(oradij));
		
	}
	@Test
	void mapTeszt() {
		Map<String, Integer> w = FoprogramAutoSzerviz.worksMap;
		w.put("work" , 1);
		String elvart = "java.lang.Integer";
		assertEquals(elvart,w.get("work").getClass());
		
	}

}
