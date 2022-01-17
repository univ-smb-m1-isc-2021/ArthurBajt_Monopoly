package monopoly;

public class EtatRueAchetable extends EtatRue {	
	
	public EtatRueAchetable(Rue rue) {
		super(rue);
	}

    @Override
	public void acheter(Joueur joueurEnTransac) {
		if(joueurEnTransac.paiement(rue.getPrixLieu())) {
			rue.nouveauProprio(joueurEnTransac);
			rue.changeEtat(new EtatRuePossedee(rue));
		}
    }

    @Override
    public void arrive(final Joueur joueur) {
    	joueur.propositionAchatCase(rue.getPrixLieu());
    }

}
