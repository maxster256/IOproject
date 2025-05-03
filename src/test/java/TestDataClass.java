
public class TestDataClass {

    // dane logowania istniejących uzytkowników
    public String logData[][] = {
            {"kierowca1", "12345", "1"},
            {"kierowca2", "qwerty", "1"},
            {"spedytor1", "zxcv", "3"},
            {"kierownik1", "wasd", "2"}
    };

    // dane logowania niestniejących uzytkowników
    // lub z błędnym hasłem/rolą
    public String wrongLogData[][] = {
            {"kierowca5", "12345", "1"},
            {"administrator", "qwerty", "1"},
            {"spedytor1", "zxcv", "2"},
            {"kierownik1", "d", "2"}
    };

    // zlecenia nieprzekraczające czasu pracy kierowcy
    public String orderData[][] = { // ponizej 4 godzin
            {"10:00", "12:00"},
            {"8:00", "9:00"},
            {"19:00", "22:00"},
            {"23:00", "3:00"}
    };

    // zlecenia przekraczające czas pracy kierowcy
    public String wrongOrderData[][] = { // powyzej 4 godzin
            {"10:50", "14:55"},
            {"18:00", "22:01"},
            {"19:00", "2:00"},
            {"10:00", "20:00"}
    };
}
