package monopoly;

import monopoly.Bien;
import monopoly.Joueur;
import monopoly.Case;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


class TestBien {

    @Test
    void createBien(){
        Bien b = new Bien(50);
        assertEquals(b.getPrix(), 50);
    }


    @Test
    void isBienHotel(){
        Bien b = new Bien(50);
        assertEquals(b.isHotel(), false);
    }
}
