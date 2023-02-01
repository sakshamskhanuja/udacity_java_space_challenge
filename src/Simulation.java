import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    /**
     * Loads a list of {@link Item} from a File.
     *
     * @param file Contains items to carry.
     * @return A list of items.
     */
    private ArrayList<Item> loadItems(File file) {
        // Stores items.
        ArrayList<Item> items = new ArrayList<>();
        if (file.exists()) {
            try {
                // Scans the items.
                Scanner scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    String[] contentArray = scanner.nextLine().split("=");

                    // Adding item to items.
                    items.add(new Item(contentArray[0], Integer.parseInt(contentArray[1])));
                }

                // Closes the scanner.
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
        }
        return items;
    }

    /**
     * Creates a fleet of rocket {@link U1}.
     *
     * @param items Items to be carried by rocket.
     * @return A list of U1 Rockets.
     */
    private ArrayList<U1> loadU1(ArrayList<Item> items) {
        // Stores filled U1 rockets.
        ArrayList<U1> u1s = new ArrayList<>();

        // Loading a U1 rocket.
        U1 u1 = new U1();

        // Creating a U1 Rocket fleet.
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (u1.canCarry(item)) {
                u1.carry(item);
            } else {
                u1s.add(u1);
                u1 = new U1();
                i--;
            }

            if (i == items.size() - 1) {
                u1s.add(u1);
            }
        }
        return u1s;
    }

    /**
     * Creates a fleet of rocket {@link U2}.
     *
     * @param items Items to be carried by rocket.
     * @return A list of U2 Rockets.
     */
    private ArrayList<U2> loadU2(ArrayList<Item> items) {
        // Stores filled U1 rockets.
        ArrayList<U2> u2s = new ArrayList<>();

        // Loading a U2 rocket.
        U2 u2 = new U2();

        // Creating a U2 Rocket fleet.
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);

            if (u2.canCarry(item)) {
                u2.carry(item);
            } else {
                u2s.add(u2);
                u2 = new U2();
                i--;
            }

            if (i == items.size() - 1) {
                u2s.add(u2);
            }
        }
        return u2s;
    }

    /**
     * Runs the simulation.
     */
    public void runSimulation() {
        System.out.println("Loading items for Phase 1.");
        ArrayList<Item> phase1Items = loadItems(new File("Phase1.txt"));

        System.out.println("Items loaded.\n\nLoading items for Phase 2.");
        ArrayList<Item> phase2Items = loadItems(new File("Phase2.txt"));

        System.out.println("Items loaded.\n\nCreating fleet of U1 Rockets for Phase 1.");
        ArrayList<U1> fleetU1Phase1 = loadU1(phase1Items);

        System.out.println("Fleet for Phase 1 ready.\n\nCreating fleet of U1 Rockets for Phase 2.");
        ArrayList<U1> fleetU1Phase2 = loadU1(phase2Items);

        System.out.println("Fleet for Phase 2 ready.\n\nSending U1 Rocket fleet for Phase 1.\n");

        // Stores the entire budget of fleet U1 for phase 1 and phase 2.
        double budgetU1;

        // Sending fleet U1 for Phase 1.
        budgetU1 = sendFleetU1(fleetU1Phase1);
        System.out.println("\nTotal budget spent to send U1 fleet under Phase 1 = " + budgetU1);

        System.out.println("\nSending U1 Rocket fleet for Phase 2.\n");

        // Sending fleet U1 for Phase 2.
        budgetU1 = sendFleetU1(fleetU1Phase2);
        System.out.println("\nTotal budget spent to send U1 fleet under Phase 2 = " + budgetU1);

        System.out.println("\nCreating fleet of U2 Rockets for Phase 1.");
        ArrayList<U2> fleetU2Phase1 = loadU2(phase1Items);

        System.out.println("Fleet for Phase 1 ready.\n\nCreating fleet of U2 Rockets for Phase 2.");
        ArrayList<U2> fleetU2Phase2 = loadU2(phase2Items);

        System.out.println("Fleet for Phase 2 ready.\n\nSending U2 Rocket fleet for Phase 1.\n");

        // Stores the entire budget of fleet U2 for phase 1 and phase 2.
        double budgetU2;

        // Sending fleet U2 for Phase 1.
        budgetU2 = sendFleetU2(fleetU2Phase1);
        System.out.println("\nTotal budget spent to send U2 fleet under Phase 1 = " + budgetU2);

        System.out.println("\nSending U2 Rocket fleet for Phase 2.\n");

        // Sending fleet U1 for Phase 2.
        budgetU2 = sendFleetU2(fleetU2Phase2);
        System.out.println("\nTotal budget spent to send U2 fleet under Phase 2 = " + budgetU2);
    }

    /**
     * Sends a fleet of {@link U2} Rockets.
     */
    private double sendFleetU2(ArrayList<U2> fleet) {
        double budget = 0;
        for (int i = 0; i < fleet.size(); i++) {
            U2 u2 = fleet.get(i);
            System.out.print("Sending Rocket " + (i + 1) + " -> ");

            // Updating budget.
            budget += u2.getCost();

            if (u2.launch()) {
                System.out.print("Launch Successful -> ");
                if (u2.land()) {
                    System.out.println("Landing Successful");
                } else {
                    System.out.println("Rocket crashed during landing.");
                    i--;
                }
            } else {
                System.out.println("Rocket exploded during launch. Sending again.");
                i--;
            }
        }
        return budget;
    }

    /**
     * Sends a fleet of {@link U1} Rockets.
     */
    private double sendFleetU1(ArrayList<U1> fleet) {
        double budget = 0;
        for (int i = 0; i < fleet.size(); i++) {
            U1 u1 = fleet.get(i);
            System.out.print("Sending Rocket " + (i + 1) + " -> ");

            // Updating budget.
            budget += u1.getCost();

            if (u1.launch()) {
                System.out.print("Launch Successful -> ");
                if (u1.land()) {
                    System.out.println("Landing Successful");
                } else {
                    System.out.println("Rocket crashed during landing.");
                    i--;
                }
            } else {
                System.out.println("Rocket exploded during launch. Sending again.");
                i--;
            }
        }
        return budget;
    }
}
