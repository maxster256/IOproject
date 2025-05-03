
public class KreatorListaKierowcow implements Kreator {

	public Produkt WykonajProdukt() {
		ProduktListaKierowcow produkt = new ProduktListaKierowcow();
		return produkt;
	}

	public Produkt OperacjaUtworzeniaListy() {
		Produkt produkt = WykonajProdukt();
		produkt.UtworzListe();
		return produkt;
	}
}