
public class DaneTymczasowe implements IDaneTymczasowe {

	public Kierowca UtworzKierowce() {
		Kierowca kierowca = new Kierowca();
		return kierowca;
	}

	/**
	 * 
	 * @param model
	 */
	public Pojazd UtworzPojazd(String model) {
		Pojazd pojazd = new Pojazd(model);
		return pojazd;
	}

	public Spedytor UtworzSpedytora() {
		Spedytor spedytor = new Spedytor();
		return spedytor;
	}

	public Zlecenie UtworzZlecenie() {
		Zlecenie zlecenie = new Zlecenie();
		return zlecenie;
	}

	public Kierownik UtworzKierownika() {
		Kierownik kierownik = new Kierownik();
		return kierownik;
	}

	public Powiadomienie UtworzPowiadomienie() {
		Powiadomienie powiadomienie = new Powiadomienie();
		return powiadomienie;
	}

}