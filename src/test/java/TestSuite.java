import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

// przyklad wykonania serii testow przy uzyciu Suite
// wykonuje wszystkie testy klas TestZlecenieDAO i TestPrzydzielanieZlecenia
// poza jednym testem sprawdzającym metodę UzyskajWszystkieElementy()
@Suite
@SelectClasses({TestZlecenieDAO.class, TestPrzydzielanieZlecenia.class})
@ExcludeTags("Uzyskaj_Elementy")
public class TestSuite {
}