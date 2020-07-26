package fr.mowitnow.exercice.metier.impl;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import fr.mowitnow.exercice.bo.Grille;
import fr.mowitnow.exercice.bo.InformationsEntree;
import fr.mowitnow.exercice.bo.Tondeuse;
import fr.mowitnow.exercice.enumeration.PointCardinal;
import fr.mowitnow.exercice.metier.OperationsFichiersDonnees;

public class OperationsFichiersDonneesImplTest {
	
	@Rule
    public TemporaryFolder dossierTemp = new TemporaryFolder();
	
	private OperationsFichiersDonnees operationsFichiersDonnees = new OperationsFichiersDonneesImpl();
	
	@Test
	public void testLireFichierEntree_FichierValide() throws IOException {
		File fichierTemp = this.dossierTemp.newFile("fichierTest.txt");
		BufferedWriter writer = Files.newBufferedWriter(fichierTemp.toPath());
		writer.append("5 5");
		writer.append("1 2 N");
		writer.append("GAGAGAGAA");
		writer.append("3 3 E");
		writer.append("AADAADADDA");
		
		InformationsEntree informationsEntreeExpected = new InformationsEntree();
		informationsEntreeExpected.setGrille(new Grille(5, 5));
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
		
		informationsEntreeExpected.ajouterTondeuse(tondeuse1);
		informationsEntreeExpected.ajouterTondeuse(tondeuse2);
		
		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree(fichierTemp.getPath());
		
		assertThat(informationsEntreeActual).usingRecursiveComparison().
			isEqualTo(informationsEntreeExpected);
		
		writer.close();
	}
}
