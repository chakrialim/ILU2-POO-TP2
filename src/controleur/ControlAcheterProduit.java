package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String verifierProduit(String produit) {
		Gaulois[] vendeurs = village.rechercherVendeursProduit(produit);
		if(vendeurs==null) {
			return("Désolé, personne ne vend ce produit au marché.");
		}
		return null;
	}
	
	public int verifierDisponibilite(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
 		return etal.getQuantite();
	}
	
	public void acheterProduit(String nomVendeur, int nbAchat) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		etal.acheterProduit(nbAchat);
	}
}
