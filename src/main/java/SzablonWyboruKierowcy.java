
import java.util.ArrayList;

public class SzablonWyboruKierowcy extends KlasaSzablonowaWyboru {

	protected Produkt Wyszukaj() {
		Kreator kreator = new KreatorListaKierowcow();
		return kreator.OperacjaUtworzeniaListy();
	}

	/**
	 * 
	 * @param produkt
	 */
	protected void Wyswietl(Produkt produkt) {
		int i = 1;
		ArrayList<Kierowca> kierowcy = ((ProduktListaKierowcow)produkt).getListaKierowcow();
		for(Kierowca element : kierowcy){
			new PortDoWidoku().wyswietlanie(i + " " + element.getImie() + " " + element.getNazwisko());
			i++;
		}
		rozmiar = kierowcy.size();
	}

	protected int Wybierz() {
		int index;
		do{
			index = Integer.parseInt(new PortDoWidoku().wprowadzanieDanych("Wybierz numer kierowcy lub 0 aby wyjsc:"));
		}while(index < 0 || index > rozmiar);
		return --index;
	}

}