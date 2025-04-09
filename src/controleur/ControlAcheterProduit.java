package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	@SuppressWarnings("null")
	public String[] verifierProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		String[] nomVendeurs = null;
		for (int i = 0; i < vendeurs.length; i++) {
			nomVendeurs[i] = vendeurs[i].getNom();

		}
		return nomVendeurs;
	}

	public int verifierDisponibilite(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.getQuantite();
	}

	public int acheterProduit(String nomVendeur, int nbAchat) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		System.out.println(etal.getQuantite());
		return etal.acheterProduit(nbAchat);

	}
}
