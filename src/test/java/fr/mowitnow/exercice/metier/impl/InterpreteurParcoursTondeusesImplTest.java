package fr.mowitnow.exercice.metier.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import fr.mowitnow.exercice.bo.Grille;
import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;
import fr.mowitnow.exercice.enumeration.PointCardinal;
import fr.mowitnow.exercice.metier.InterpreteurParcoursTondeuses;

public class InterpreteurParcoursTondeusesImplTest {
	
	private InterpreteurParcoursTondeuses interpreteurParcoursTondeuses = new InterpreteurParcoursTondeusesImpl();
	
	@Test
	public void testInterpreterParcoursTondeuses_ParcoursValide() {
		InformationsEntree informationsEntree = new InformationsEntree();
		informationsEntree.setGrille(new Grille(5, 5));
		Tondeuse tondeuse = new Tondeuse();
		tondeuse.setOrientation(PointCardinal.N);
		tondeuse.setPositionX(1);
		tondeuse.setPositionY(2);
		tondeuse.setInstruction("GAGAGAGAA");
		informationsEntree.ajouterTondeuse(tondeuse);
		
		Tondeuse tondeuseExpected = new Tondeuse();
		tondeuseExpected.setOrientation(PointCardinal.N);
		tondeuseExpected.setPositionX(1);
		tondeuseExpected.setPositionY(3);
		tondeuseExpected.setInstruction("GAGAGAGAA");
		
		this.interpreteurParcoursTondeuses.interpreterParcoursTondeuses(informationsEntree);
		
		assertThat(informationsEntree.getListeTondeuses().get(0)).usingRecursiveComparison().
			isEqualTo(tondeuseExpected);
	}
}
