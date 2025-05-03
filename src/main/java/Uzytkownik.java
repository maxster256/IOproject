
public abstract class Uzytkownik {

	private int uzytkownikID;
	private String nazwaUzytkownika;
	private String haslo;
	private String Imie;
	private String Nazwisko;

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

	public String getNazwaUzytkownika() {
		return this.nazwaUzytkownika;
	}

	/**
	 * 
	 * @param nazwaUzytkownika
	 */
	public void setNazwaUzytkownika(String nazwaUzytkownika) {
		this.nazwaUzytkownika = nazwaUzytkownika;
	}

	public String getHaslo() {
		return this.haslo;
	}

	/**
	 * 
	 * @param haslo
	 */
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return Imie;
	}

	/**
	 * 
	 * @param Imie
	 */
	public void setImie(String Imie) {
		this.Imie = Imie;
	}

	public String getNazwisko() {
		return Nazwisko;
	}

	/**
	 * 
	 * @param Nazwisko
	 */
	public void setNazwisko(String Nazwisko) {
		this.Nazwisko = Nazwisko;
	}

}