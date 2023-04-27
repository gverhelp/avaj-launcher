package ro.academyplus.avaj.simulator;

public abstract class Flyable {
    // Protected attributes
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    // Public methods
    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }

    public abstract long getId();

    public abstract String getType();

    public abstract String getName();

    public abstract Coordinates getCoordinates();
}