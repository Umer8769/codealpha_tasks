package Task_4;

import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        while (true) {
            System.out.println("\n1. View Rooms\n2. Book Room\n3. Cancel Booking\n4. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                for (Room r : rooms) {
                    System.out.println(r.roomNumber + " - " + r.category + " - " + (r.isBooked ? "Booked" : "Available"));
                }
            }

            else if (choice == 2) {
                System.out.print("Enter room number: ");
                int num = sc.nextInt();
                for (Room r : rooms) {
                    if (r.roomNumber == num && !r.isBooked) {
                        r.isBooked = true;
                        System.out.println("Room booked successfully!");
                    }
                }
            }

            else if (choice == 3) {
                System.out.print("Enter room number: ");
                int num = sc.nextInt();
                for (Room r : rooms) {
                    if (r.roomNumber == num && r.isBooked) {
                        r.isBooked = false;
                        System.out.println("Booking cancelled!");
                    }
                }
            }

            else break;
        }

        sc.close();
    }
}
