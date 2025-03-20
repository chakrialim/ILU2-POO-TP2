package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean isVillageois = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!isVillageois) {
			System.out.println("Je suis desolee " +nomAcheteur+" mais il faut un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter?");
			controlAcheterProduit.verifierProduit(produit);
			
		}
	}
}
