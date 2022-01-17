package monopoly;

public class EtatRuePossedee extends EtatRue {
	
	public EtatRuePossedee(Rue rue) {
		super(rue);
	}

    @Override
    public void devientConstructible() {
    	rue.changeEtat(new EtatRueConstructible(rue));
    }

    @Override
    public void payerLoyer(Joueur joueurEnTransac) {
    	int prixLoyer = (int)(rue.getPrixLieu()*rue.getCoefPrix());
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
    }

}
