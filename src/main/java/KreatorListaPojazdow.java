
public class KreatorListaPojazdow implements Kreator {

	public Produkt WykonajProdukt() {
		ProduktListaPojazdow produkt = new ProduktListaPojazdow();
		return produkt;
	}

	public Produkt OperacjaUtworzeniaListy() {
		Produkt produkt = WykonajProdukt();
		produkt.UtworzListe();
		return produkt;
	}

}