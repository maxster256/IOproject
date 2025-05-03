
public class Kierownik extends Uzytkownik {

	private int spedytorID;
	private int magazynID;
	private int CzasZaladunku;

	public int getMagazynID() {
		return this.magazynID;
	}

	/**
	 * 
	 * @param magazynID
	 */
	public void setMagazynID(int magazynID) {
		this.magazynID = magazynID;
	}

	public int getCzasZaladunku() {
		return CzasZaladunku;
	}

	/**
	 * 
	 * @param CzasZaladunku
	 */
	public void setCzasZaladunku(int CzasZaladunku) {
		this.CzasZaladunku = CzasZaladunku;
	}

	public int getSpedytorID() {
		return this.spedytorID;
	}

	/**
	 * 
	 * @param spedytorID
	 */
	public void setSpedytorID(int spedytorID) {
		this.spedytorID = spedytorID;
	}

}