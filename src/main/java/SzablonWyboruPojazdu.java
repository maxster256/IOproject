
import java.util.ArrayList;

public class SzablonWyboruPojazdu extends KlasaSzablonowaWyboru {

	protected Produkt Wyszukaj() {
		Kreator kreator = new KreatorListaPojazdow();
		return kreator.OperacjaUtworzeniaListy();
	}

	/**
	 * 
	 * @param produkt
	 */
	protected void Wyswietl(Produkt produkt) {
		ArrayList<Pojazd> pojazdy = ((ProduktListaPojazdow)produkt).getListaPojazdow();
		int i = 1;
		for(Pojazd element : pojazdy){
			String stan;
			boolean sprawny = element.getStanPojazdu();
			if(sprawny){stan = "dobry";}
			else{stan = "wymaga naprawy";}
			PylekPojazd pylek = element.getPylek();
			new PortDoWidoku().wyswietlanie(i + " " + pylek.getModel() + " " + stan);
			i++;
		}
		rozmiar = pojazdy.size();
	}

	protected int Wybierz() {
		int index;
		do{
			index = Integer.parseInt(new PortDoWidoku().wprowadzanieDanych("Wybierz numer pojazdu lub 0 aby wyjsc:"));
		}while(index < 0 || index > rozmiar);
		return --index;
	}

}