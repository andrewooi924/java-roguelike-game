package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.TeleportAction;
import game.actors.PiranhaPlant;
import game.managers.TeleportPointsManager;
import game.reset.Resettable;

import java.util.HashMap;

public class WarpPipe extends HigherGround implements Resettable {

    private int age = 0;

    /**
     * Constructor.
     *
     */
    public WarpPipe() {
        super('C');
        registerInstance();
    }

    @Override
    public int getFallDamageRate() {
        return 10;
    }

    @Override
    public double getFallProb() {
        return 0.9;
    }

    /**
     * Returns an empty Action list.
     *
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a new, empty collection of Actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList lst = super.allowableActions(actor, location, direction);

        // getting all the locations
        TeleportPointsManager teleportPointsManager = TeleportPointsManager.getInstance();
        HashMap<String, Location> locations = teleportPointsManager.getLocations();


        // checking if the pipe has a location to go
        if (direction.isEmpty()) {
            String key = location.map() + "x:" + location.x() + "y:" + location.y();
            Location locationToTravel = locations.get(key);

            // it may be a broken pipe
            if (actor.hasCapability(Status.CAN_TELEPORT) && locationToTravel != null) {
                Location actualLocation = locationToTravel.map().at(locationToTravel.x(), locationToTravel.y());
                lst.add(new TeleportAction(actualLocation));
                teleportPointsManager.addLocation(actualLocation, location); // remembers the location from the pipe
            }
        }
        return lst;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        age++;
        if (this.hasCapability(Status.RESETTABLE)) {
            this.age = 0;
            this.removeCapability(Status.RESETTABLE);
        }
        if (age == 1 && !location.containsAnActor())
            location.addActor(new PiranhaPlant());
    }

    @Override
    public String toString() {
        return "Warp Pipe";
    }

    /**
     * Adds the RESETTABLE capability to this instance
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESETTABLE);
    }
}
