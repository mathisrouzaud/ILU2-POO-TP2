package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard");
		}else {
			StringBuilder reponse = new StringBuilder();
			reponse.append(nomAcheteur);
			reponse.append(", vous trouverez au marché:");
			for(int i=0, j = 0; i < infosMarche.length; i++) {
				reponse.append("- ");
				reponse.append(infosMarche[j]);
				j++;
				reponse.append(" qui vend ");
				reponse.append(infosMarche[j]);
				j++;
				reponse.append(" ");
				reponse.append(infosMarche[j]);
			}
		}
	}
}
