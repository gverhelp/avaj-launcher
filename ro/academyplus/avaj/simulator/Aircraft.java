package ro.academyplus.avaj.simulator;

public abstract class Aircraft extends Flyable {

    // Protected attributes
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    // Protected Constructor
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    // Public methods (Override)
    @Override
    public abstract void updateConditions();

    @Override
    public abstract long getId();

    @Override
    public abstract String getType();

    @Override
    public abstract String getName();

    @Override
    public abstract Coordinates getCoordinates();
}