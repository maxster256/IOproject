
public abstract class AbstrakcyjnaObsluga {

	protected AbstrakcyjnaObsluga nastepnik;

	/**
	 * 
	 * @param zadanie
	 */
	public void Obsluz(String zadanie) {
	}

	/**
	 * 
	 * @param nastepnik
	 */
	public void setNastepnik(AbstrakcyjnaObsluga nastepnik) {
		this.nastepnik = nastepnik;
	}

}