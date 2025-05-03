import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPrzydzielanieFunkcjonalnosci {

    @Tested
    private PortDoPrezentera portDoPrezentera;

    @Mocked
    private Spedytor spedytor;

    @Mocked
    private Kierowca kierowca;

    @Mocked
    private Logowanie logowanie;

    // sprawdzenie funkcjonalności wyświetlanie pojazdów (dla spedytora)
    @Tag("Lancuch_Spedytor")
    @ParameterizedTest
    @Order(1)
    @CsvSource({"pojazdy"})
    public void testPrzyznanieFunkcjonalnosciSpedytor(String zadanie) {
        // ustawienie mocka w celu wykonania funkcjonalności bez uprzedniego logowania
        new Expectations() {{
            spedytor.getUzytkownikID();
            result = 3;
            Logowanie.getUser();
            result = spedytor;
        }};
        assertDoesNotThrow(() -> portDoPrezentera.PrzyznanieFunkcjonalnosci(zadanie));
    }

    // sprawdzenie funkcjonalności realizacja zlecenia w przypadku braku zleceń (dla kierowcy)
    @Tag("Lancuch_Kierowca")
    @ParameterizedTest
    @Order(2)
    @CsvSource({"zlecenie"})
    public void testPrzyznanieFunkcjonalnosciKierowca(String zadanie) {
        // ustawienie mocka w celu wykonania funkcjonalności bez uprzedniego logowania
        new Expectations() {{
            kierowca.getUzytkownikID();
            result = 100;
            minTimes = 0;
            maxTimes = Integer.MAX_VALUE;
            Logowanie.getUser();
            result = kierowca;
        }};
        assertDoesNotThrow(() -> portDoPrezentera.PrzyznanieFunkcjonalnosci(zadanie));
    }

    // sprawdzenie nieobsługiwanej funkcjonalności (błędnie sformułowanego żądania)
    @Tag("Bledny_Lancuch")
    @ParameterizedTest
    @Order(3)
    @CsvSource({"jazda"})
    public void testBlednePrzyznanieFunkcjonalnosci(String zadanie) {
        assertThrows(UnsupportedOperationException.class, () -> {
            portDoPrezentera.PrzyznanieFunkcjonalnosci(zadanie);
        });
    }
}
