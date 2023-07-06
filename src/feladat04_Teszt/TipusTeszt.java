package feladat04_Teszt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import feladat04.Rendeles;

public class TipusTeszt {

	@Test
	void tipusTeszt() {
		
		Rendeles obj=new Rendeles("pswz3","toll",10,200,false);
		assertTrue(obj instanceof Rendeles);
		
	}
	
}
