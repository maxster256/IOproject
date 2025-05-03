
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ZlecenieDAO implements StrategiaDAO<Zlecenie> {

	private String baza = "Zlecenia.txt";

	/**
	 * 
	 * @param element
	 */
	public void dodajElement(Zlecenie element) {
		String baza_dane = baza;
		try (FileWriter writer = new FileWriter(baza_dane, true)) {
			writer.write(element.getZlecenieID() + " " + element.getKierowcaID() + " " + element.getPojazdID() + " " + element.getCzasRozpoczecia() + " " + element.getCzasZakonczenia() + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param element
	 */
	public void zaktualizujElement(Zlecenie element) {
		// TODO - implement Prezenter.ZlecenieDAO.zaktualizujElement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public void usunElement(int id) {
		String baza_dane = baza;
		ArrayList<Zlecenie> lista = uzyskajWszystkieElementy();
		try (FileWriter writer = new FileWriter(baza_dane)) {
			for(Zlecenie element : lista){
				if(element.getZlecenieID() != id){
					writer.write(element.getZlecenieID() + " " + element.getKierowcaID() + " " + element.getPojazdID() + " " + element.getCzasRozpoczecia() + " " + element.getCzasZakonczenia() + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Zlecenie> uzyskajWszystkieElementy() {
		ArrayList<Zlecenie> lista = new ArrayList<>();
		IDaneTymczasowe model = new DaneTymczasowe();
		String baza_dane = baza;
		try (BufferedReader reader = new BufferedReader(new FileReader(baza_dane))) {
			String line;
			while((line = reader.readLine()) != null){
				Zlecenie zlecenie = model.UtworzZlecenie();
				String[] wartosci = line.split(" ");
				zlecenie.setZlecenieID(Integer.parseInt(wartosci[0]));
				zlecenie.setKierowcaID(Integer.parseInt(wartosci[1]));
				zlecenie.setPojazdID(Integer.parseInt(wartosci[2]));
				zlecenie.setCzasRozpoczecia(wartosci[3]);
				zlecenie.setCzasZakonczenia(wartosci[4]);
				lista.add(zlecenie);
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
	public Zlecenie uzyskajElementPoID(int id) {
		// TODO - implement Prezenter.ZlecenieDAO.uzyskajElementPoID
		throw new UnsupportedOperationException();
	}

}