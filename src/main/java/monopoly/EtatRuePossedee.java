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
    	if(!joueurEnTransac.paiementForce(prixLoyer)) {
    		prixLoyer += joueurEnTransac.getSolde();
		}
		rue.getProprio().recevoir(prixLoyer);
    }

    @Override
    public void arrive(final Joueur joueur) {
    	if(rue.getProprio() != joueur) {
    		payerLoyer(joueur);
    	}
    }

}
