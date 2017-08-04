package phone;

public class Network {
    private static Phone[] database = new Phone[15];

    public static void addNumber(Phone phone) {
        for (int i = 0; i < database.length; i++) {
            if (database[i] == null) {
                database[i] = phone;
                break;
            }
        }
    }

    public static boolean isNumberPresent (String number) {
        for (int i = 0; i < database.length; i++) {
            if (database[i] != null)
                if (database[i].getNumber().equals(number))
                    return true;
        }
        return false;
    }

    public static void transfer(String number) {
        for (int i = 0; i < database.length; i++) {
            if (database[i].getNumber().equals(number)) {
                database[i].receiveCall();
                return;
            }
        }
    }
}
