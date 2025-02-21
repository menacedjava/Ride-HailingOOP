import java.util.Scanner;

public class Application {
    private static UserService userService = new UserService();
    private static RideService rideService = new RideService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Ride-Hailing App!");

        while (true) {
            System.out.println("\n1. Register Passenger");
            System.out.println("2. Register Driver");
            System.out.println("3. Request Ride");
            System.out.println("4. Show Ride History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPassenger();
                    break;
                case 2:
                    registerDriver();
                    break;
                case 3:
                    requestRide();
                    break;
                case 4:
                    showRideHistory();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void registerPassenger() {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        userService.registerPassenger(name, phone);
    }

    private static void registerDriver() {
        System.out.print("Enter driver name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        Driver driver = userService.registerDriver(name, phone);
        rideService.addDriver(driver);
    }

    private static void requestRide() {
        System.out.print("Enter passenger ID: ");
        String passengerId = scanner.nextLine();
        Passenger passenger = userService.getPassenger(passengerId);

        if (passenger == null) {
            System.out.println("Passenger not found!");
            return;
        }

        System.out.print("Enter pickup location: ");
        String pickup = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        Ride ride = rideService.requestRide(passenger, pickup, destination);

        if (ride != null) {
            System.out.println("Your ride is on the way!");
        }
    }

    private static void showRideHistory() {
        for (Ride ride : rideService.getRideHistory()) {
            System.out.println(ride);
        }
    }
}
