public class Coordinates {
    // Private attributes
    private int longitude;
    private int latitude;
    private int height;
    
    // Constructor method
    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    // Public methods
    public int getLongitude() { return this.longitude; }

    public int getLatitude() { return this.latitude; }

    public int getHeight() { return this.height; }
}