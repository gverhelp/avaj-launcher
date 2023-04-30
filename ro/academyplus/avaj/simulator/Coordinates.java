package ro.academyplus.avaj.simulator;

public class Coordinates {
    
    // Private attributes
    private int longitude;
    private int latitude;
    private int height;
    
    // Constructor
    Coordinates(int p_longitude, int p_latitude, int p_height) {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    // Public methods
    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public void setLongitude(int p_longitude) {
        this.longitude = p_longitude;
    }

    public void setLatitute(int p_latitude) {
        this.latitude = p_latitude;
    }

    public void setHeight(int p_height) {
        this.height = p_height > 100 ? 100 : p_height;
    }
}