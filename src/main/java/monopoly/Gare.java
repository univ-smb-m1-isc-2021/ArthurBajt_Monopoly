package monopoly;

public class Gare extends Service {

    private int prix;

    public Gare(String nom, int prix) {
    	super(nom);
    	this.prix = prix;
    }

    public void acheter() {
    	if(joueurEnTransac.paiement(prix)) {
        	etat = "Possédée";
        	proprio = joueurEnTransac;
    	}
    }

    @Override
    public void arrive(final Joueur joueur) {
    	joueurEnTransac = joueur;
    	System.out.println(joueur.getNom() + " arrive sur la gare \"" + this.nom + "\"");
    	if(etat.equals("Achetable")) {
    		joueur.propositionAchatCase(prix);
    	}
    	else
    	{
    		if(!estProprio(joueur)) {
    			int prixLoyer = calculLoyer();
    			if(joueur.paiementForce(prixLoyer)) {
        			getProprio().recevoir(prixLoyer);
    			} else {
    				getProprio().recevoir(joueur.getSolde()+prixLoyer); //Si il a pas pu payer en entier il a donc perdu
    			}
    		}
    	}
    }

    @Override
	protected int calculLoyer() {
    	int nbGares = getProprio().getNbGares();
		return (prix*nbGares)/2;
	}
}
