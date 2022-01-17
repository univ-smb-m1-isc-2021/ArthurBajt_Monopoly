package monopoly;

public class Hotel extends Bien {
	public Hotel() {
		super(200);
	}
	
	@Override
	public boolean isHotel() {
		return true;
	}
}
