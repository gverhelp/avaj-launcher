package ro.academyplus.avaj.simulator;

public class JetPlane extends Aircraft {

    // Public Constructor
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    // Public methods
    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        int superHeight = super.coordinates.getHeight();
        int superLatitude = super.coordinates.getLatitude();
        
        switch (weather) {
            case "RAIN":
                super.coordinates.setLatitute(superLatitude + 5);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Why do cows love the rain? Because it's udderly refreshing!");
                break;
            case "FOG":
                super.coordinates.setLatitute(superLatitude + 1);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Why did the fog go to school? To get a higher degree!");
                break;
            case "SUN":
                super.coordinates.setLatitute(superLatitude + 10);
                super.coordinates.setHeight(superHeight + 2);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Why did the sun go to school? To get brighter!");
                break;
            case "SNOW":
                super.coordinates.setHeight(superHeight - 7);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Why was the math book sad on a snow day? Because it had too many problems!");
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
        return "JetPlane";
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