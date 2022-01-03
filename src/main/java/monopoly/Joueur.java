package monopoly;

public class Joueur {

    private String nom;
    private int solde;


    public Joueur(String nom){
        this.nom = nom;
        this.solde = 0;
    }


    public String getNom() {
        return nom;
    }

    public int getSolde() {
        return solde;
    }
}
