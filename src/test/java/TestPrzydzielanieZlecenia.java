import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPrzydzielanieZlecenia {

    private TestDataClass helper;
    private PrzydzielanieZlecenia przydzielanieZlecenia;
    private Kierowca kierowca;
    private Pojazd pojazd;
    private Zlecenie zlecenie;

    // przygotownie odpowiednich instancji różnych obiektów przed każdym testem
    @Tag("Instancje")
    @BeforeEach
    public void setUp() {
        helper = new TestDataClass();
        przydzielanieZlecenia = new PrzydzielanieZlecenia();
        kierowca = new Kierowca();
        kierowca.setCzasPracy(300); // 5 godzin pracy
        pojazd = new Pojazd("Mercedes-Sprinter");
        zlecenie = new Zlecenie();
    }

    // sprawdzenie działania metody WeryfikacjaZlecenia() dla czasów nieprzekraczających czasu pracy kierowcy
    // dane są pobierane z klasy TestDataClass
    @Tag("Zlecenie_Poprawne")
    @Test
    @Order(1)
    public void testWeryfikacjaPoprawnegoZlecenia() {
        boolean result;
        for(int i=0; i<helper.orderData.length; i++){
            zlecenie.setCzasRozpoczecia(helper.orderData[i][0]);
            zlecenie.setCzasZakonczenia(helper.orderData[i][1]);
            result = przydzielanieZlecenia.WeryfikacjaZlecenia(zlecenie, kierowca);
            assertTrue(result);
        }
    }

    // sprawdzenie działania metody WeryfikacjaZlecenia() dla czasów przekraczających czas pracy kierowcy
    // dane są pobierane z klasy TestDataClass
    @Tag("Zlecenie_Zbyt_Dlugie")
    @Test
    @Order(2)
    public void testWeryfikacjaBlednegoZlecenia() {
        boolean result;
        for(int i=0; i<helper.wrongOrderData.length; i++){
            zlecenie.setCzasRozpoczecia(helper.wrongOrderData[i][0]);
            zlecenie.setCzasZakonczenia(helper.wrongOrderData[i][1]);
            result = przydzielanieZlecenia.WeryfikacjaZlecenia(zlecenie, kierowca);
            assertFalse(result);
        }
    }

    // sprawdzenie procesu zapisywania tworzonych zleceń do "bazy"
    @Tag("Dodawanie_Zlecenia_Do_Bazy")
    @Test
    @Order(3)
    public void testDodajZlecenie() {
        int initial_size = new ZlecenieDAO().uzyskajWszystkieElementy().size();
        for(int i=0; i<helper.orderData.length; i++){
            zlecenie.setKierowcaID(kierowca.getUzytkownikID());
            zlecenie.setPojazdID(pojazd.getPojazdID());
            zlecenie.setCzasRozpoczecia(helper.orderData[i][0]);
            zlecenie.setCzasZakonczenia(helper.orderData[i][1]);

            przydzielanieZlecenia.DodajZlecenie(zlecenie);

            ArrayList<Zlecenie> zlecenia = new ZlecenieDAO().uzyskajWszystkieElementy();

            assertFalse(zlecenia.isEmpty());
            assertEquals(initial_size + i + 1, zlecenia.size());

            assertEquals(kierowca.getUzytkownikID(), zlecenia.getLast().getKierowcaID());
            assertEquals(pojazd.getPojazdID(), zlecenia.getLast().getPojazdID());
            assertEquals(helper.orderData[i][0] ,zlecenia.getLast().getCzasRozpoczecia());
            assertEquals(helper.orderData[i][1] ,zlecenia.getLast().getCzasZakonczenia());
        }
    }
}
