package monopoly;
import java.util.ArrayList;
import java.util.List;

public class Rue extends Case {
    private int prixLieu;

    private double coefAchat;

    private List<Bien> biens = new ArrayList<Bien> ();

    private EtatRue etat;

    private Quartier quartier;
    
    public Rue(String nom, Quartier quartier, int prixLieu, double coefAchat) {
    	super(nom);
    	this.quartier = quartier;
    	quartier.ajouteRue(this);
    	this.etat = new EtatRueAchetable(this);
    	this.prixLieu = prixLieu;
    	this.coefAchat = coefAchat;
    }

    @Override
    public void acheter() {
    	etat.acheter(joueurEnTransac);
    }

    public void construire() {
    	etat.construire();
    }

    public void payerLoyer() {
    }

    public void devientConstructible() {
    	etat.devientConstructible();
    }

    public void changeEtat(final EtatRue etat) {
    	this.etat = etat;
    }
    
    @Override
    public void arrive(final Joueur joueur) {
    	joueurEnTransac = joueur;
    	System.out.println(joueur.getNom() + " arrive dans la ville de "+nom);
    	etat.arrive(joueur);
    }
    
    public int getPrixLieu() {
    	return prixLieu;
    }
    
    @Override
    public void nouveauProprio(final Joueur joueur) {
    	proprio = joueur;
    	if(quartier.estPossedeeEntierement(joueur)) {
    		quartier.devientConstructible();
    	}
    }

	public double getCoefPrix() {
		return coefAchat;
	}

	public int getCoefBiens() {
		int nbBiens = biens.size();
		if(nbBiens == 1 && biens.get(0).isHotel()) {
			return 5;
		}
		return nbBiens;
	}

	public void ajouteBien() {
		int nbBiens = getCoefBiens();
		if(nbBiens < 4) {
			Maison m = new Maison();
			if(proprio.paiement(m.getPrix())) {
				biens.add(m);
			}
		}
		if(nbBiens == 4) {
			Hotel h = new Hotel();
			if(proprio.paiement(h.getPrix())) {
				biens.clear();
				biens.add(h);
			}
		}
	}

	public int prixProchainBien() {
		int nbBiens = getCoefBiens();
		if(nbBiens < 4) {
			Maison m = new Maison();
			return m.getPrix();
		}
		Hotel h = new Hotel();
		return h.getPrix();
	}
}
