package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		StringBuilder sb = new StringBuilder();
		if(!nomVendeurConnu){
			sb.append("Je suis désolée ");
			sb.append(nomVendeur);
			sb.append("mais il faut être un habitant de notre village pour commercer ici");
			System.out.println(sb.toString());
		}
		else {
			sb.append("Désolée ");
			sb.append(nomVendeur);
			sb.append("je vais regarder si je peux vous trouver un étal.");
			System.out.println(sb.toString());
			
			boolean etalDisponible = controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				StringBuilder reponseDisponible = new StringBuilder();
				reponseDisponible.append("Désolée");
				reponseDisponible.append(nomVendeur);
				reponseDisponible.append("je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(reponseDisponible.toString());
			}
			else {
				installerVendeur(nomVendeur);
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder installation = new StringBuilder();
		installation.append("C'est parfait, il me reste un étal pour vous!");
		installation.append("\nIl me faudrait quelques renseignements:");
		
		StringBuilder questionProduit = new StringBuilder();
		String produit = Clavier.entrerChaine(questionProduit.toString());
		
		StringBuilder questionnbProduit = new StringBuilder();
		String produit = Clavier.entrerChaine(questionnbProduit.toString());
		
		
	}
}
