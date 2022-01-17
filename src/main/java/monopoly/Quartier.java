package monopoly;
import java.util.ArrayList;
import java.util.List;

public class Quartier {
    private String nom;

    private EnumCouleur couleur;

    private List<Rue> rues = new ArrayList<Rue> ();
    
    public Quartier(String nom, EnumCouleur coul) {
    	this.nom = nom;
    	this.couleur = coul;
    }

    public boolean estPossedeeEntierement(final Joueur joueur) {
    	for(int i = 0; i < rues.size(); i++){
    		if(rues.get(i).getProprio() != joueur) {
    			return false;
    		}
    	}
    	return true;
    }

	public void ajouteRue(Rue rue) {
		rues.add(rue);
	}

	public void devientConstructible() {
		for(int i = 0; i < rues.size(); i++) {
			rues.get(i).devientConstructible();
		}
	}

	public EnumCouleur getCouleur() {
		return couleur;
	}
	
	public String getNom() {
		return nom;
	}
}
