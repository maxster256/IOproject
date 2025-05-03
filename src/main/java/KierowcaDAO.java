
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class KierowcaDAO implements StrategiaDAO<Kierowca> {

	private String baza = "Kierowcy.txt";

	/**
	 * 
	 * @param element
	 */
	public void dodajElement(Kierowca element) {
		// TODO - implement Prezenter.KierowcaDAO.dodajElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param element
	 */
	public void zaktualizujElement(Kierowca element) {
		// TODO - implement Prezenter.KierowcaDAO.zaktualizujElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void usunElement(int id) {
		// TODO - implement Prezenter.KierowcaDAO.usunElement
		throw new UnsupportedOperationException();
	}

	public ArrayList<Kierowca> uzyskajWszystkieElementy() {
		ArrayList<Kierowca> lista = new ArrayList<>();
		IDaneTymczasowe model = new DaneTymczasowe();
		String baza_dane = baza;
		try (BufferedReader reader = new BufferedReader(new FileReader(baza_dane))) {
			String line;
			while((line = reader.readLine()) != null){
				Kierowca kierowca = model.UtworzKierowce();
				String[] wartosci = line.split(" ");
				kierowca.setUzytkownikID(Integer.parseInt(wartosci[0]));
				kierowca.setNazwaUzytkownika(wartosci[1]);
				kierowca.setHaslo(wartosci[2]);
				kierowca.setImie(wartosci[3]);
				kierowca.setNazwisko(wartosci[4]);
				kierowca.setSpedytorID(Integer.parseInt(wartosci[5]));
				kierowca.setCzasPracy(Integer.parseInt(wartosci[6]));
				kierowca.setDziennyLimit(Integer.parseInt(wartosci[7]));
				kierowca.setKaraPieniezna(Integer.parseInt(wartosci[8]));
				lista.add(kierowca);
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
	public Kierowca uzyskajElementPoID(int id) {
		// TODO - implement Prezenter.KierowcaDAO.uzyskajElementPoID
		throw new UnsupportedOperationException();
	}

}