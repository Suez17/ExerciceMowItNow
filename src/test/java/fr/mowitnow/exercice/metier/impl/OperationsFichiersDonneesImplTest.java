package fr.mowitnow.exercice.metier.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

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
import fr.mowitnow.exercice.exception.ExceptionFichierEntree;
import fr.mowitnow.exercice.metier.OperationsFichiersDonnees;

public class OperationsFichiersDonneesImplTest {
	
	@Rule
    public TemporaryFolder dossierTemp = new TemporaryFolder();
	
	private OperationsFichiersDonnees operationsFichiersDonnees = new OperationsFichiersDonneesImpl();
	
	@Test
	public void testLireFichierEntree_FichierValide() throws IOException {
		File fichierTemp = this.dossierTemp.newFile("fichierTest.txt");
		BufferedWriter writer = Files.newBufferedWriter(fichierTemp.toPath());
		writer.append("5 5\n");
		writer.append("1 2 N\n");
		writer.append("GAGAGAGAA\n");
		writer.append("3 3 E\n");
		writer.append("AADAADADDA\n");
		writer.flush();
		
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
	
	@Test(expected = NullPointerException.class)
	public void testLireFichierEntree_FichierNull() throws IOException {

		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree(null);
	}
	
	@Test(expected = IOException.class)
	public void testLireFichierEntree_CheminFichierInexistant() throws IOException {

		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree("cheminInexistant");
	}
	
	@Test(expected = ExceptionFichierEntree.class)
	public void testLireFichierEntree_FichierInfosGrilleIncorrects() throws IOException {
		File fichierTemp = this.dossierTemp.newFile("fichierTest.txt");
		BufferedWriter writer = Files.newBufferedWriter(fichierTemp.toPath());
		writer.append("5\n");
		writer.append("1 2 N\n");
		writer.append("GAGAGAGAA\n");
		writer.append("3 3 E\n");
		writer.append("AADAADADDA\n");
		writer.flush();
		
		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree(fichierTemp.getPath());
		
		writer.close();
	}
	
	@Test(expected = ExceptionFichierEntree.class)
	public void testLireFichierEntree_FichierInfosTondeuseIncorrects() throws IOException {
		File fichierTemp = this.dossierTemp.newFile("fichierTest.txt");
		BufferedWriter writer = Files.newBufferedWriter(fichierTemp.toPath());
		writer.append("5 5\n");
		writer.append("1  N\n");
		writer.append("GAGAGAGAA\n");
		writer.append("3 3 E\n");
		writer.append("AADAADADDA\n");
		writer.flush();
		
		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree(fichierTemp.getPath());
		
		writer.close();
	}
	
	@Test(expected = ExceptionFichierEntree.class)
	public void testLireFichierEntree_FichierPointCardinalIncorrect() throws IOException {
		File fichierTemp = this.dossierTemp.newFile("fichierTest.txt");
		BufferedWriter writer = Files.newBufferedWriter(fichierTemp.toPath());
		writer.append("5 5\n");
		writer.append("1 2 Z\n");
		writer.append("GAGAGAGAA\n");
		writer.append("3 3 E\n");
		writer.append("AADAADADDA\n");
		writer.flush();
		
		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree(fichierTemp.getPath());
		
		writer.close();
	}
	
	@Test(expected = ExceptionFichierEntree.class)
	public void testLireFichierEntree_FichierInformationsManquantes() throws IOException {
		File fichierTemp = this.dossierTemp.newFile("fichierTest.txt");
		BufferedWriter writer = Files.newBufferedWriter(fichierTemp.toPath());
		writer.append("5 5\n");
		writer.append("1 2 N\n");
		writer.append("3 3 E\n");
		writer.append("AADAADADDA\n");
		writer.flush();
		
		InformationsEntree informationsEntreeActual = 
				this.operationsFichiersDonnees.lireFichierEntree(fichierTemp.getPath());
		
		writer.close();
	}
}
