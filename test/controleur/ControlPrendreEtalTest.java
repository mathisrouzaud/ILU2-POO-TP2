package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	void setUp(){
		System.out.println("Initialisation...");
		village = new Village("le vllage des irréductibles", 10, 5);
		Chef chef = new Chef("Asterix", 5, village);
		village.setChef(chef);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		Village village2 = new Village("le vllage des irréductibles", 10, 0);
		ControlPrendreEtal controlPrendreEtal2 = new ControlPrendreEtal(controlVerifierIdentite, village2);
		assertFalse(controlPrendreEtal2.resteEtals());
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertFalse(controlPrendreEtal.verifierIdentite("INCONNU"));
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotEquals(controlPrendreEtal.prendreEtal("Asterix", "produit", 1),-1);
	}

}
