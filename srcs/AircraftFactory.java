public class AircraftFactory {
    public Flyable[] newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        if (p_type.contains("Baloon")) {
            Flyable b = new Balloon(1, p_name, p_coordinates);

        }
        return null;
    }
}