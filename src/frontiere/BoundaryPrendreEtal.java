package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		
		// 2. Premier bloc 'alt' : Vérifier si le vendeur est un habitant
		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			
			// 3. Appel à resteEtals via le contrôleur
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			
			// 4. Deuxième bloc 'alt' : Vérifier s'il y a un étal libre
			if (!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			} else {
				// 5. Délégation à la méthode privée pour l'installation
				installerVendeur(nomVendeur);
			}
		}
	}
	

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

		
		// 7. Appel à prendreEtal sur le contrôleur
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		// 8. Bloc 'opt' : Confirmation de l'installation
		// Le diagramme vérifie [numeroEtal != -1], mais 0 est un numéro d'étal valide.
		// On ajuste souvent pour l'affichage humain (étal 1 au lieu de 0).
		// Le diagramme dit d'afficher 'numeroEtal', donc nous le suivons.
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal);
		}
	}
}
	

