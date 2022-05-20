package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Status;
import game.actions.RangedAttackAction;

import java.util.ArrayList;
import java.util.List;

public abstract class RangedWeapon extends Item implements Weapon {
    protected ActionList shootActions = new ActionList();

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public RangedWeapon(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
    }

    public abstract int getRange();

    /**
     * Each turn, it needs to recalculate the people it can shoot because they all moved.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        shootActions.clear();
        shootActions.add(dfsAddEnemies(currentLocation, 0, new ArrayList<Location>()));
    }

    @Override
    public List<Action> getAllowableActions() {
        return this.shootActions.getUnmodifiableActionList();
    }

    private ActionList dfsAddEnemies(Location currentLocation, int curDepth, ArrayList<Location> visited) {
        ActionList ret = new ActionList();
        // Base case
        if (curDepth == getRange()+1) {
            // Empty action list
            return new ActionList();
        }
        if (currentLocation.containsAnActor()) {
            Actor toBeAttacked = currentLocation.getActor();
            // Without this you can probably kill princess peach and toad.
            if (toBeAttacked.hasCapability(Status.HOSTILE_TO_PLAYER)) {
                ret.add(new RangedAttackAction(toBeAttacked, this));
            }
        }

        visited.add(currentLocation);
        for (Exit exit: currentLocation.getExits()) {
            Location destination = exit.getDestination();
            if (visited.contains(destination) || destination.getGround().blocksThrownObjects()) {
                continue;
            }
            ret.add(dfsAddEnemies(destination, curDepth+1, visited));
        }
        return ret;
    }

    /**
     * The default damage dealt by ranged weapons.
     * @return 40
     */
    @Override
    public int damage() {
        return 40;
    }

    /**
     * The default sound effect of Ranged weapon
     * @return shoots
     */
    @Override
    public String verb() {
        return "shoots";
    }

    /**
     * The default hit chance of Ranged Weapon
     * @return 100
     */
    @Override
    public int chanceToHit() {
        return 100;
    }

}
