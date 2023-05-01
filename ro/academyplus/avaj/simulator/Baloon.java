package ro.academyplus.avaj.simulator;

public class Baloon extends Aircraft {

    // Public Constructor
    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    // Public methods
    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        int superHeight = super.coordinates.getHeight();
        int superLongitude = super.coordinates.getLongitude();
        
        switch (weather) {
            case "RAIN":
                super.coordinates.setHeight(superHeight - 5);
                System.out.println("Baloon#" + super.name + "(" + super.id + ")" + ": Why do cows love the rain? Because it's udderly refreshing!");
                break;
            case "FOG":
                super.coordinates.setHeight(superHeight - 3);
                System.out.println("Baloon#" + super.name + "(" + super.id + ")" + ": Why did the fog go to school? To get a higher degree!");
                break;
            case "SUN":
                super.coordinates.setHeight(superHeight + 4);
                super.coordinates.setLongitude(superLongitude + 2);
                System.out.println("Baloon#" + super.name + "(" + super.id + ")" + ": Why did the sun go to school? To get brighter!");
                break;
            case "SNOW":
                super.coordinates.setHeight(superHeight - 15);
                System.out.println("Baloon#" + super.name + "(" + super.id + ")" + ": Why was the math book sad on a snow day? Because it had too many problems!");
                break;
        }
    }

    // Public methods (Override)
    @Override
    public long getId() {
        return super.id;
    }

    @Override
    public String getType() {
        return "Baloon";
    }

    @Override
    public String getName() {
        return super.name;
    }

    @Override
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
}