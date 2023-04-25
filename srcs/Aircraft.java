public class Aircraft extends Flyable
{
    // Protected attributes
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    // Constructor method (Protected)
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    public void updateConditions() {}
}