
import java.util.ArrayList;

public class FabrykaPylkow {

	private ArrayList<Pylek> pylki = new ArrayList<>();

	/**
	 * 
	 * @param model
	 */
	public Pylek getPylek(String model) {
		int index = 0;
		for(Pylek element : pylki){
			if(element.getModel().equals(model)){
				return element;
			}
			index++;
		}
		Pylek pylek = new PylekPojazd();
		pylek.setModel(model);
		return pylek;
	}

}