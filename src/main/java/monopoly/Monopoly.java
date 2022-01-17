package monopoly;

public class Monopoly {
    public Plateau plato = null;
    
    public Monopoly() {
    	creerPartie();
    }

    public void creerPartie() {
    	if(plato == null) {
        	plato = new Plateau();
    	}
    }

    public void ajouteJoueur(String name) {
    	plato.creerJoueur(name);
    }

    public void jouePartie() {

    	while(!plato.isFini()) {
    		plato.nouveauTour();
    	}
    }

    public static void main(String[] args) {
    	Monopoly monop = new Monopoly();
    	monop.ajouteJoueur("Léo");
    	monop.ajouteJoueur("Arthur");
    	monop.ajouteJoueur("Djamel");
    	monop.ajouteJoueur("Loris");
    	monop.jouePartie();
    }
}
