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
	void maxTeszt() {
		
		FoprogramAutoSzerviz.works.add(new SzervizMunka("Olajcsre", 2));
		FoprogramAutoSzerviz.works.add(new SzervizMunka("gyertyacsere", 12));
		int wi = FoprogramAutoSzerviz.searchLongerWorks();
		assertEquals(1,wi);
		
	}

}
