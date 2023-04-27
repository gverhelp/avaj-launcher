package ro.academyplus.avaj.simulator;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinate) {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        int superHeight = super.coordinates.getHeight();
        int superLatitude = super.coordinates.getLatitude();
        
        switch (weather) {
            case "RAIN":
                super.coordinates.setLatitute(superLatitude + 5);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Rain");
                break;
            case "FOG":
                super.coordinates.setLatitute(superLatitude + 1);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Fog");
                break;
            case "SUN":
                super.coordinates.setLatitute(superLatitude + 10);
                super.coordinates.setHeight(superHeight + 2);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Sun");
                break;
            case "SNOW":
                super.coordinates.setHeight(superHeight - 7);
                System.out.println("JetPlane#" + super.name + "(" + super.id + ")" + ": Snow");
                break;
        }
    }

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