
public class ObslugaZlecenia extends AbstrakcyjnaObsluga {

	/**
	 * 
	 * @param zadanie
	 */
	public void Obsluz(String zadanie) {
		if(zadanie.equals("zlecenie")){
			// wykonanie zlecenia przez kierowce
			RealizacjaZlecenia realizacjaZlecenia = new RealizacjaZlecenia();
			realizacjaZlecenia.SzablonZlecenia();
		}
		else if(nastepnik != null){
			nastepnik.Obsluz(zadanie);
		}
	}

}