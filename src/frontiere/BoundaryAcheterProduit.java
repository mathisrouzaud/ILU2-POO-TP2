package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// 1. Vérifier l'identité de l'acheteur 
				if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
					System.out.println("Je suis désolée " + nomAcheteur 
							+ " mais il faut être un habitant de notre village pour commercer ici.");
					return;
				}

				// 2. Demander le produit 
				String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");

				// 3. Rechercher les vendeurs de ce produit 
				String[] nomsVendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);

				// 4. Scénario: Produit non trouvé 
				if (nomsVendeurs == null) {
					System.out.println("Désolé, personne ne vend ce produit au marché.");
					return;
				}

				// 5. Afficher les vendeurs et demander le choix 
				StringBuilder question = new StringBuilder();
				question.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < nomsVendeurs.length; i++) {
					question.append((i + 1) + " - " + nomsVendeurs[i] + "\n");
				}
				
				int choixVendeur = 0;
				// Boucle de validation pour s'assurer que l'entrée est valide
				do {
					choixVendeur = Clavier.entrerEntier(question.toString());
				} while (choixVendeur < 1 || choixVendeur > nomsVendeurs.length);

				String nomVendeurChoisi = nomsVendeurs[choixVendeur - 1];

				// 6. Se déplacer à l'étal 
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeurChoisi + ".");
				System.out.println("Bonjour " + nomAcheteur + ".");

				// 7. Demander la quantité 
				int quantiteDesiree = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");

				// 8. Récupérer le stock AVANT l'achat (pour les messages de la frontière)
				Etal etalVendeur = controlAcheterProduit.getEtalVendeur(nomVendeurChoisi);
				int quantiteEnStock = etalVendeur.getQuantite();

				// 9. Scénario: Stock initial est 0 
				if (quantiteEnStock == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteDesiree + " " + produit
							+ ", malheureusement il n'y en a plus !");
					return;
				}

				// 10. Procéder à l'achat via le contrôleur
				int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeurChoisi, quantiteDesiree);

				// 11. Gérer les scénarios de sortie
				if (quantiteAchetee == quantiteDesiree) {
					// Scénario: Achat réussi 
					System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit 
							+ " à " + nomVendeurChoisi + ".");
				} else {
					// Scénario: Achat partiel (stock insuffisant) 
					// (quantiteAchetee sera la quantite reelle prise, donc quantiteEnStock)
					System.out.println(nomAcheteur + " veut acheter " + quantiteDesiree + " " + produit
							+ ", malheureusement " + nomVendeurChoisi + " n'en a plus que " + quantiteAchetee + ". "
							+ nomAcheteur + " achète tout le stock de " + nomVendeurChoisi + ".");
				}
	}
}
