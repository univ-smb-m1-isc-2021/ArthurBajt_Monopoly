package monopoly;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class TestBien {

    @Test
    void createBien(){
        Bien b = new Bien(50);
        Assertions.assertEquals(50, b.getPrix());
    }


    @Test
    void isBienHotel(){
        Bien b = new Bien(50);
        Assertions.assertFalse(b.isHotel());
    }
}
