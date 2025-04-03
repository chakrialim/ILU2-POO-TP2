package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private Village village;
	private Chef chef;
	private Gaulois vendeur;
	private ControlVerifierIdentite cvi;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		chef = new Chef("chef",10,village);
		village.setChef(chef);
		cvi = new ControlVerifierIdentite(village);
		
	}
	
	@Test
	void testControl() {
		assertNotNull(cvi);
	}
	@Test
	void testControlVerifierIdentite() {
		vendeur = new Gaulois("Vendeur", 10);
		village.ajouterHabitant(vendeur);
		String nomVendeur = vendeur.getNom();
		assertNotNull(cvi.verifierIdentite(nomVendeur));

	}

}
