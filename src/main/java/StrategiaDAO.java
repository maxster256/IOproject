
import java.util.ArrayList;

public interface StrategiaDAO<GenericDAO> {

	/**
	 * 
	 * @param element
	 */
	void dodajElement(GenericDAO element);

	/**
	 * 
	 * @param element
	 */
	void zaktualizujElement(GenericDAO element);

	/**
	 * 
	 * @param id
	 */
	void usunElement(int id);

	ArrayList<GenericDAO> uzyskajWszystkieElementy();

	/**
	 * 
	 * @param id
	 */
	GenericDAO uzyskajElementPoID(int id);

}