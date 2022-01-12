package shinobi;

public class Dress extends Items {

	public Dress(String titel, int price) {

		this.titel = titel;
		this.price = price;

	}

	public String getTitel() {
		return titel;
	}

	public int getPrice() {
		return price;
	}

	public static int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ID: " + (id++) + ",  Name:  " + getTitel() + ", Preis: " + getPrice() + "";
	}

	public static boolean compareObject(Dress objectOne, Dress objectTwo) {
		if (objectOne.getTitel().equals(objectTwo.getTitel()) && objectOne.getPrice() == objectTwo.getPrice()) {
			return true;

		} else {
			return false;

		}

	}

	@Override
	public int buyItems() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sellItems() {
		// TODO Auto-generated method stub
		return 0;
	}

}
