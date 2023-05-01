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
    private static List<Flyable> flyableArray = new ArrayList<Flyable>();

    private static void launch() {

        WeatherTower weatherTower = new WeatherTower();

        for (Flyable aircraft : flyableArray) {

            weatherTower.register(aircraft);
            aircraft.registerTower(weatherTower);
        }

        for (int a = 0; a < numberOfRun; a++)
            weatherTower.changeWeather();
    }

    private static void parseFile(String fileName) throws MyException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            AircraftFactory myFactory = new AircraftFactory();

            if (lines.isEmpty())
                throw new MyException("Error : File is empty.");

            for (int a = 0; a < lines.size(); a++) {

                String[] tokens = lines.get(a).split(" ");

                if (a == 0) {
                    if (tokens.length != 1 || lines.get(a).length() == 0)
                        throw new MyException("Error : The number of run is missing or not correct.");
                    numberOfRun = Integer.parseInt(tokens[0]);
                }
                else if (tokens[0].equals("Baloon") || tokens[0].equals("JetPlane") || tokens[0].equals("Helicopter")) {
                    if (tokens.length != 5)
                        throw new MyException("Error : Too much or not enough information in the scenario file.");

                    int longitude = Integer.parseInt(tokens[2]);
                    int latitude = Integer.parseInt(tokens[3]);
                    int height = Integer.parseInt(tokens[4]);

                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new MyException("Error : Coordinates can not be negative.");

                    if (height > 100)
                        height = 100;

                    Coordinates coordinates = new Coordinates(longitude, latitude, height);

                    flyableArray.add(myFactory.newAircraft(tokens[0], tokens[1], coordinates));
                }
                else
                    throw new MyException("Error : Aircraft type is not correct.");
            }

        } catch (InvalidPathException e) {
            throw new MyException("Error : File name is not correct.");
        } catch (NumberFormatException e) {
            throw new MyException("Error : Some characters are not valid.");
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
