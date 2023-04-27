package ro.academyplus.avaj.simulator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private static int ERROR = 1;
    private static int numberOfRun;
    private static List<Flyable> flyableArray= new ArrayList<Flyable>();

    private static void launch() {

        WeatherTower weatherTower = new WeatherTower();

        System.out.println("Number of run : " + numberOfRun);

        for (Flyable aircraft : flyableArray) {

            weatherTower.register(aircraft);
            aircraft.registerTower(weatherTower);
        }

        System.out.println("<----- Start simulation ----->");

        for (int a = 1; a <= numberOfRun; a++) {
            System.out.println("<----- Run " + a + " ----->");

            weatherTower.changeWeather();

            System.out.println("--------------------");
        }

        System.out.println("<----- End of the simulation ----->");
    }

    private static void parseFile(String fileName) throws MyException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            if (lines.isEmpty())
                throw new MyException("Error : File is empty.");

            for (int a = 0; a < lines.size(); a++) {

                String[] tokens = lines.get(a).split(" ");

                if (a == 0) {
                    if (tokens.length != 1 || lines.get(a).length() == 0)
                        throw new MyException("Error : The number of simulation is not correct.");
                    numberOfRun = Integer.parseInt(tokens[0]);
                }
                else if (tokens[0].equals("Baloon") || tokens[0].equals("JetPlane") || tokens[0].equals("Helicopter")) {
                    if (tokens.length != 5)
                        throw new MyException("Error : Too much or not enough information in the scenario file.");

                    int longitude = Integer.parseInt(tokens[2]);
                    int latitude = Integer.parseInt(tokens[3]);
                    int height = Integer.parseInt(tokens[4]);

                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new MyException("Error : Coordinates are not correct.");

                    if (height > 100)
                        height = 100;

                    Coordinates coordinates = new Coordinates(longitude, latitude, height);
                    AircraftFactory myFactory = new AircraftFactory();

                    flyableArray.add(myFactory.newAircraft(tokens[0], tokens[1], coordinates));
                }
                else
                    throw new MyException("Error : Type is not correct.");
            }

        } catch (InvalidPathException e) {
            throw new MyException("Error : File name is not correct.");
        } catch (NumberFormatException e) {
            throw new MyException("Error : Characters are not valid for coordinates.");
        } catch (IOException e) {
            throw new MyException("Error : Path of the scenario file is not correct.");
        } catch (MyException e) {
            throw new MyException(e.getMessage()); 
        }
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Error : Too much or not enough arguments are given.");
            System.exit(ERROR);
        }

        String fileName = new String(args[0]);

            try {
                PrintStream out = new PrintStream(new FileOutputStream("simulation.txt"));
                System.setOut(out);
            
                parseFile(fileName);
                launch();

            } catch (FileNotFoundException e) {
                System.out.println("Error : File not found.");
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
    }
}
