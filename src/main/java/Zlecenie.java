
public class Zlecenie {

	private int zlecenieID;
	private int kierowcaID;
	private int pojazdID;
	private String CzasRozpoczecia;
	private String CzasZakonczenia;

	public int getZlecenieID() {
		return this.zlecenieID;
	}

	/**
	 * 
	 * @param zlecenieID
	 */
	public void setZlecenieID(int zlecenieID) {
		this.zlecenieID = zlecenieID;
	}

	public String getCzasRozpoczecia() {
		return CzasRozpoczecia;
	}

	/**
	 * 
	 * @param CzasRozpoczecia
	 */
	public void setCzasRozpoczecia(String CzasRozpoczecia) {
		this.CzasRozpoczecia = CzasRozpoczecia;
	}

	public String getCzasZakonczenia() {
		return CzasZakonczenia;
	}

	/**
	 * 
	 * @param CzasZakonczenia
	 */
	public void setCzasZakonczenia(String CzasZakonczenia) {
		this.CzasZakonczenia = CzasZakonczenia;
	}

	public int getKierowcaID() {
		return this.kierowcaID;
	}

	/**
	 * 
	 * @param kierowcaID
	 */
	public void setKierowcaID(int kierowcaID) {
		this.kierowcaID = kierowcaID;
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

}