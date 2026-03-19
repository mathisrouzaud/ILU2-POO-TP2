package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder bienvenueVillageois = new StringBuilder();
					bienvenueVillageois.append("Bienvenue villageois ");
					bienvenueVillageois.append(nomVisiteur);
					System.out.println(bienvenueVillageois.toString());
					
					StringBuilder questionForce = new StringBuilder();
					questionForce.append("Quelle est votre force?");
					int force = Clavier.entrerEntier(questionForce.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder bienvenueDruide = new StringBuilder();
		bienvenueDruide.append("Bienvenue druide ");
		bienvenueDruide.append(nomVisiteur);
		System.out.println(bienvenueDruide.toString());
		
		StringBuilder questionForceDruide = new StringBuilder();
		questionForceDruide.append("Quelle est votre force?");
		int forceDruide = Clavier.entrerEntier(questionForceDruide.toString());
		
		StringBuilder questionPotionMax = new StringBuilder();
		StringBuilder questionPotionMin = new StringBuilder();
		
		questionPotionMin.append("Quelle est la force de potion la plus faible que vous produisez?");
		questionPotionMax.append("Quelle est la force de potion la plus forte que vous produisez?");
		
		int effetPotionMin = Clavier.entrerEntier(questionPotionMin.toString());
		int effetPotionMax = Clavier.entrerEntier(questionPotionMax.toString());
		
		while(effetPotionMax < effetPotionMin) {
			System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			effetPotionMin = Clavier.entrerEntier(questionPotionMin.toString());
			effetPotionMax = Clavier.entrerEntier(questionPotionMax.toString());
			
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
