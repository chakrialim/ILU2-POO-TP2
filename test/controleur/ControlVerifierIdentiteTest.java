package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private Village village;
	private Gaulois vendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@Test
	void testControlVerifierIdentite() {
		village = new Village("NomVillage", 1, 1);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testVerifierIdentite() {
		village = new Village("NomVillage", 10, 1);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		vendeur = new Gaulois("Amber", 13);
		village.ajouterHabitant(vendeur);
		assertTrue(controlVerifierIdentite.verifierIdentite("Amber"));
		
	}

}
