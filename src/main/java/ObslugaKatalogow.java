
public class ObslugaKatalogow extends AbstrakcyjnaObsluga {
	KlasaSzablonowaWyboru szablon = new SzablonWyboruPojazdu();
	KlasaSzablonowaWyboru szablon1 = new SzablonWyboruKierowcy();
	/**
	 * 
	 * @param zadanie
	 */
	public void Obsluz(String zadanie) {
		if(zadanie.equals("pojazdy")){
			// przegladanie pojazdow przez spedytora
			new PortDoWidoku().wyswietlanie("Dostepne pojazdy:");
			szablon.SzablonWyboru(1);
		}
		else if(zadanie.equals("przydzial")){
			// przydzielenie zlecenia przez spedytora (wlacznie z przegladaniem [i wybraniem] pojazdu oraz kierowcy)
			new PortDoWidoku().wyswietlanie("Dostepni kierowcy:");
			Kierowca kierowca = (Kierowca)szablon1.SzablonWyboru(2);
			if(kierowca == null){
				return;
			}

			Pojazd pojazd;
			boolean sprawny;
			do {
				new PortDoWidoku().wyswietlanie("Dostepne pojazdy - wybierz pojazd o dobrym stanie technicznym:");
				pojazd = (Pojazd)szablon.SzablonWyboru(2);
				if(pojazd == null){
					return;
				}
				sprawny = pojazd.getStanPojazdu();
			}while(!sprawny);

			PrzydzielanieZlecenia przydzielanieZlecenia = new PrzydzielanieZlecenia();
			przydzielanieZlecenia.SzablonPrzypiszZlecenie(pojazd, kierowca);
		}
		else if(nastepnik != null){
			nastepnik.Obsluz(zadanie);
		}
	}

}