package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	
	private Village village;
	private Gaulois vendeur;
	private ControlTrouverEtalVendeur ctev;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		vendeur = new Gaulois("Vendeur", 10);
		Chef iii = new Chef("chef",10, village);
		village.setChef(iii);
		village.ajouterHabitant(vendeur);
		village.installerVendeur(vendeur, "fleurs", 10);
		ctev = new ControlTrouverEtalVendeur(village);

	}
	
	@Test
	void testControl() {
		assertNotNull(ctev);
	}
//	
//	@Test
//	void testTrouverEtalVendeur1() {
//		Etal etal = village.rechercherEtal(vendeur);
//		assertNotNull(etal);
//		
//	}
//	
//	@Test
//	void testTrouverEtalVendeur2() {
//		Gaulois dude = village.trouverHabitant(vendeur.getNom());
//		Etal etal = village.rechercherEtal(dude);
//		assertNotNull(etal);
//		
//	}

	@Test
	void testTrouverEtalVendeur() {
		Etal etal = ctev.trouverEtalVendeur(vendeur.getNom());
		assertNotNull(etal);
		
	}

}
