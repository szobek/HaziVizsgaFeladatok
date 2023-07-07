package feladat05_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import felada05.EloadasokFrame;

class EloadasokFrameTest {
	@Test
	void initializeTeszt() {
		
		EloadasokFrame foAblak = new EloadasokFrame();
		
		assertTrue(foAblak.getFrmEloadasok().getTitle().equals("Színházi előadások"));

	}
}
