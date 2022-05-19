package game.items;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropItemAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.Status;
import game.actions.AttackAction;
import game.actions.ConsumeAction;
import game.actions.RangedAttackAction;

import java.util.ArrayList;
import java.util.List;

/**
 * A weapon used to fire arrows, useless without arrows.
 */
public class Bow extends Item implements Weapon, Craftable {

    // Assume infinite arrows for now...
    // ArrayList<Arrow> arrows;

    /**
     * ActionList containing all the actions for Bow
     */
    // Unfortunately the one in Item isn't public.
    protected ActionList bowActions = new ActionList();

    /**
     * The range of the Bow
     */
    private final int BOW_RANGE = 5;

    /**
     * Constructor.
     */
    public Bow() {
        super("Bow", '>', true);
    }

    /**
     * Each turn, it needs to recalculate the people it can shoot because they all moved.
     * @param currentLocation The location of the actor carrying this Item.
     * @param actor The actor carrying this Item.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        bowActions.clear();
        bowActions.add(bfsAddEnemies(currentLocation, 0, new ArrayList<Location>()));
        // this.addAction(new AttackAction(, this));
    }

    @Override
    public List<Action> getAllowableActions() {
        return this.bowActions.getUnmodifiableActionList();
    }

    private ActionList bfsAddEnemies(Location currentLocation, int curDepth, ArrayList<Location> visited) {
        ActionList ret = new ActionList();
        // Base case
        if (curDepth == BOW_RANGE) {
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
            if (visited.contains(destination)) {
                continue;
            }
            ret.add(bfsAddEnemies(destination, curDepth+1, visited));
        }
        return ret;
    }

    /**
     * The damage dealt by Bow (requires arrows)
     * @return 40
     */
    @Override
    public int damage() {
        return 40;
    }

    /**
     * The sound effect of Bow
     * @return shoots
     */
    @Override
    public String verb() {
        return "shoots";
    }

    /**
     * The hit chance of Bow
     * @return 100
     */
    @Override
    public int chanceToHit() {
        return 100;
    }

    /**
     * Returns the recipe for crafting Bow
     * @return the recipe for crafting Bow
     */
    @Override
    public Material getRecipe(){
        return new Wood(5);
    }

    /**
     * Getter for Bow
     * @return Bow
     */
    @Override
    public Item getCrafted(){
        return this;
    }
}
