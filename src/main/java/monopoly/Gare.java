package monopoly;

public class Gare extends Service {

    public Gare(String nom, int prix) {
    	super(nom,prix,"Gare");
    }

    @Override
    public void arrive(final Joueur joueur) {
    	System.out.println(joueur.getNom() + " arrive sur la gare \"" + this.nom + "\"");
    	joueurEnTransac = joueur;
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
