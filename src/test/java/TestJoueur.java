import monopoly.Joueur;
import monopoly.Case;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJoueur {

    @Test
    public void TestCreateJoueurName(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        assertEquals("Michel", j.getNom());
    }

    @Test
    public void TestCreateJoueurSolde(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        assertEquals(1500, j.getSolde());
    }

    @Test
    public void TestCreateJoueurCase(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        assertEquals(c, j.getCase());
    }
    
}
