package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		try {

			Scanner leser = new Scanner(mappe + filnavn);
			if (leser.hasNextLine()) {

				String linje1 = leser.nextLine();

				Blogg input = new Blogg(Integer.parseInt(linje1));

				while (leser.hasNextLine()) {
					String linje = leser.nextLine();
					if (linje.equals(TEKST)) {
						input.leggTil(new Tekst(Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine(),
								Integer.parseInt(leser.nextLine()), leser.nextLine()));

					} else if (linje.equals(BILDE)) {
						input.leggTil(new Bilde(Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine(),
								Integer.parseInt(leser.nextLine()), leser.nextLine(), leser.nextLine()));

					}
					leser.close();
					return input;

				}
			} else {
				leser.close();
				return null;
			}
			
			leser.close();
			Blogg fail = new Blogg(0);
			return fail;

		} catch (Exception e) {
			System.out.print("Du gjorde feil din fitte, kod på nytt!");
			return null;
		}

	}
}
