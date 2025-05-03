
import java.util.Scanner;

public class Terminal {

	private IPrzydzielanieFunkcjonalnosci prezenter = new PortDoPrezentera();
	private int rola;

	public void startTerminal() {
		// proces logowania
		int wybor;
		do{
			wybor = zaloguj();
			if(wybor == 0) {return;}
		}while(wybor == 1);
		System.out.println("Zalogowano!");
		// korzystanie z systemu
		boolean usingSystem;
		do{
			usingSystem = wyborFunkcjonalnosci();
		}while(usingSystem);
	}

	public int zaloguj() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("(<any key>) Wprowadzenie danych logowania\n(0) Wyjscie\n");
		String wybor = scanner.nextLine();
		if(wybor.equals("0")) {return 0;}
		do{
			System.out.println("Rola uzytkownika:\n(1) Kierowca\n(2) Kierownik magazynu\n(3) Spedytor\n");
			rola = scanner.nextInt();
		}while(rola < 1 || rola > 3);
		scanner.nextLine();
		System.out.println("Nazwa uzytkownika: ");
		String username = scanner.nextLine();
		System.out.println("Haslo: ");
		String password = scanner.nextLine();

		boolean logged = prezenter.Zaloguj(username, password, rola);
		if(logged) {return 2;}
		System.out.println("Wprowadzone dane sa niewlasciwe!");
		return 1;
	}

	public boolean wyborFunkcjonalnosci() {
		Scanner scanner = new Scanner(System.in);
		String funkcjonalnosc, zadanie = "";
		switch (rola){
			case 1:
				System.out.println("(0) Wyjscie\n(1) Wykonanie zlecenia\n");
				funkcjonalnosc = scanner.nextLine();
				if(funkcjonalnosc.equals("1")){zadanie = "zlecenie";}
				break;
			case 2:
				System.out.println("(0) Wyjscie\n(1) Przeprowadzenie zaladunku\n(2) Przeprowadzenie wyladunku\n");
				funkcjonalnosc = scanner.nextLine();
				if(funkcjonalnosc.equals("1")){zadanie = "zaladunek";}
				else if(funkcjonalnosc.equals("2")){zadanie = "wyladunek";}
				break;
			case 3:
				System.out.println("(0) Wyjscie\n(1) Przegladanie pojazdow\n(2) Przydzielanie zlecen\n");
				funkcjonalnosc = scanner.nextLine();
				if(funkcjonalnosc.equals("1")){zadanie = "pojazdy";}
				else if(funkcjonalnosc.equals("2")){zadanie = "przydzial";}
				break;
			default: return false;
		}
		if(!funkcjonalnosc.equals("0")){
			if(!zadanie.isEmpty()){
				prezenter.PrzyznanieFunkcjonalnosci(zadanie);
			}
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param wiadomosc
	 */
	public void wyswietlKomunikat(String wiadomosc) {
		System.out.println(wiadomosc);
	}

	public String poprosODane(String wiadomosc) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(wiadomosc);
		return scanner.nextLine();
	}

}