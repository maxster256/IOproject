import mockit.*;
import mockit.integration.junit5.JMockitExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(JMockitExtension.class)
public class TestLogowanie {

	TestDataClass helper = new TestDataClass();

	@Tested
	private PortDoPrezentera portDoPrezentera;

	// sprawdzenie procesu logowania dla poprawnych danych
	// dane są pobierane z klasy TestDataClass
	@Tag("Logowanie_Poprawne")
	@Test
	@Order(1)
	public void testZalogujPoprawneDane() {
		boolean result;
		for(int i=0;i<helper.logData.length;i++){
			result = portDoPrezentera.Zaloguj(
					helper.logData[i][0],
					helper.logData[i][1],
					Integer.parseInt(helper.logData[i][2]));
			assertTrue(result);
		}
	}

	// sprawdzenie procesu logowania dla błędnych danych
	// dane są pobierane z klasy TestDataClass
	@Tag("Logowanie_Bledne")
	@Test
	@Order(2)
	public void testZalogujBledneDane() {
		boolean result;
		for(int i=0;i<helper.logData.length;i++){
			result = portDoPrezentera.Zaloguj(
					helper.wrongLogData[i][0],
					helper.wrongLogData[i][1],
					Integer.parseInt(helper.wrongLogData[i][2]));
			assertFalse(result);
		}
	}
}
