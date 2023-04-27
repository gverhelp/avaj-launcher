package ro.academyplus.avaj.simulator;

public class Balloon extends Aircraft {
    public Balloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        int superHeight = super.coordinates.getHeight();
        int superLongitude = super.coordinates.getLongitude();
        
        switch (weather) {
            case "RAIN":
                super.coordinates.setHeight(superHeight - 5);
                System.out.println("Balloon#" + super.name + "(" + super.id + ")" + ": Rain");
                break;
            case "FOG":
                super.coordinates.setHeight(superHeight - 3);
                System.out.println("Balloon#" + super.name + "(" + super.id + ")" + ": Fog");
                break;
            case "SUN":
                super.coordinates.setHeight(superHeight + 4);
                super.coordinates.setLongitude(superLongitude + 2);
                System.out.println("Balloon#" + super.name + "(" + super.id + ")" + ": Sun");
                break;
            case "SNOW":
                super.coordinates.setHeight(superHeight - 15);
                System.out.println("Balloon#" + super.name + "(" + super.id + ")" + ": Snow");
                break;
        }
    }

    @Override
    public long getId() {
        return super.id;
    }

    @Override
    public String getType() {
        return "Balloon";
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