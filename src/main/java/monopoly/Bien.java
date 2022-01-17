package monopoly;

public class Bien {
    private int prix;

    public Bien(int p) {
    	prix = p;
    }

	public boolean isHotel() {
		return false;
	}
	
	public int getPrix() {
		return prix;
	}
}
