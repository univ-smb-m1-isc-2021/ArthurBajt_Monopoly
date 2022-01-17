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
        assertEquals(50, b.getPrix());
    }


    @Test
    void isBienHotel(){
        Bien b = new Bien(50);
        assertEquals(false, b.isHotel());
    }
}
