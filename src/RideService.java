import java.util.ArrayList;
import java.util.List;

public class RideService {
    private List<Ride> rides = new ArrayList<>();
    private List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Ride requestRide(Passenger passenger, String pickup, String destination) {
        Driver availableDriver = findAvailableDriver();
        if (availableDriver == null) {
            System.out.println("No available drivers at the moment.");
            return null;
        }

        Ride ride = new Ride(passenger, availableDriver, pickup, destination);
        rides.add(ride);
        availableDriver.setAvailable(false); // Водитель теперь занят

        System.out.println("Ride booked: " + ride);
        return ride;
    }

    private Driver findAvailableDriver() {
        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                return driver;
            }
        }
        return null;
    }

    public List<Ride> getRideHistory() {
        return rides;
    }
}
