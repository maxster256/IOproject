
public class ObslugaLadunek extends AbstrakcyjnaObsluga {

	/**
	 * 
	 * @param zadanie
	 */
	public void Obsluz(String zadanie) {
		if(zadanie.equals("zaladunek") || zadanie.equals("wyladunek")){
			// przeprowadzenie zaladunku/wyladunku przez kierownika
			ZaladunekWyladunek ladunek = new ZaladunekWyladunek();
			ladunek.SzablonLadunek(zadanie);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}

}