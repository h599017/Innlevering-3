package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Bilde;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		int pos = -1;

		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i] != null) {
				if (innleggtabell[i].erLik(innlegg)) {
					pos = i;
				}
			}
		}

		return pos;
	}

	public boolean finnes(Innlegg innlegg) {
		return finnInnlegg(innlegg) != -1;
	}

	public boolean ledigPlass() {
		return innleggtabell[innleggtabell.length - 1] == null;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (ledigPlass() && !finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String retur = nesteledig + "\n";
		for (int i = 0; i < getAntall(); i++) {
			retur += innleggtabell[i].toString();
		}
		return retur;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] ph = new Innlegg[innleggtabell.length * 2];
		for (int i = 0; i < innleggtabell.length; i++) {
			ph[i] = innleggtabell[i];
		}
		innleggtabell = ph;
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (finnes(innlegg)) {
			return false;
		} else if (!leggTil(innlegg)) {
			if (!ledigPlass()) {
				utvid();
			}
			return leggTil(innlegg);
		} else {
			return true;
		}
	}

	public boolean slett(Innlegg innlegg) {
		boolean retur = false;
		if (finnes(innlegg)) {
			innleggtabell[finnInnlegg(innlegg)] = null;
			nesteledig--;
			retur = true;
		}
		return retur;
	}

	public int[] search(String keyword) {
		int j = 0;
		int k = 0;
		for (int i = 0; i < nesteledig; i++) {
			if(innleggtabell[i].toString().contains(keyword)) {
				j++;
			}
		}
		int[] liste = new int[j];
		for (int l = 0; l < nesteledig; l++) {
			if(innleggtabell[l].toString().contains(keyword)) {
				liste[k] = innleggtabell[l].getId();
				k++;
			}
		}
		return liste;
	}
}