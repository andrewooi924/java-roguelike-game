package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.TeleportAction;
import game.actors.PiranhaPlant;
import game.managers.TeleportPointsManager;
import game.reset.Resettable;

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

        // checking if the actor is on the pipe and can teleport
        if (direction.isEmpty() && actor.hasCapability(Status.CAN_TELEPORT)) {
            TeleportPointsManager teleportPointsManager = TeleportPointsManager.getInstance();
            Location locationToTravel = teleportPointsManager.findLocationToTravel(location);

            // it may be a broken pipe
            if (locationToTravel != null) {
                lst.add(new TeleportAction(locationToTravel));
                teleportPointsManager.addLocation(locationToTravel, location); // remembers the location from the pipe
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
