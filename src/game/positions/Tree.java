package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.reset.Resettable;
import game.Status;
import game.actions.JumpActorAction;
import game.actors.Goomba;
import game.actors.Koopa;
import game.items.Coin;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represents a Tree (a type of Ground, at any part of its growth cycle) in the game.
 */
public class Tree extends HigherGround implements Resettable {
    private int age;
    private Random random;
    TreeState treeState;

    /**
     * Constructor.
     */
    public Tree() {
        super('+');
        this.age = 0;
        this.treeState = TreeState.SPROUT;
        this.random = new Random();
        this.addCapability(GroundCharacteristics.JUMPABLE);
        registerInstance();
    }


    /**
     * Goes through the tick of a tree.
     * @param location Location of the tree
     */
    @Override
    public void tick(Location location){
        // Parent function handles the coins spawning if tree is destroyed using a power star, and
        // other stuff that is common to all HigherGround classes.
        super.tick(location);
        final double CONVERT_TO_DIRT = 0.50;

        final int SAPLING_GROWTH_AGE = 10;
        final int MATURE_GROWTH_AGE = 20;

        if (this.hasCapability(Status.RESETTABLE)){
            if (random.nextDouble() <= CONVERT_TO_DIRT) {
                location.setGround(new Dirt());
            }
            this.removeCapability(Status.RESETTABLE);
        }
        else {
            age++;
            if (age == SAPLING_GROWTH_AGE) {
                this.treeState = TreeState.SAPLING;
                setDisplayChar('t');
            } else if (age == MATURE_GROWTH_AGE) {
                this.treeState = TreeState.MATURE;
                setDisplayChar('T');
            }

            final double GOOMBA_SPAWN_PROB = 0.10;
            final double COIN_SPAWN_PROB = 0.10;
            final int COIN_DEFAULT_AMOUNT = 20;
            final double KOOPA_SPAWN_PROB = 0.15;
            final double DIE_PROB = 0.20;

            final int SPROUT_SPAWN_CYCLE = 5;

            switch (this.treeState) {
                case SPROUT:
                    if (!location.containsAnActor()
                            && random.nextDouble() <= GOOMBA_SPAWN_PROB) {
                        location.addActor(new Goomba());
                    }
                    break;
                case SAPLING:
                    if (random.nextDouble() <= COIN_SPAWN_PROB) {
                        location.addItem(new Coin(COIN_DEFAULT_AMOUNT));
                    }
                    break;
                case MATURE:
                    if (!location.containsAnActor() &&
                            random.nextDouble() <= KOOPA_SPAWN_PROB) {
                        location.addActor(new Koopa());
                    }

                    if (age % SPROUT_SPAWN_CYCLE == 0) {

                        ArrayList<Location> fertileSurroundings = new ArrayList<Location>();
                        for (Exit exit : location.getExits()) {
                            Location curLocation = exit.getDestination();
                            Ground curGround = curLocation.getGround();
                            if (curGround.hasCapability(GroundCharacteristics.FERTILE)) {
                                fertileSurroundings.add(curLocation);
                            }
                        }
                        if (!fertileSurroundings.isEmpty()) {
                            Location sproutSpawnLocation = fertileSurroundings
                                    .get(random.nextInt(fertileSurroundings.size()));
                            sproutSpawnLocation.setGround(new Tree());
                        }
                    }

                    // Wither and die
                    if (random.nextDouble() <= DIE_PROB) {
                        location.setGround(new Dirt());
                    }
                    break;
            }
        }
    }

    /**
     * Determines whether the actor is allowed to step onto the tree.
     * @param actor
     * @return can be entered?
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        // The only way to get onto the tree is through have the Power Star status, where you will destroy the tree,
        // or by jumping on the tree.
        return actor.hasCapability(Status.POWER_STAR) || actor.hasCapability(Status.CAN_JUMP);
    }

    /**
     * Gets a list of actions that can be done to the tree.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (location.canActorEnter(actor)) {
            actions.add(new JumpActorAction(location, direction, this));
        }
        return actions;
    }

    /**
     * Returns the fall damage that is dealt for falling off of this tree.
     * @return fall damage if fallen off this tree.
     */
    @Override
    public int getFallDamageRate() {
        // No need for breaks since it's directly returning anyway.
        switch  (this.treeState) {
            case SPROUT:
                return 10;
            case SAPLING:
                return 20;
            case MATURE:
                return 30;
        }
        // Should never happen
        return 0;
    }

    /**
     * Get the probability of falling of this tree if you fall off when trying to jump on it.
     * @return  probability of falling off this tree
     */
    @Override
    public double getFallProb() {
        // No need for breaks since it's directly returning anyway.
        switch  (this.treeState) {
            case SPROUT:
                return 0.90;
            case SAPLING:
                return 0.80;
            case MATURE:
                return 0.70;
        }
        // Should never happen
        return 0;
    }

    /**
     * Returns a string representation of this tree.
     * @return string representation of this tree.
     */
    @Override
    public String toString() {
        // No need for breaks since it's directly returning anyway.
        switch  (this.treeState) {
            case SPROUT:
                return "Sprout";
            case SAPLING:
                return "Sapling";
            case MATURE:
                return "MatureTree";
        }
        // Should never happen
        return "Tree";
    }

    /**
     * Adds the RESETTABLE status to this tree instance
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESETTABLE);
    }
}
