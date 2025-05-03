
import java.util.ArrayList;

public class Spedytor extends Uzytkownik {

	private ArrayList<Pojazd> listaPojazdow;
	private ArrayList<Kierowca> listaKierowcow;

	public ArrayList<Pojazd> getListaPojazdow() {
		return this.listaPojazdow;
	}

	/**
	 * 
	 * @param listaPojazdow
	 */
	public void setListaPojazdow(ArrayList<Pojazd> listaPojazdow) {
		this.listaPojazdow = listaPojazdow;
	}

	public ArrayList<Kierowca> getListaKierowcow() {
		return this.listaKierowcow;
	}

	/**
	 * 
	 * @param listaKierowcow
	 */
	public void setListaKierowcow(ArrayList<Kierowca> listaKierowcow) {
		this.listaKierowcow = listaKierowcow;
	}

}