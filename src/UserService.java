import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, Passenger> passengers = new HashMap<>();
    private Map<String, Driver> drivers = new HashMap<>();

    public Passenger registerPassenger(String name, String phoneNumber) {
        String id = generateId();
        Passenger passenger = new Passenger(id, name, phoneNumber);
        passengers.put(id, passenger);
        System.out.println("Passenger registered: " + passenger);
        return passenger;
    }

    public Driver registerDriver(String name, String phoneNumber) {
        String id = generateId();
        Driver driver = new Driver(id, name, phoneNumber);
        drivers.put(id, driver);
        System.out.println("Driver registered: " + driver);
        return driver;
    }

    public Passenger getPassenger(String id) {
        return passengers.get(id);
    }

    public Driver getDriver(String id) {
        return drivers.get(id);
    }

    private String generateId() {
        return "U" + (passengers.size() + drivers.size() + 1);
    }
}
