import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestZlecenieDAO {
    private ZlecenieDAO zlecenieDAO;

    // uzupelnienie zawartości pliku przed każdym testem
    @BeforeEach
    public void setUp() {
        zlecenieDAO = new ZlecenieDAO();
        try (FileWriter writer = new FileWriter("Zlecenia.txt")) {
            writer.write("0 0 0 12:00 14:00\n1 1 1 10:00 12:00\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // sprawdzenie czy wpisane w SetUp wartości są prawidłowo odczytywane
    @Tag("Uzyskaj_Elementy")
    @Test
    @Order(1)
    public void testUzyskajWszystkieElementy(){
        ArrayList<Zlecenie> zlecenia = zlecenieDAO.uzyskajWszystkieElementy();

        assertEquals(2, zlecenia.size());
        assertEquals(0, zlecenia.get(0).getZlecenieID());
        assertEquals("12:00", zlecenia.get(0).getCzasRozpoczecia());
        assertEquals("14:00", zlecenia.get(0).getCzasZakonczenia());
        assertEquals(1, zlecenia.get(1).getZlecenieID());
        assertEquals("10:00", zlecenia.get(1).getCzasRozpoczecia());
        assertEquals("12:00", zlecenia.get(1).getCzasZakonczenia());
    }

    // sprawdzenie zachowania metody usunElement() dla poprawnego id
    // podawanego w parametrze z CsvSource
    @Tag("Usun_Istniejacy_Element")
    @ParameterizedTest
    @Order(2)
    @CsvSource({"0", "1"})
    public void testUsunIstniejacyElement(int id){
        int initial_size = zlecenieDAO.uzyskajWszystkieElementy().size();
        zlecenieDAO.usunElement(id);
        ArrayList<Zlecenie> zlecenia = zlecenieDAO.uzyskajWszystkieElementy();
        assertEquals(initial_size - 1, zlecenia.size());
        for(Zlecenie zlecenie : zlecenia){
            assertNotEquals(id, zlecenie.getZlecenieID());
        }
    }

    // sprawdzenie zachowania metody usunElement() dla błędnego id
    // podawanego w parametrze z CsvSource
    @Tag("Usun_NieIstniejacy_Element")
    @ParameterizedTest
    @Order(3)
    @CsvSource({"-13", "100"})
    public void testUsunNieistniejacyElement(int id){
        int initial_size = zlecenieDAO.uzyskajWszystkieElementy().size();
        zlecenieDAO.usunElement(id);
        ArrayList<Zlecenie> zlecenia = zlecenieDAO.uzyskajWszystkieElementy();
        assertEquals(initial_size, zlecenia.size());
        for(Zlecenie zlecenie : zlecenia){
            assertNotEquals(id, zlecenie.getZlecenieID());
        }
    }

    // wyczyszczenie pliku po każdym teście
    @AfterEach
    public void cleanFile(){
        try (FileWriter writer = new FileWriter("Zlecenia.txt")){
            writer.write("");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
