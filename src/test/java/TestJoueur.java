import monopoly.Joueur;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestJoueur {

    @Test
    public void TestCreateJoueurName(){
        Joueur j = new Joueur("Michel");
        assertEquals("Michel", j.getNom());
    }

    @Test
    public void TestCreateJoueurSolde(){
        Joueur j = new Joueur("Michel");
        assertEquals(0, j.getSolde());
    }
    
}
