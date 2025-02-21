import java.util.UUID;

public class Ride {
    private String id;
    private Passenger passenger;
    private Driver driver;
    private String pickupLocation;
    private String destination;
    private boolean completed;

    public Ride(Passenger passenger, Driver driver, String pickupLocation, String destination) {
        this.id = UUID.randomUUID().toString();
        this.passenger = passenger;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.completed = false;
    }

    public String getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void completeRide() {
        this.completed = true;
        driver.setAvailable(true); // Освобождаем водителя
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", passenger=" + passenger.getName() +
                ", driver=" + driver.getName() +
                ", from='" + pickupLocation + '\'' +
                ", to='" + destination + '\'' +
                ", completed=" + completed +
                '}';
    }
}
