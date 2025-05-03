
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KierownikDAO implements StrategiaDAO<Kierownik> {

	private String baza = "Kierownicy.txt";
	/**
	 * 
	 * @param element
	 */
	public void dodajElement(Kierownik element) {
		// TODO - implement Prezenter.KierownikDAO.dodajElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param element
	 */
	public void zaktualizujElement(Kierownik element) {
		// TODO - implement Prezenter.KierownikDAO.zaktualizujElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void usunElement(int id) {
		// TODO - implement Prezenter.KierownikDAO.usunElement
		throw new UnsupportedOperationException();
	}

	public ArrayList<Kierownik> uzyskajWszystkieElementy() {
		ArrayList<Kierownik> lista = new ArrayList<>();
		IDaneTymczasowe model = new DaneTymczasowe();
		String baza_dane = baza;
		try (BufferedReader reader = new BufferedReader(new FileReader(baza_dane))) {
			String line;
			while((line = reader.readLine()) != null){
				Kierownik kierownik = model.UtworzKierownika();
				String[] wartosci = line.split(" ");
				kierownik.setUzytkownikID(Integer.parseInt(wartosci[0]));
				kierownik.setNazwaUzytkownika(wartosci[1]);
				kierownik.setHaslo(wartosci[2]);
				kierownik.setImie(wartosci[3]);
				kierownik.setNazwisko(wartosci[4]);
				kierownik.setSpedytorID(Integer.parseInt(wartosci[5]));
				kierownik.setMagazynID(Integer.parseInt(wartosci[6]));
				lista.add(kierownik);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/**
	 * 
	 * @param id
	 */
	public Kierownik uzyskajElementPoID(int id) {
		// TODO - implement Prezenter.KierownikDAO.uzyskajElementPoID
		throw new UnsupportedOperationException();
	}

}