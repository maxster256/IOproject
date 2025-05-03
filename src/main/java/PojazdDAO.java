
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PojazdDAO implements StrategiaDAO<Pojazd> {

	private String baza = "Pojazdy.txt";

	/**
	 * 
	 * @param element
	 */
	public void dodajElement(Pojazd element) {
		// TODO - implement Prezenter.PojazdDAO.dodajElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param element
	 */
	public void zaktualizujElement(Pojazd element) {
		// TODO - implement Prezenter.PojazdDAO.zaktualizujElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void usunElement(int id) {
		// TODO - implement Prezenter.PojazdDAO.usunElement
		throw new UnsupportedOperationException();
	}

	public ArrayList<Pojazd> uzyskajWszystkieElementy() {
		ArrayList<Pojazd> lista = new ArrayList<>();
		IDaneTymczasowe model = new DaneTymczasowe();
		String baza_dane = baza;
		try (BufferedReader reader = new BufferedReader(new FileReader(baza_dane))) {
			String line;
			while((line = reader.readLine()) != null){
				String[] wartosci = line.split(" ");
				Pojazd pojazd = model.UtworzPojazd(wartosci[3]);
				pojazd.setPojazdID(Integer.parseInt(wartosci[0]));
				pojazd.setSpedytorID(Integer.parseInt(wartosci[1]));
				pojazd.setStanPojazdu(Boolean.parseBoolean(wartosci[2]));
				pojazd.setPylek((PylekPojazd)pojazd.getFabryka().getPylek(wartosci[3]));
				lista.add(pojazd);
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
	public Pojazd uzyskajElementPoID(int id) {
		// TODO - implement Prezenter.PojazdDAO.uzyskajElementPoID
		throw new UnsupportedOperationException();
	}

}