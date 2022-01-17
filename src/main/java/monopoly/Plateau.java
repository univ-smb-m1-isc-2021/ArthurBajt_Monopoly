package monopoly;
import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Joueur> joueurs = new ArrayList<> ();
    private int indJoueur = 0;

    private Case depart;

    private List<Quartier> quartiers = new ArrayList<> ();
    
    public Plateau() {
    	creerPlateau();
    }

    private void creerPlateau() {
    	ArrayList<Case> cases = new ArrayList<>();
    	
		// Depart + 4 gares + 2 sde + 3 quartiers de 3 rues
		Quartier france = new Quartier("France", EnumCouleur.BLEU);
		quartiers.add(france);
		Quartier italie = new Quartier("Italie", EnumCouleur.VERT);
		quartiers.add(italie);
		Quartier japon = new Quartier("Japon", EnumCouleur.ROUGE);
		quartiers.add(japon);
		
		depart = new Case("Départ");
		cases.add(depart);
		Case c;
		
		c = new Rue("Marseille",france,100,1.0);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Gare("Part-Dieu",300);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Lyon",france,130,1.3);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Paris",france,170,1.7);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Gare("Firenze San Marco Vecchio",300);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Florence",italie,200,2.0);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new ServiceDesEaux("Servizio acqueo di Venezia",500);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Venise",italie,230,2.3);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Gare("Roma Aurelia",300);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Rome",italie,270,2.7);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Osaka",japon,300,3.0);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new ServiceDesEaux("Kyoto suido",500);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Kyoto",japon,330,3.3);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Gare("Tokyo-eki",300);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c = new Rue("Tokyo",japon,370,3.7);
		cases.add(c);
		cases.get(cases.indexOf(c)-1).setSuivant(c);
		
		c.setSuivant(depart);
	}

	public void creerJoueur(String name) {
    	Joueur j = new Joueur(name,depart);
    	joueurs.add(j);
    }

    public void nouveauTour() {
    	Joueur j = prochainJoueur();
    	System.out.println("C'est au tour de " + j.getNom());
    	j.joueTour();
    }

    private Joueur prochainJoueur() {
    	Joueur nextJoueur = null;
    	do {
        	indJoueur = indJoueur%joueurs.size();
        	nextJoueur = joueurs.get(indJoueur++);
    	} while(nextJoueur.getSolde()<0);
    	return nextJoueur;
    }

	public boolean isFini() {
		int nbJoueursRestants = 0;
		for(int i = 0; i<joueurs.size(); i++) {
			if(joueurs.get(i).getSolde()>=0) {
				nbJoueursRestants++;
			}
		}
		return nbJoueursRestants<=1;
	}

}
