
public class Pojazd {

	private int pojazdID;
	private int spedytorID;
	private boolean stanPojazdu;
	private PylekPojazd pylek;
	private FabrykaPylkow fabryka = new FabrykaPylkow();

	/**
	 * 
	 * @param model
	 */
	public Pojazd(String model) {
		this.pylek = (PylekPojazd)fabryka.getPylek(model);
	}

	public int getPojazdID() {
		return this.pojazdID;
	}

	/**
	 * 
	 * @param pojazdID
	 */
	public void setPojazdID(int pojazdID) {
		this.pojazdID = pojazdID;
	}

	public boolean getStanPojazdu() {
		return this.stanPojazdu;
	}

	/**
	 * 
	 * @param stanPojazdu
	 */
	public void setStanPojazdu(boolean stanPojazdu) {
		this.stanPojazdu = stanPojazdu;
	}

	public PylekPojazd getPylek() {
		return this.pylek;
	}

	/**
	 * 
	 * @param pylek
	 */
	public void setPylek(PylekPojazd pylek) {
		this.pylek = pylek;
	}

	public FabrykaPylkow getFabryka() {
		return this.fabryka;
	}

	/**
	 * 
	 * @param fabryka
	 */
	public void setFabryka(FabrykaPylkow fabryka) {
		this.fabryka = fabryka;
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