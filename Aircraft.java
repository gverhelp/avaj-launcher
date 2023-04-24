public class Aircraft extends Flyable
{
    // Protected attributes
    protected int id;
    protected String name;
    protected Coordinate coordinates;

    // Constructor method (Protected)
    protected Aircraft(long p_id, String p_name, Coordinate p_coordinate)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }
}