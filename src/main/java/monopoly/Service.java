package monopoly;

public class Service extends Case {
    protected String etat; //Achetable ou Possedee
    protected int prix;
    protected String type;
    
    public Service(String name, int prix, String type) {
    	super(name);
    	etat = "Achetable";
    	this.prix = prix;
    	this.type = type;
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
    	//Logger -> n'est pas un service des eaux ou une gare
    }
}
