
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class RealizacjaZlecenia {

	private DAO kontekst = new DAO();
	private Kierowca kierowca = (Kierowca) Logowanie.getUser();;
	private Timer timer;
	private boolean zakonczone = false;
	private boolean przerwa = false;
	private long start;
	private long end;

	public void SzablonZlecenia() {
		PowiadomienieDAO powiadomienieDAO = new PowiadomienieDAO();
		kontekst.setStrategia(powiadomienieDAO);
		ArrayList<Powiadomienie> lista1 = kontekst.getStrategia().uzyskajWszystkieElementy();
		ArrayList<Powiadomienie> upomnienia = new ArrayList<>();
		for(Powiadomienie element : lista1){
			if(element.getUzytkownikID() == kierowca.getUzytkownikID()){
				upomnienia.add(element);
			}
		}
		kierowca.setUpomnienia(upomnienia);

		ZlecenieDAO zlecenieDAO = new ZlecenieDAO();
		kontekst.setStrategia(zlecenieDAO);
		ArrayList<Zlecenie> lista2 = kontekst.getStrategia().uzyskajWszystkieElementy();
		ArrayList<Zlecenie> zlecenia = new ArrayList<>();
		for(Zlecenie element : lista2){
			if(element.getKierowcaID() == kierowca.getUzytkownikID()){
				zlecenia.add(element);
			}
		}
		kierowca.setListaZlecen(zlecenia);

		if(!zlecenia.isEmpty()) {
			Zlecenie zlecenie = zlecenia.get(0);
			String action;
			do {
				ResetLimituJazdy();
				RozpoczecieZlecenia();
				action = new PortDoWidoku().wprowadzanieDanych("(1) Udanie sie na przerwe\n(0) Zakoncz zlecenie\n");
				if (action.equals("1")) {
					przerwa = true;
					new PortDoWidoku().wprowadzanieDanych("<Enter> Wznowienie jazdy:");
					przerwa = false;
				}
			} while (!action.equals("0"));
			ZakonczenieZlecenia(zlecenie);
			return;
		}
		new PortDoWidoku().wyswietlanie("Brak zlecen do wykonania");
	}

	protected void ResetLimituJazdy() {
		kierowca.setCzasJazdyBezLimitu(0);
	}

	protected void RozpoczecieZlecenia() {
		start = System.nanoTime();
		timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(przerwa){
					timer.cancel();
				}
				else if (!zakonczone) {
					kierowca.setCzasJazdyBezLimitu(kierowca.getCzasJazdyBezLimitu()+15);
					System.out.println(
							kierowca.getCzasJazdyBezLimitu()/60 + " godzin i "+
							kierowca.getCzasJazdyBezLimitu()%60 + " minut ciaglej jazdy!"
					);
				}
			}
		}, 1500, 1500);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(przerwa){
					timer.cancel();
				}
				else if (!zakonczone) {
					wyslanieOstrzezenia();
				}
			}
		}, 24000);

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if(przerwa){
					timer.cancel();
				}
				else if (!zakonczone) {
					wyslanieUpomnienia();
					if(kierowca.getUpomnienia().size() >= 5){
						NaliczenieKary();
					}
				}
			}
		}, 27000);
	}

	/**
	 * 
	 * @param zlecenie
	 */
	protected void ZakonczenieZlecenia(Zlecenie zlecenie) {
		end = System.nanoTime();
		zakonczone = true;
		//if (timer != null) {
			timer.cancel();
			new PortDoWidoku().wyswietlanie("Ukonczenie zlecenia!");
			int czasPracy = kierowca.getCzasPracy() + (int)(end - start)/1000000000;
			kierowca.setCzasPracy(czasPracy);
			ArrayList<Zlecenie> nowaLista = kierowca.getListaZlecen();
			nowaLista.remove(zlecenie);
			kierowca.setListaZlecen(nowaLista);
			ZlecenieDAO zlecenieDAO = new ZlecenieDAO();
			kontekst.setStrategia(zlecenieDAO);
			int id = zlecenie.getZlecenieID();
			kontekst.getStrategia().usunElement(id);
		//}
	}

	protected void NaliczenieKary() {
		new PortDoWidoku().wyswietlanie("Naliczona zostala kara 100zl!");
		kierowca.setKaraPieniezna(kierowca.getKaraPieniezna() + 100);
	}

	protected void wyslanieOstrzezenia() {
		new PortDoWidoku().wyswietlanie("Przekroczone zostaly 4h jazdy. Rozwaz przerwe!");
	}

	protected void wyslanieUpomnienia() {
		int powiadomienie_id;
		new PortDoWidoku().wyswietlanie("Przekroczony zostal limit 4.5h! Zjedz na przerwe!");
		PowiadomienieDAO powiadomienieDAO = new PowiadomienieDAO();
		IDaneTymczasowe model = new DaneTymczasowe();
		kontekst.setStrategia(powiadomienieDAO);
		Powiadomienie powiadomienie = model.UtworzPowiadomienie();
		ArrayList<Powiadomienie> powiadomienia = kontekst.getStrategia().uzyskajWszystkieElementy();
		if(powiadomienia.isEmpty()){powiadomienie_id = 0;}
		else{powiadomienie_id = powiadomienia.get(powiadomienia.size()-1).getPowiadomienieID()+1;}
		powiadomienie.setPowiadomienieID(powiadomienie_id);

		int id_uzytkownika = kierowca.getUzytkownikID();
		int id_spedytora = kierowca.getSpedytorID();
		powiadomienie.setUzytkownikID(id_uzytkownika);
		powiadomienie.setSpedytorID(id_spedytora);
		powiadomienie.setTypPowiadomienia(RodzajPowiadomienia.przekroczonyLimit);
		kontekst.getStrategia().dodajElement(powiadomienie);
		ArrayList<Powiadomienie> upomnienia = kierowca.getUpomnienia();
		upomnienia.add(powiadomienie);
		kierowca.setUpomnienia(upomnienia);
	}

}