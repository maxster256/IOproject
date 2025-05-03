
import java.util.ArrayList;

public class Logowanie {

	private static Logowanie instancja;
	private static Uzytkownik zalogowanyUzytkownik;
	private DAO kontekst = new DAO();

	private Logowanie() {
	}

	public static Uzytkownik getUser() {
		return zalogowanyUzytkownik;
	}

	public static Logowanie getInstancja() {
		if (instancja == null) {
			instancja = new Logowanie();
		}
		return instancja;
	}

	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param rola
	 */
	public boolean login(String login, String haslo, int rola) {
		ArrayList<Uzytkownik> dane;
		switch(rola){
			case 0: return false;
			case 1: KierowcaDAO kierowcaDAO = new KierowcaDAO();
					kontekst.setStrategia(kierowcaDAO); break;
			case 2: KierownikDAO kierownikDAO = new KierownikDAO();
					kontekst.setStrategia(kierownikDAO); break;
			case 3: SpedytorDAO spedytorDAO = new SpedytorDAO();
					kontekst.setStrategia(spedytorDAO); break;
			default: break;
		}
		if(kontekst.getStrategia() != null) {
			dane = kontekst.getStrategia().uzyskajWszystkieElementy();
		}
		else{return false;}
		for(Uzytkownik element : dane){
			String userName = element.getNazwaUzytkownika();
			if(userName.equals(login)){
				String password = element.getHaslo();
				if(password.equals(haslo)){
					zalogowanyUzytkownik = element;
					return true;
				}
				else{return false;}
			}
		}
		return false;
	}

	public void wyloguj() {
		// TODO - implement Prezenter.Logowanie.wyloguj
		throw new UnsupportedOperationException();
	}

	public boolean czyZalogowany() {
		// TODO - implement Prezenter.Logowanie.czyZalogowany
		throw new UnsupportedOperationException();
	}

	public Uzytkownik getLog() {
		// TODO - implement Prezenter.Logowanie.getLog
		throw new UnsupportedOperationException();
	}

}