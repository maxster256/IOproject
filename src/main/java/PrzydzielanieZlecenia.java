
import java.util.ArrayList;

public class PrzydzielanieZlecenia {

	private DAO kontekst = new DAO();

	/**
	 * 
	 * @param pojazd
	 * @param kierowca
	 */
	public void SzablonPrzypiszZlecenie(Pojazd pojazd, Kierowca kierowca) {
		String rozpoczecie = PrzypiszCzasRozpoczecia();
		String zakonczenie = PrzypiszCzasZakonczenia();
		Zlecenie zlecenie = UtworzZlecenie(pojazd, kierowca, rozpoczecie, zakonczenie);

		boolean zweryfikowane = WeryfikacjaZlecenia(zlecenie, kierowca);
		if(zweryfikowane){
			new PortDoWidoku().wyswietlanie("Zlecenie zostało dodane dla kierowcy");
			DodajZlecenie(zlecenie);
		}
		else{
			new PortDoWidoku().wyswietlanie("Kierowca nie moze zrealizowac tego zlecenia w swoim czasie pracy");
		}
	}

	protected String PrzypiszCzasRozpoczecia() {
		int godzina, minuta;
		do{
			godzina = Integer.parseInt(new PortDoWidoku().wprowadzanieDanych("Podaj godzine rozpoczecia: "));
		}while(godzina < 0 || godzina > 23);
		do{
			minuta = Integer.parseInt(new PortDoWidoku().wprowadzanieDanych("Podaj minute rozpoczecia: "));
		}while(minuta < 0 || minuta > 59);

		return godzina + ":" + minuta;
	}

	protected String PrzypiszCzasZakonczenia() {
		int godzina, minuta;
		do{
			godzina = Integer.parseInt(new PortDoWidoku().wprowadzanieDanych("Podaj godzine zakonczenia: "));
		}while(godzina < 0 || godzina > 23);
		do{
			minuta = Integer.parseInt(new PortDoWidoku().wprowadzanieDanych("Podaj minute zakonczenia: "));
		}while(minuta < 0 || minuta > 59);

		return godzina + ":" + minuta;
	}

	/**
	 * 
	 * @param pojazd
	 * @param kierowca
	 * @param czasRozpoczecia
	 * @param czasZakonczenia
	 */
	protected Zlecenie UtworzZlecenie(Pojazd pojazd, Kierowca kierowca, String czasRozpoczecia, String czasZakonczenia) {
		IDaneTymczasowe model = new DaneTymczasowe();
		Zlecenie zlecenie = model.UtworzZlecenie();
		int user_id = kierowca.getUzytkownikID();
		int pojazd_id = pojazd.getPojazdID();
		zlecenie.setKierowcaID(user_id);
		zlecenie.setPojazdID(pojazd_id);
		zlecenie.setCzasRozpoczecia(czasRozpoczecia);
		zlecenie.setCzasZakonczenia(czasZakonczenia);
		return zlecenie;
	}

	/**
	 * 
	 * @param zlecenie
	 */
	protected void DodajZlecenie(Zlecenie zlecenie) {
		int zlecenie_id;
		ZlecenieDAO zlecenieDAO = new ZlecenieDAO();
		kontekst.setStrategia(zlecenieDAO);
		StrategiaDAO strategia = kontekst.getStrategia();
		ArrayList<Zlecenie> zlecenia = strategia.uzyskajWszystkieElementy();
		if(zlecenia.isEmpty()){zlecenie_id = 0;}
		else{zlecenie_id = zlecenia.get(zlecenia.size()-1).getZlecenieID()+1;}
		zlecenie.setZlecenieID(zlecenie_id);
		strategia.dodajElement(zlecenie);
	}

	/**
	 * 
	 * @param zlecenie
	 * @param kierowca
	 */
	protected boolean WeryfikacjaZlecenia(Zlecenie zlecenie, Kierowca kierowca) {
		int czasPracy = kierowca.getCzasPracy();
		String[] czasStart = zlecenie.getCzasRozpoczecia().split(":");
		String[] czasKoniec = zlecenie.getCzasZakonczenia().split(":");
		int godziny = Integer.parseInt(czasKoniec[0]) - Integer.parseInt(czasStart[0]);
		int minuty = Integer.parseInt(czasKoniec[1]) - Integer.parseInt(czasStart[1]);
		// czy zlecenie przekracza limit pracy (9h) wyrazony w minutach
		boolean czy_przekracza_limit = 540 >= ((godziny + 24) % 24) * 60 + ((minuty + 60) % 60 + czasPracy);
		return czy_przekracza_limit;
	}

}