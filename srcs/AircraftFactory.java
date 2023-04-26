public class AircraftFactory {
    public Flyable[] myFactory;
    public static int id = 0;

    public Flyable[] newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        Flyable[] aircraft = new Flyable[1];

        id++;
        if (p_type.equals("Baloon")) {
            aircraft[0] = new Balloon(id, p_name, p_coordinates);
        }
        else if (p_type.equals("JetPlane")) {
            aircraft[0] = new JetPlane(id, p_name, p_coordinates);
        }
        else if (p_type.equals("Helicopter")) {
            aircraft[0] = new Helicopter(id, p_name, p_coordinates);
        }
        return aircraft;
    }
}