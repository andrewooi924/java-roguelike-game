package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.TeleportAction;
import game.injectors.LocationInjector;

import java.util.HashMap;
import java.util.List;

public class WarpPipe extends HigherGround {

    private final HashMap<String, Location> locations;

    /**
     * Constructor.
     *
     */
    public WarpPipe() {
        super('C');
        locations = LocationInjector.getLocations();
    }

    @Override
    public int getFallDamageRate() {
        return 0;
    }

    @Override
    public double getFallProb() {
        return 1;
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

        // checking if the pipe has a location to go
        if (direction.isEmpty()) {
            String key = location.map() + "x:" + location.x() + "y:" + location.y();
            Location locationToTravel = locations.get(key);

            // it may be a broken pipe
            if (actor.hasCapability(Status.CAN_TELEPORT) && locationToTravel != null) {
                Location actualLocation = locationToTravel.map().at(locationToTravel.x(), locationToTravel.y());
                lst.add(new TeleportAction(actualLocation));
                LocationInjector.addLocation(actualLocation, location); // remembers the location from the pipe
            }
        }
        return lst;
    }
}
