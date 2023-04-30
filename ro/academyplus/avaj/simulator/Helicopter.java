package ro.academyplus.avaj.simulator;

public class Helicopter extends Aircraft {

    // Public Constructor
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    // Public methods
    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        int superHeight = super.coordinates.getHeight();
        int superLongitude = super.coordinates.getLongitude();
        
        switch (weather) {
            case "RAIN":
                super.coordinates.setLongitude(superLongitude + 5);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Why do cows love the rain? Because it's udderly refreshing!");
                break;
            case "FOG":
                super.coordinates.setLongitude(superLongitude + 1);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Why did the fog go to school? To get a higher degree!");
                break;
            case "SUN":
                super.coordinates.setLongitude(superLongitude + 10);
                super.coordinates.setHeight(superHeight + 2);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Why did the sun go to school? To get brighter!");
                break;
            case "SNOW":
                super.coordinates.setHeight(superHeight - 12);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Why was the math book sad on a snow day? Because it had too many problems!");
                break;
        }
    }

    // Public methods (Override)
    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getType() {
        return "Helicopter";
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}