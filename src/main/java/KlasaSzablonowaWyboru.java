
public abstract class KlasaSzablonowaWyboru {

	protected int rozmiar = 0;

	/**
	 * 
	 * @param wybor
	 */
	public Object SzablonWyboru(int wybor) {
		Produkt produkt = Wyszukaj();
		Wyswietl(produkt);
		if(wybor == 2){
			int element_id = Wybierz();
			if(element_id == -1){
				return null;
			}
			if(produkt instanceof ProduktListaPojazdow){
				Pojazd pojazd = ((ProduktListaPojazdow) produkt).getListaPojazdow().get(element_id);
				return pojazd;
			}
			else if(produkt instanceof ProduktListaKierowcow){
				Kierowca kierowca = ((ProduktListaKierowcow) produkt).getListaKierowcow().get(element_id);
				return kierowca;
			}
		}
		return null;
	}

	protected abstract Produkt Wyszukaj();

	/**
	 * 
	 * @param produkt
	 */
	protected abstract void Wyswietl(Produkt produkt);

	protected abstract int Wybierz();
}