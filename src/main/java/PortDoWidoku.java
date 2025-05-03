
public class PortDoWidoku implements IKomunikaty {

	/**
	 * 
	 * @param wiadomosc
	 */
	public void wyswietlanie(String wiadomosc) {
		new Terminal().wyswietlKomunikat(wiadomosc);
	}

	public String wprowadzanieDanych(String wiadomosc) {
		return new Terminal().poprosODane(wiadomosc);
	}

}