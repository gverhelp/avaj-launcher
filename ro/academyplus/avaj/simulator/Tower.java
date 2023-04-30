package ro.academyplus.avaj.simulator;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    
    // Protected attributes
    private List<Flyable> observers = new ArrayList<Flyable>();

    // Protected methods
    protected void conditionChanged() {
        for (int b = 0; b < observers.size(); b++) {

            observers.get(b).updateConditions();

            if (observers.get(b).getCoordinates().getHeight() <= 0) {
                unregister(observers.get(b));
            }
        }
    }

    // Public methods
    public void register(Flyable p_flyable) {
        observers.add(p_flyable);
        System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        observers.remove(p_flyable);
        System.out.println(p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " landing.");
        System.out.println("Tower says: " + p_flyable.getType() + "#" + p_flyable.getName() + "(" + p_flyable.getId() + ")" + " unregistered to weather tower.");
    }
}