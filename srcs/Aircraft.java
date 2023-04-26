public class Aircraft implements Flyable {
    // Protected attributes
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    // Constructor method (Protected)
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() {
        throw new UnsupportedOperationException("Unimplemented method 'updateConditions'");
    }

    @Override
    public void registerTower(WeatherTower[] p_tower) {
        throw new UnsupportedOperationException("Unimplemented method 'registerTower'");
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCoordinates() {
        return this.coordinates;
    }
}