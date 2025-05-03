public class PortDoPrezentera implements IPrzydzielanieFunkcjonalnosci {

    private Logowanie sesja = Logowanie.getInstancja();
    private AbstrakcyjnaObsluga lancuch = new ObslugaKatalogow();
    private AbstrakcyjnaObsluga lancuch2 = new ObslugaZlecenia();
    private AbstrakcyjnaObsluga lancuch3 = new ObslugaLadunek();

    /**
     *
     * @param zadanie
     */
    public void PrzyznanieFunkcjonalnosci(String zadanie) {

        lancuch.setNastepnik(lancuch2);
        lancuch2.setNastepnik(lancuch3);

        lancuch.Obsluz(zadanie);
    }

    /**
     *
     * @param login
     * @param haslo
     * @param rola
     */
    public boolean Zaloguj(String login, String haslo, int rola) {
        boolean logged = sesja.login(login, haslo, rola);
        return logged;
    }

}
