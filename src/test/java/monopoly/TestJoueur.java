package monopoly;

import monopoly.Joueur;
import monopoly.Case;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TestJoueur {

    @Test
    void TestCreateJoueurName(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        assertEquals("Michel", j.getNom());
    }

    @Test
    void TestCreateJoueurSolde(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        assertEquals(1500, j.getSolde());
    }

    @Test
    void TestCreateJoueurCase(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        assertEquals(c, j.getCase());
    }
    
}
