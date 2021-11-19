package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;

import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		boolean status;
		try {
			
		PrintWriter skriver = new PrintWriter(mappe + filnavn);
		skriver.print(samling.toString());
		skriver.close();
		
		status = true;
		
		} catch(Exception e) {
			status = false;
		}
		return status;
	}
}