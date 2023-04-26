import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulator {
    public static int numberOfRun;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Error : Too much or not enough arguments are given.");
            System.exit(1);
        }


        String fileName = args[0];
        File file = new File(fileName);

        parseFile(file);
    }

    // public static void launch(String type, String name, Coordinates coordinates) {
    //     AircraftFactory myFactory = new AircraftFactory();
    //     myFactory.newAircraft(type, name, coordinates);
    // }

    public static void parseFile(File file) {
        try (Scanner scanner = new Scanner(file)) {

            int countLines = -1;
            ArrayList<Flyable[]> myFlyableArray = new ArrayList<Flyable[]>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                countLines++;

                if (countLines == 0) {
                    if (tokens.length != 1 || line.length() == 0) {
                        scanner.close();
                        throw new Exception("Error : The number of simulation is not correct."); 
                    }
                    numberOfRun = Integer.parseInt(tokens[0]);
                }
                else if (tokens[0].equals("Baloon") || tokens[0].equals("JetPlane") || tokens[0].equals("Helicopter")) {
                    if (tokens.length != 5) {
                        scanner.close();
                        throw new Exception("Error : Too much or not enough information in the scenario file.");
                    }

                    int longitude = Integer.parseInt(tokens[2]);
                    int latitude = Integer.parseInt(tokens[3]);
                    int height = Integer.parseInt(tokens[4]);

                    if (longitude < 0 || latitude < 0 || height < 0) {
                        scanner.close();
                        throw new Exception("Error : Coordinates are not correct.");
                    }

                    if (height > 100)
                        height = 100;

                    Coordinates coordinates = new Coordinates(longitude, latitude, height);
                    AircraftFactory myFactory = new AircraftFactory();

                    myFlyableArray.add(myFactory.newAircraft(tokens[0], tokens[1], coordinates));
                    //launch(tokens[0], tokens[1], coordinates);
                }
                else {
                    scanner.close();
                    throw new Exception("Error : Type is not correct.");
                }
            }

            // for (Flyable[] aircrafts : myFlyableArray) {
            //     for (Flyable aircraft : aircrafts) {
            //         System.out.println(aircraft);
            //     }
            // }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error : File name is not correct.");
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }
}
