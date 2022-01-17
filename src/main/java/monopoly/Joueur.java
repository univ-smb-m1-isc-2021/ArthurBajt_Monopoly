package monopoly;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Joueur {

    private String nom;

    private int solde; //1500

    private EnumPion pion = null;

    private Case estSur;

    private List<Case> casesPossedees = new ArrayList<Case> ();
    
    public Joueur(String name, Case depart) {
    	nom = name;
    	solde = 1500;
    	estSur = depart;
    }

    public void joueTour() {
    	int valeurDes = lanceDes(2);
    	sePlaceSur(estSur.avance(valeurDes));
    	estSur.arrive(this);
    	actionsPossibles();
    	String input = "n";
    	@SuppressWarnings("resource")
    	Scanner scan = new Scanner(System.in);
    	do {
    		System.out.println(nom + ", voulez vous arreter votre tour ? o/n");
	    	input = scan.nextLine();
    	} while(!input.equalsIgnoreCase("o"));
    }

    public int lanceDes(final int nbDes) {
    	int somme = 0;
    	for(int i = 0; i<nbDes;i++) {
    		somme += ThreadLocalRandom.current().nextInt(1, 6 + 1);
    	}
    	return somme;
    }

    private void sePlaceSur(final Case newCase) {
    	estSur = newCase;
    }
    
    public boolean paiement(final int somme) {
    	if(solde<0) {
        	System.out.println(nom + " n'a pas les moyens.");
    		return false;
    	}
    	System.out.println(nom + " a payé " + ((Integer)somme).toString() + "$");
    	solde -= somme;
    	System.out.println(nom + " a encore " + ((Integer)getSolde()).toString() + "$");
    	return true;
    }
    
    public boolean paiementForce(final int somme) {
    	System.out.println(nom + " a payé " + ((Integer)somme).toString() + "$");
    	solde -= somme;
    	if(solde<0) {
        	System.out.println(nom + " a perdu la partie.");
    		return false;
    	}
    	System.out.println(nom + " a encore " + ((Integer)getSolde()).toString() + "$");
    	return true;
    }

    public void ajouteCase(final Case caseToAdd) {
    	casesPossedees.add(caseToAdd);
    }

    public void propositionAchatCase(final int prix) {
    	System.out.println(nom + ", voulez vous acheter cette case (" + Integer.toString(prix) + "$) ? o/n");
    	@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
    	String input = scan.nextLine();
    	if(input.equalsIgnoreCase("o")) {
    		estSur.acheter();
    		ajouteCase(estSur);
    	}
    }

    public void propositionBien(final int prix) {
    	System.out.println(nom + ", voulez vous acheter un bien sur cette case (" + Integer.toString(prix) + "$) ? o/n");
    	@SuppressWarnings("resource")
    	Scanner scan = new Scanner(System.in);
    	String input = scan.nextLine();
    	if(input.equalsIgnoreCase("o")) {
    		((Rue)estSur).construire();
    	}
    }

    public void recevoir(final int valeur) {
    	System.out.println(nom + " a reçu " + ((Integer)valeur).toString() + "$");
    	solde += valeur;
    	System.out.println(nom + " a désormais " + ((Integer)getSolde()).toString() + "$");
    }

    public int getNbServiceDesEaux() {
    	int nbSDE = 0;
        for(int i = 0; i < casesPossedees.size(); i++) {
        	if(casesPossedees.get(i) instanceof ServiceDesEaux) {
        		nbSDE++;
        	}
        }
        return nbSDE;
    }

    public int getNbGares() {
    	int nbGares = 0;
        for(int i = 0; i < casesPossedees.size(); i++) {
        	if(casesPossedees.get(i) instanceof Gare) {
        		nbGares++;
        	}
        }
        return nbGares;
    }

    public void actionsPossibles() {
    	for(int i = 0; i<casesPossedees.size(); i++) {
    		if(casesPossedees.get(i) instanceof Rue) {
    			((Rue)casesPossedees.get(i)).construire();
    		}
    	}
    }

    public void construire(final Rue rue) {
    	rue.construire();
    }
    
    public int getSolde() {
    	return solde;
    }
    
    public String getNom() {
    	return nom;
    }
    
    public EnumPion getPion() {
    	return pion;
    }
    
    public Case getCase() {
    	return estSur;
    }
}
