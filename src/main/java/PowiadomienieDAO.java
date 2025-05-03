
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PowiadomienieDAO implements StrategiaDAO<Powiadomienie> {

	private String baza = "Powiadomienia.txt";

	/**
	 * 
	 * @param element
	 */
	public void dodajElement(Powiadomienie element) {
		String baza_dane = baza;
		try (FileWriter writer = new FileWriter(baza_dane, true)) {
			writer.write(element.getPowiadomienieID() + " " + element.getUzytkownikID() + " " + element.getSpedytorID() + " " + element.getTypPowiadomienia() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param element
	 */
	public void zaktualizujElement(Powiadomienie element) {
		// TODO - implement Prezenter.PowiadomienieDAO.zaktualizujElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void usunElement(int id) {
		// TODO - implement Prezenter.PowiadomienieDAO.usunElement
		throw new UnsupportedOperationException();
	}

	public ArrayList<Powiadomienie> uzyskajWszystkieElementy() {
		ArrayList<Powiadomienie> lista = new ArrayList<>();
		IDaneTymczasowe model = new DaneTymczasowe();
		String baza_dane = baza;
		try (BufferedReader reader = new BufferedReader(new FileReader(baza_dane))) {
			String line;
			while((line = reader.readLine()) != null){
				Powiadomienie powiadomienie = model.UtworzPowiadomienie();
				String[] wartosci = line.split(" ");
				powiadomienie.setPowiadomienieID(Integer.parseInt(wartosci[0]));
				powiadomienie.setUzytkownikID(Integer.parseInt(wartosci[1]));
				powiadomienie.setSpedytorID(Integer.parseInt(wartosci[2]));
				powiadomienie.setTypPowiadomienia(RodzajPowiadomienia.valueOf(wartosci[3]));
				lista.add(powiadomienie);
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
	public Powiadomienie uzyskajElementPoID(int id) {
		// TODO - implement Prezenter.PowiadomienieDAO.uzyskajElementPoID
		throw new UnsupportedOperationException();
	}

}