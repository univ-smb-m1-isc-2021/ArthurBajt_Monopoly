package monopoly;

public class Case {
    
    protected String nom;

    private Case suivante;
    
    protected Joueur proprio = null;
    
    protected Joueur joueurEnTransac = null;
    
    public Case(String name) {
    	this.nom = name;
    }

    public String getName() {
    	return nom;
    }
    
    public void setSuivant(Case c) {
    	this.suivante = c;
    }
    
    public Case avance(final int valeurDes) {
    	if(valeurDes == 0) {
    		return this;
    	}
    	return this.suivante.avance(valeurDes-1);
    }

    public void acheter() {
    }

    public void nouveauProprio(final Joueur joueur) {
    	proprio = joueur;
    }

    public void arrive(final Joueur joueur) {
    	joueur.recevoir(500);
    }
    
    protected boolean estProprio(final Joueur j) {
    	return proprio == j;
    }
    
    protected int calculLoyer() {
    	return 0;
    }

    public Joueur getProprio() {
    	return proprio;
    }
}
