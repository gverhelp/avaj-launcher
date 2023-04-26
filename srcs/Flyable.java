public interface Flyable {
    // Protected attributes
    //protected WeatherTower weatherTower;

    public abstract void updateConditions();

    // Public methods
    public void registerTower(WeatherTower[] p_tower);
}