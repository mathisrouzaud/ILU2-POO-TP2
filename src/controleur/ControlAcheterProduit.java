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

	public boolean verifierIdentite(String nomClient) {
		return controlVerifierIdentite.verifierIdentite(nomClient);
	}

	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		if (gaulois == null || gaulois.length == 0) {
			return null;
		}
		
		String[] nomsVendeurs = new String[gaulois.length];
		for (int i = 0; i < gaulois.length; i++) {
			nomsVendeurs[i] = gaulois[i].getNom();
		}
		return nomsVendeurs;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal != null) {
			return etal.acheterProduit(quantite);
		}
		return 0;
	}
}