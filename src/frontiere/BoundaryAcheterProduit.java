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
			String[] nomVendeurs = controlAcheterProduit.verifierProduit(produit);
			if (nomVendeurs == null) {
				System.out.println("Désolé, personne ne vend pas ce produit au marché.");
			} else {
				traiterAchat(nomAcheteur, nomVendeurs, produit);
			}

		}
	}

	public void traiterAchat(String nomAcheteur, String[] nomVendeurs, String produit) {
		System.out.println("Chez quel commercant voulez-vous acheter des fleurs?");
		StringBuilder question = new StringBuilder();
		for (int i = 0; i < nomVendeurs.length; i++) {
			question.append((i + 1) + " - " + nomVendeurs[i] + "\n");
		}
		int nbVendeur = Clavier.entrerEntier(question.toString());
		String nomVendeur = nomVendeurs[nbVendeur - 1];
		System.out.println(nomAcheteur + " se deplace jusqu'a l'etal du vendeur " + nomVendeur);
		int nbAchat = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter?");
		int nbAchete = controlAcheterProduit.acheterProduit(nomVendeur, nbAchat);
		if (nbAchete == 0) {
			System.out.println(
					nomAcheteur + " veut acheter " + nbAchat + " " + produit + ", malheureusement il n'yen a plus !");
		} else {
			if (nbAchete == nbAchat) {
				System.out.println(nomAcheteur + " veut acheter " + nbAchat + " " + produit + ", malheureusement "
						+ nomVendeur + " n'en a plus que " + nbAchete + ". " + nomAcheteur + " achete tout le stock de "
						+ nomVendeur + ".");
				controlAcheterProduit.acheterProduit(nomVendeur, nbAchete);
			} else {
				System.out.println(nomAcheteur + " achete " + nbAchat + " " + produit + " a " + nomVendeur + ".");
				controlAcheterProduit.acheterProduit(nomVendeur, nbAchat);
			}

		}
	}
}
