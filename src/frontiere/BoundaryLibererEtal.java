package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		StringBuilder reponse = new StringBuilder();
		if(!vendeurReconnu) {
			reponse.append("Mais vous n'êtes pas inscirt sur notre marché aujourd'hui");
			System.out.println(reponse.toString());
		}
		else {
			String[] donneesEtal =  controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.valueOf(donneesEtal[0]);
			if(etalOccupe) {
				int quantiteVendu = Integer.parseInt(donneesEtal[4]);
				int quantiteInitial = Integer.parseInt(donneesEtal[3]);
				String produit = donneesEtal[2];
				reponse.append("Vous avez vendu ");
				reponse.append(quantiteVendu);
				reponse.append(" sur ");
				reponse.append(quantiteInitial);
				reponse.append(" ");
				reponse.append(produit);
				reponse.append(".");
				reponse.append("\n");
				reponse.append("Au revoir ");
				reponse.append(nomVendeur);
				reponse.append(", passez une bonne journée");
				System.out.println(reponse);
			}
		}
	}

}
