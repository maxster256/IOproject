
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ZaladunekWyladunek {

	private DAO kontekst = new DAO();
	private Kierownik kierownik = (Kierownik)Logowanie.getUser();
	private Timer timer;
	private boolean zakonczone = false;
	private boolean przekroczony_czas = false;
	private long start;
	private long end;

	public void SzablonLadunek(String zadanie) {
		Rozpoczecie();
		new PortDoWidoku().wprowadzanieDanych("<Enter> Zakoncz " + zadanie + ": ");
		Zakonczenie();
		if(przekroczony_czas){
			wprowadzenieNiestandardowegoCzasu();
			powiadomienieOPrzekroczonymCzasie(zadanie);
		}
	}

	protected void Rozpoczecie() {
		start = System.nanoTime();
		timer = new Timer();

		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				if (!zakonczone) {
					new PortDoWidoku().wyswietlanie("Przekroczony zostal standardowy czas 1h");
					przekroczony_czas = true;
				}
			}
		}, 5000); // 5 sekund
	}

	protected void Zakonczenie() {
		end = System.nanoTime();
		zakonczone = true;
		if (timer != null) {
			timer.cancel();
			new PortDoWidoku().wyswietlanie("Ukonczenie zlecenia!");
		}
	}

	protected void wprowadzenieNiestandardowegoCzasu() {
		new PortDoWidoku().wyswietlanie("Opoznienie wynioslo " + ((end-start)/1000000000 - 5) + " minut i zostanie\nuwzglednione w calkowitym czasie pracy kierowcy!");
	}

	protected void powiadomienieOPrzekroczonymCzasie(String zadanie) {
		PowiadomienieDAO powiadomienieDAO = new PowiadomienieDAO();
		IDaneTymczasowe model = new DaneTymczasowe();
		Powiadomienie powiadomienie = model.UtworzPowiadomienie();
		kontekst.setStrategia(powiadomienieDAO);
		if(zadanie.equals("zaladunek")){
			powiadomienie.setTypPowiadomienia(RodzajPowiadomienia.przekroczonyCzasZaladunku);
		}
		else if(zadanie.equals("wyladunek")){
			powiadomienie.setTypPowiadomienia(RodzajPowiadomienia.przekroczonyCzasWyladunku);
		}
		StrategiaDAO strategia = kontekst.getStrategia();
		ArrayList<Powiadomienie> powiadomienia = strategia.uzyskajWszystkieElementy();
		powiadomienie.setPowiadomienieID(powiadomienia.size());
		int id_kierownika = kierownik.getUzytkownikID();
		powiadomienie.setUzytkownikID(id_kierownika);
		int id_spedytora = kierownik.getSpedytorID();
		powiadomienie.setSpedytorID(id_spedytora);
		strategia.dodajElement(powiadomienie);
	}
}