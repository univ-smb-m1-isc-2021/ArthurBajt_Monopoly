package monopoly;

public class Maison extends Bien {
	public Maison() {
		super(200);
	}
	
	@Override
	public boolean isHotel() {
		return false;
	}
}
