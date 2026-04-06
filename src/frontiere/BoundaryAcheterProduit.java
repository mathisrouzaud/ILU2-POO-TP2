package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}

		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);

		if (vendeurs == null || vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}

		StringBuilder question = new StringBuilder();
		question.append("Chez quel commerçant voulez-vous acheter des ").append(produit).append(" ?\n");
		for (int i = 0; i < vendeurs.length; i++) {
			question.append(i + 1);
			question.append(" - ");
			question.append(vendeurs[i]);
			question.append("\n");
		}
		
		int choixVendeur = Clavier.entrerEntier(question.toString());
		while (choixVendeur < 1 || choixVendeur > vendeurs.length) {
			System.out.println("Vous devez entrer un chiffre entre 1 et " + vendeurs.length);
			choixVendeur = Clavier.entrerEntier(question.toString());
		}
		
		String nomVendeur = vendeurs[choixVendeur - 1];
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
		System.out.println("Bonjour " + nomAcheteur);
		
		int quantiteAcheter = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantiteAcheter);

		if (quantiteAchetee == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit + ", malheureusement il n'y en a plus !");
		} else if (quantiteAchetee < quantiteAcheter) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit + ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee + ".");
			System.out.println(nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur + ".");
		}
	}
}