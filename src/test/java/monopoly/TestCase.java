package monopoly;

import monopoly.Bien;
import monopoly.Joueur;
import monopoly.Case;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TestCase {

    @Test
    public void testCreateCase(){
        Case c = new Case("La case");
        assertNotNull(c);
    }


    @Test
    public void testNomCase(){
        String nom = "La case";
        Case c = new Case(nom);
        assertEquals(nom, c.getName());
    }


    @Test
    public void testSuivantCase(){
        Case c1 = new Case("une");
        Case c2 = new Case("dos");
        c1.setSuivant(c2);
        c2.setSuivant(c1);

        assertEquals(c1, c2.avance(1));
        assertEquals(c2, c1.avance(1));
    }


    @Test
    public void testProprioCase(){
        Case c = new Case("Une Case");
        Joueur j = new Joueur("Michel", c);

        c.nouveauProprio(j);

        assertEquals(j, c.getProprio());
    }

}
