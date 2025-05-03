
public class Powiadomienie {

	private int powiadomienieID;
	private int uzytkownikID;
	private int spedytorID;
	private RodzajPowiadomienia TypPowiadomienia;

	public int getPowiadomienieID() {
		return this.powiadomienieID;
	}

	/**
	 * 
	 * @param powiadomienieID
	 */
	public void setPowiadomienieID(int powiadomienieID) {
		this.powiadomienieID = powiadomienieID;
	}

	public RodzajPowiadomienia getTypPowiadomienia() {
		return TypPowiadomienia;
	}

	/**
	 * 
	 * @param TypPowiadomienia
	 */
	public void setTypPowiadomienia(RodzajPowiadomienia TypPowiadomienia) {
		this.TypPowiadomienia = TypPowiadomienia;
	}

	public int getUzytkownikID() {
		return this.uzytkownikID;
	}

	/**
	 * 
	 * @param uzytkownikID
	 */
	public void setUzytkownikID(int uzytkownikID) {
		this.uzytkownikID = uzytkownikID;
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