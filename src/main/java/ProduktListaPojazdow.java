
import java.util.ArrayList;

public class ProduktListaPojazdow extends Produkt {

	private ArrayList<Pojazd> listaPojazdow;

	public void UtworzListe() {
		Uzytkownik user = Logowanie.getUser();
		if(user instanceof Spedytor){
			Spedytor spedytor = (Spedytor) user;
			PojazdDAO pojazdDAO = new PojazdDAO();
			kontekst.setStrategia(pojazdDAO);

			listaPojazdow = kontekst.getStrategia().uzyskajWszystkieElementy();
			for(Pojazd element : listaPojazdow){
				if(element.getSpedytorID() == spedytor.getUzytkownikID()) {
					lista.add(element);
				}
			}
		}
		else{
			new PortDoWidoku().wyswietlanie("Wystapil blad rzutowania");
		}
	}

	public ArrayList<Pojazd> getListaPojazdow() {
		return this.listaPojazdow;
	}

}