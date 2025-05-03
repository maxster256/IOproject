
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SpedytorDAO implements StrategiaDAO<Spedytor> {

	private String baza = "Spedytorzy.txt";

	/**
	 * 
	 * @param element
	 */
	public void dodajElement(Spedytor element) {
		// TODO - implement Prezenter.SpedytorDAO.dodajElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param element
	 */
	public void zaktualizujElement(Spedytor element) {
		// TODO - implement Prezenter.SpedytorDAO.zaktualizujElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void usunElement(int id) {
		// TODO - implement Prezenter.SpedytorDAO.usunElement
		throw new UnsupportedOperationException();
	}

	public ArrayList<Spedytor> uzyskajWszystkieElementy() {
		ArrayList<Spedytor> lista = new ArrayList<>();
		IDaneTymczasowe model = new DaneTymczasowe();
		String baza_dane = baza;
		try (BufferedReader reader = new BufferedReader(new FileReader(baza_dane))) {
			String line;
			while((line = reader.readLine()) != null){
				Spedytor spedytor = model.UtworzSpedytora();
				String[] wartosci = line.split(" ");
				spedytor.setUzytkownikID(Integer.parseInt(wartosci[0]));
				spedytor.setNazwaUzytkownika(wartosci[1]);
				spedytor.setHaslo(wartosci[2]);
				spedytor.setImie(wartosci[3]);
				spedytor.setNazwisko(wartosci[4]);
				lista.add(spedytor);
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
	public Spedytor uzyskajElementPoID(int id) {
		// TODO - implement Prezenter.SpedytorDAO.uzyskajElementPoID
		throw new UnsupportedOperationException();
	}

}