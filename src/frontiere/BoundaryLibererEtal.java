package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		// 1. Appeler isVendeur pour le bloc 'alt'
				boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
				
				// 2. Bloc 'alt'
				if (!vendeurReconnu) {
					// 3. Cas où le vendeur n'est pas reconnu (le bloc [vendeurReconnu] du diagramme)
					System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
				} else {
					// 4. Cas où le vendeur EST reconnu (le bloc [else] du diagramme)
					String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
					
					// 5. Récupérer la condition du bloc 'opt'
					// La description dit : etalOccupe = donneesEtal[0]
					// La Javadoc dit que c'est un booléen
					boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
					
					// 6. Bloc 'opt' [etalOccupe]
					if (etalOccupe) {
						// 7. Récupérer les données selon les descriptions
						String produit = donneesEtal[2];
						String quantiteInitial = donneesEtal[3];
						String quantiteVendu = donneesEtal[4];
						
						// 8. Afficher les messages de fin
						System.out.println("Vous avez vendu " + quantiteVendu + " " + produit + " sur "
								+ quantiteInitial + " " + produit + ".");
						
						System.out.println("En revoir " + nomVendeur + ", passez une bonne journée.");
					}
				}
	}

}
