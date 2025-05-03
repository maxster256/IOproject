
import java.util.*;

public class Kierowca extends Uzytkownik {

	private int spedytorID;
	private ArrayList<Zlecenie> ListaZlecen = new ArrayList<>();
	private int CzasPracy;
	private int DziennyLimit;
	private ArrayList<Powiadomienie> upomnienia = new ArrayList<>();
	private int karaPieniezna;
	private int CzasJazdyBezLimitu;

	public int getCzasPracy() {
		return CzasPracy;
	}

	/**
	 * 
	 * @param CzasPracy
	 */
	public void setCzasPracy(int CzasPracy) {
		this.CzasPracy = CzasPracy;
	}

	public int getDziennyLimit() {
		return DziennyLimit;
	}

	/**
	 * 
	 * @param DziennyLimit
	 */
	public void setDziennyLimit(int DziennyLimit) {
		this.DziennyLimit = DziennyLimit;
	}

	public int getCzasJazdyBezLimitu() {
		return CzasJazdyBezLimitu;
	}

	/**
	 * 
	 * @param CzasJazdyBezLimitu
	 */
	public void setCzasJazdyBezLimitu(int CzasJazdyBezLimitu) {
		this.CzasJazdyBezLimitu = CzasJazdyBezLimitu;
	}

	public int getSpedytorID() {
		return this.spedytorID;
	}

	/**
	 * 
	 * @param spedytorID
	 */
	public void setSpedytorID(int spedytorID) {
		this.spedytorID = spedytorID;
	}

	public ArrayList<Zlecenie> getListaZlecen() {
		return ListaZlecen;
	}

	/**
	 * 
	 * @param ListaZlecen
	 */
	public void setListaZlecen(ArrayList<Zlecenie> ListaZlecen) {
		this.ListaZlecen = ListaZlecen;
	}

	public ArrayList<Powiadomienie> getUpomnienia() {
		return this.upomnienia;
	}

	/**
	 * 
	 * @param upomnienia
	 */
	public void setUpomnienia(ArrayList<Powiadomienie> upomnienia) {
		this.upomnienia = upomnienia;
	}

	public int getKaraPieniezna() {
		return this.karaPieniezna;
	}

	/**
	 * 
	 * @param karaPieniezna
	 */
	public void setKaraPieniezna(int karaPieniezna) {
		this.karaPieniezna = karaPieniezna;
	}

}