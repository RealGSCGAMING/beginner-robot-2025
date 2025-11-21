import java.util.Scanner;

public class RobotSim {

    // Create variables to track robot information
    // Ideas:
    // - Battery level (starts at 100, decreases over time)
    // - Distance traveled (in feet or meters)
    // - Game pieces collected
    // - Current robot state (IDLE, MOVING, SCORING, etc.)
    // - Match time remaining

    public static void main(String[] args) {

        int batteryLevel = 100;
        double distance = 0;
        int pieces = 0;
        int steps = 0;
        boolean moving = false;
        int direction = 0;
        boolean carrying = false;
        int type;
        boolean battery = true;
        boolean throwable = false;

        Scanner sc = new Scanner(System.in);

        clearConsole();

        System.out.println("Enter simulation type, or press H for help.");

        while (true) {
            String input = sc.nextLine().toLowerCase();

            if (input.equals("h")) {
                System.out.println(
                        "\nSimulation types:\n[1] Quick simulation: Instantly simulates a certain number of steps\n[2] Manual simulation: Simulates for however long you want, and see live stats");
            }

            else if (input.equals("1")) {
                clearConsole();
                type = 1;
                System.out.println("== Quick Simulation ==\n");
                System.out.println("How many simulation steps would you like to run?");
                while (true) {
                    try {
                        steps = Integer.valueOf(sc.nextLine());
                        if (steps < 1)
                            throw new IndexOutOfBoundsException("hi");
                        break;
                    } catch (Exception e) {
                        if (steps == -1) {
                            battery = false;
                            System.out.println("\nBattery was disabled.");
                            steps = 0;
                        }
                        System.out.println("\nEnter a positive number.");
                    }
                }
                // clearConsole();
                break;
            }

            else if (input.equals("2")) {
                clearConsole();
                System.out.println("== Manual Simulation ==");
                type = 2;
                break;
            }
        }

        System.out.println("\nPress ENTER to begin the simulation.");
        sc.nextLine();
        clearConsole();

        // Create a simulation loop
        // Ideas:
        // - Use a for loop to simulate time passing (e.g., for 15 seconds)
        // - Print updates each "second" showing what the robot is doing
        // - Change variables over time (battery drains, distance increases, etc.)
        // - Add if statements to make decisions (e.g., if battery < 20, print warning)

        int i = 0;

        while (true) {

            if (type == 2)
                System.out.println("-- Simulation Step " + (i + 1) + " --");

            // battery loss
            if (i % 5 == 0 && battery) {
                if (moving) {
                    batteryLevel -= 2;
                } else {
                    batteryLevel--;
                }

                System.out.println("Battery level has decreased.");
            }

            // movement
            if (i % 3 == 0) {
                if (Math.random() * 5 >= 3 && moving) {
                    moving = false;
                    if (type == 2)
                        System.out.println("Robot has stopped moving.");
                }

                else {
                    moving = true;
                    direction = (int) (Math.random() * 3);
                    if (type == 2)
                        System.out.println("Robot is now moving " + directionWord(direction));
                }
            }

            if (moving) {
                distance += 0.5;
                int random = (int) (Math.random() * 3);
                if (random == 0 && carrying == false) {
                    if (type == 2)
                        System.out.println("Robot picked up a game piece.");
                    carrying = true;
                } else if (random == 0 && carrying == true && throwable == false) {
                    carrying = false;
                    throwable = true;
                    //pieces++;
                    if (type == 2)
                        System.out.println("Robot scored the game piece.\nType T to throw it.");

                }
            }

            if (batteryLevel <= 0) {
                if (type == 2)
                    System.out.println("Battery has died!");
                batteryLevel = 0;
                break;
            }

            if (type == 1) {
                if (steps == i + 1) {
                    break;
                }

            }

            if (type == 2) {
                System.out.println("\n-- Current State --");
                System.out.println(moving ? "Moving " + directionWord(direction) : "Not moving");
                System.out.println(carrying ? "Holding game piece" : "Not holding anything");
                System.out.println("Battery level: " + batteryLevel);
                if (throwable) System.out.println("\nThere is a game piece waiting to be thrown! Type T to throw it.");
                System.out.println("\n[Press ENTER to advance simulation, or type Q to quit]");

                String a = sc.nextLine();

                if (a.toLowerCase().equals("q")) {
                    break;
                }

                else if (a.toLowerCase().equals("t") && throwable) {
                    System.out.println("\nYou threw the game piece...");
                    if ((int) (Math.random() * 2) == 1) {
                        System.out.println("You scored!");
                        pieces++;
                        System.out.println("New score: " + pieces);
                    }
                    else {
                        System.out.println("You missed.");
                    }

                    throwable = false;
                    System.out.println("[Press ENTER to advance simulation, or type Q to quit]");
                    sc.nextLine();
                }
            }

            i++;

            if (type == 1 /* && i % 10 == 0 */) {
                System.out.print("\rSimulating... (Current step: " + i + ")");
            }

            if (type == 2)
                clearConsole();

            // reactive wolf gaming
            // waitSecs(1);
            // System.out.println("-");
        }

        // Print final statistics
        // Examples: Total distance traveled, final battery level, game pieces scored,
        // etc.

        clearConsole();

        System.out.println("=== Simulation Complete ===");
        System.out.println("\nFinal stats:");
        System.out.println("Distance traveled: " + distance + " m");
        System.out.println("Score: " + pieces);
        System.out.println(
                battery ? "Battery level: " + batteryLevel + "%\n" : "Battery was disabled for this simulation.\n");
        if (batteryLevel == 0 && type == 1)
            System.out.println("(Simulation ended at " + i
                    + " steps when the battery died. To turn off battery, type -1 for steps input.)\n");

        sc.close();
    }

    public static void waitSecs(int s) {
        try {
            Thread.sleep(s * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String directionWord(int d) {
        if (d == 0) {
            return "North";
        }
        if (d == 1) {
            return "South";
        }
        if (d == 2) {
            return "East";
        }
        if (d == 3) {
            return "West";
        } else {
            return "North";
        }
    }

    public static void clearConsole() {
        System.out.print("\033\143");
    }
}