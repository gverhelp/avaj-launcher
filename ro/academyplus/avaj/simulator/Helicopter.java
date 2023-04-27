package ro.academyplus.avaj.simulator;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        int superHeight = super.coordinates.getHeight();
        int superLongitude = super.coordinates.getLongitude();
        
        switch (weather) {
            case "RAIN":
                super.coordinates.setLongitude(superLongitude + 5);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Rain");
                break;
            case "FOG":
                super.coordinates.setLongitude(superLongitude + 1);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Fog");
                break;
            case "SUN":
                super.coordinates.setLongitude(superLongitude + 10);
                super.coordinates.setHeight(superHeight + 2);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Sun");
                break;
            case "SNOW":
                super.coordinates.setHeight(superHeight - 12);
                System.out.println("Helicopter#" + super.name + "(" + super.id + ")" + ": Snow");
                break;
        }
    }

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