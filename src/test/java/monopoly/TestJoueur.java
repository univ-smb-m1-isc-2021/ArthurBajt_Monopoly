package monopoly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class TestJoueur {

    @Test
    void TestCreateJoueurName(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        Assertions.assertEquals("Michel", j.getNom());
    }

    @Test
    void TestCreateJoueurSolde(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        Assertions.assertEquals(1500, j.getSolde());
    }

    @Test
    void TestCreateJoueurCase(){
    	Case c = new Case("Départ");
        Joueur j = new Joueur("Michel",c);
        Assertions.assertEquals(c, j.getCase());
    }
    
}
