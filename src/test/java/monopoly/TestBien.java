package monopoly;

import monopoly.Bien;
import monopoly.Joueur;
import monopoly.Case;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBien {

    @Test
    public void createBien(){
        Bien b = new Bien(50);
        assertEquals(b.getPrix(), 50);
    }


    @Test
    public void isBienHotel(){
        Bien b = new Bien(50);
        assertEquals(b.isHotel(), false);
    }
}
