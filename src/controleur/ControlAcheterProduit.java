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
	
	public String[] rechercherVendeursProduit(String produit) {
			Gaulois[] vendeursGaulois = village.rechercherVendeursProduit(produit);
			
			if(vendeursGaulois == null || vendeursGaulois.length == 0) {
				return null;
			}
			
			String[] nomsVendeurs = new String[vendeursGaulois.length];
			for(int i=0;i<vendeursGaulois.length;i++) {
				nomsVendeurs[i] = vendeursGaulois[i].getNom();
			}
			return nomsVendeurs;
	}
	
	public Etal getEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public int acheterProduit(String nomVendeur, int quantiteDesiree) {
		Etal etalVendeur = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etalVendeur == null) {
			return 0; 
		}
		return etalVendeur.acheterProduit(quantiteDesiree);
	}
	
	
}
