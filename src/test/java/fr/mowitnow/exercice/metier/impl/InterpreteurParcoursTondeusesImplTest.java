package fr.mowitnow.exercice.metier.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

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
		Tondeuse tondeuse1 = new Tondeuse();
		tondeuse1.setOrientation(PointCardinal.N);
		tondeuse1.setPositionX(1);
		tondeuse1.setPositionY(2);
		tondeuse1.setInstruction("GAGAGAGAA");
		
		Tondeuse tondeuse2 = new Tondeuse();
		tondeuse2.setOrientation(PointCardinal.E);
		tondeuse2.setPositionX(3);
		tondeuse2.setPositionY(3);
		tondeuse2.setInstruction("AADAADADDA");
		
		informationsEntree.ajouterTondeuse(tondeuse1);
		informationsEntree.ajouterTondeuse(tondeuse2);
		
		Tondeuse tondeuseExpected1 = new Tondeuse();
		tondeuseExpected1.setOrientation(PointCardinal.N);
		tondeuseExpected1.setPositionX(1);
		tondeuseExpected1.setPositionY(3);
		tondeuseExpected1.setInstruction("GAGAGAGAA");
		
		Tondeuse tondeuseExpected2 = new Tondeuse();
		tondeuseExpected2.setOrientation(PointCardinal.E);
		tondeuseExpected2.setPositionX(5);
		tondeuseExpected2.setPositionY(1);
		tondeuseExpected2.setInstruction("AADAADADDA");
		
		List<Tondeuse> listeTondeusesExpected = new ArrayList<>();
		listeTondeusesExpected.add(tondeuseExpected1);
		listeTondeusesExpected.add(tondeuseExpected2);
		
		this.interpreteurParcoursTondeuses.interpreterParcoursTondeuses(informationsEntree);
		
		assertThat(informationsEntree.getListeTondeuses()).usingRecursiveComparison().
			isEqualTo(listeTondeusesExpected);
	}
}
