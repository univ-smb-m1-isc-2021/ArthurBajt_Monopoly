package monopoly;

public class Service extends Case {
    protected String etat; //Achetable ou Possedee
    
    public Service(String name) {
    	super(name);
    	etat = "Achetable";
    }

    public void acheter() {
    }

    @Override
    public void arrive(final Joueur joueur) {
    }
}
