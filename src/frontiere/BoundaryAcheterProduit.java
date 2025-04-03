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
			System.out.println("Je suis desolee " + nomAcheteur
					+ " mais il faut un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter?");
			String texte = controlAcheterProduit.verifierProduit(produit);
			//TODO refaire fonction 
			if (texte != null) {
				System.out.println(texte);
			} else {
				traiterAchat(nomAcheteur, vendeurs, produit);
			}

		}
	}

	public void traiterAchat(String nomAcheteur, Gaulois[] vendeurs, String produit) {
		System.out.println("Chez quel commercant voulez-vous acheter des fleurs?");
		StringBuilder question = new StringBuilder();
		for (int i = 0; i < vendeurs.length; i++) {
			question.append((i + 1) + " - " + vendeurs[i].getNom() + "\n");
		}
		int nbVendeur = Clavier.entrerEntier(question.toString());
		String nomVendeur = vendeurs[nbVendeur - 1].getNom();
		System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + nomVendeur);
		int nbAchat = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter?");
		int quantiteDispo = controlAcheterProduit.verifierDisponibilite(nomVendeur);
		if (quantiteDispo == 0) {
			System.out.println(
					nomAcheteur + " veut acheter " + nbAchat + " " + produit + ", malheureusement il n'yen a plus !");
		} else {
			if (quantiteDispo < nbAchat) {
				System.out.println(nomAcheteur + " veut acheter " + nbAchat + " " + produit + ", malheureusement "
						+ nomVendeur + " n'en a plus que " + quantiteDispo + ". " + nomAcheteur
						+ " achete tout le stock de " + nomVendeur + ".");
				controlAcheterProduit.acheterProduit(nomVendeur, quantiteDispo);
			} else {
				System.out.println(nomAcheteur + " achete " + nbAchat + " " + produit + " a " + nomVendeur + ".");
				controlAcheterProduit.acheterProduit(nomVendeur, nbAchat);
			}

		}
	}
}
