
import java.util.ArrayList;

public class ProduktListaKierowcow extends Produkt {

	private ArrayList<Kierowca> listaKierowcow;

	public void UtworzListe() {
		Uzytkownik user = Logowanie.getUser();
		if(user instanceof Spedytor) {
			Spedytor spedytor = (Spedytor) user;
			KierowcaDAO kierowcaDAO = new KierowcaDAO();
			kontekst.setStrategia(kierowcaDAO);

			listaKierowcow = kontekst.getStrategia().uzyskajWszystkieElementy();
			for (Kierowca element : listaKierowcow) {
				if (element.getSpedytorID() == spedytor.getUzytkownikID()) {
					lista.add(element);
				}
			}
		}
		else{
			new PortDoWidoku().wyswietlanie("Wystapil blad rzutowania");
		}
	}

	public ArrayList<Kierowca> getListaKierowcow() {
		return this.listaKierowcow;
	}

}