import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Not enough arguments are given.");
            System.exit(1);
        }

        String fileName = args[0];
        File file = new File(fileName);

        parseFile(file);
    }

    public static void parseFile(File file) {
        try (Scanner scanner = new Scanner(file)) {

            int countLines = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");

                if (countLines == 0) {
                    countLines++;
                    if (tokens.length != 1 || line.length() == 0) {
                        throw new Exception("Number of simulation error."); 
                    }
                    int runs = Integer.parseInt(tokens[0]);
                }
                else if (tokens[0].equals("Baloon") || tokens[0].equals("JetPlane") || tokens[0].equals("Helicopter")) {
                    int longitude = Integer.parseInt(tokens[2]);
                    int latitude = Integer.parseInt(tokens[3]);
                    int height = Integer.parseInt(tokens[4]);
                    countLines++;

                    if (longitude < 0 || latitude < 0 || height < 0)
                        throw new Exception("Coordinates error.");
                    if (height > 100)
                        height = 100;

                    Coordinates coordinates = new Coordinates(longitude, latitude, height);
                }
                else {
                    throw new Exception("Type error.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File name error.");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
