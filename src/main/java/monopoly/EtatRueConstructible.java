package monopoly;

public class EtatRueConstructible extends EtatRue {
	
	public EtatRueConstructible(Rue rue) {
		super(rue);
		rue.getProprio().propositionBien(rue.prixProchainBien());
	}

    @Override
    public void construire() {
    	rue.ajouteBien();
    	rue.changeEtat(new EtatRueExploitee(rue));
    	System.out.println("Construction dans " + rue.getName());
    	rue.getProprio().propositionBien(rue.prixProchainBien());
    }


    @Override
    public void payerLoyer(Joueur joueurEnTransac) {
    	int prixLoyer = (int)(rue.getPrixLieu()*rue.getCoefPrix()*2.0);
    	if(joueurEnTransac.paiementForce(prixLoyer)) {
    		rue.getProprio().recevoir(prixLoyer);
		} else {
			rue.getProprio().recevoir(joueurEnTransac.getSolde()+prixLoyer); //Si il a pas pu payer en entier il a donc perdu
    	}
    }
    
    @Override
    public void arrive(final Joueur joueur) {
    	if(rue.getProprio() != joueur) {
    		payerLoyer(joueur);
    	}
    	else {
        	rue.getProprio().propositionBien(rue.prixProchainBien());
    	}
    }

}
