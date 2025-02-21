public class Driver extends User {
    private boolean available;

    public Driver(String id, String name, String phoneNumber) {
        super(id, name, phoneNumber);
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return super.toString() + " [Driver, " + (available ? "Available" : "Busy") + "]";
    }
}
