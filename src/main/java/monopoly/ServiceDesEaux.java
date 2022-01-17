package monopoly;

public class ServiceDesEaux extends Service {
    private int prix;

    public ServiceDesEaux(String nom, int prix) {
    	super(nom);
    	this.prix = prix;
    }

    @Override
    public void acheter() {
    	if(joueurEnTransac.paiement(prix)) {
        	etat = "Possédée";
        	proprio = joueurEnTransac;
    	}
    }

    @Override
    public void arrive(final Joueur joueur) {
    	joueurEnTransac = joueur;
    	System.out.println(joueur.getNom() + " arrive sur le service des eaux \"" + this.nom + "\"");
    	if(etat.equals("Achetable")) {
    		joueur.propositionAchatCase(prix);
    	}
    	else
    	{
    		if(!estProprio(joueur)) {
    			int prixLoyer = calculLoyer()*joueur.lanceDes(1);
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
    	int nbGares = getProprio().getNbServiceDesEaux();
    	int coef = 4;
    	if (nbGares == 2) {
    		coef = 10;
    	}
		return 150*coef;
	}
}
