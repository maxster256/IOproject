
public interface IPrzydzielanieFunkcjonalnosci {

	/**
	 * 
	 * @param zadanie
	 */
	void PrzyznanieFunkcjonalnosci(String zadanie);

	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param rola
	 */
	boolean Zaloguj(String login, String haslo, int rola);

}