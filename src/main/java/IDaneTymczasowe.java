
public interface IDaneTymczasowe {

	Kierowca UtworzKierowce();

	/**
	 * 
	 * @param model
	 */
	Pojazd UtworzPojazd(String model);

	Spedytor UtworzSpedytora();

	Zlecenie UtworzZlecenie();

	Kierownik UtworzKierownika();

	Powiadomienie UtworzPowiadomienie();

}