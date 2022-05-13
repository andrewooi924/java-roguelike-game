package game.positions.Tree;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.positions.Dirt;
import game.positions.GroundCharacteristics;
import game.positions.HigherGround;
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
public abstract class Tree extends HigherGround implements Resettable {
    protected int age;
    protected Random random;

    /**
     * Constructor.
     */
    public Tree(char displayChar) {
        super(displayChar);
        this.age = 0;
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

        if (this.hasCapability(Status.RESETTABLE)){
            if (random.nextDouble() <= CONVERT_TO_DIRT) {
                location.setGround(new Dirt());
            }
            this.removeCapability(Status.RESETTABLE);
        }
        else {
            // Note that the age is incremented first before the end.
            // This allows age to start at 1 instead of 0. E.g: The first round, age would be equal to 1.
            // The 10th rounds the age would be 10 instead of 90, etc.
            age++;
        }
    }

    /**
     * Determines whether the actor is allowed to step onto the tree.
     * @param actor the Actor acting
     * @return can be entered?
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        // The only way to get onto the tree is through have the Power Star status, where you will destroy the tree,
        // or by jumping on the tree.
        boolean flag = super.canActorEnter(actor);
        return actor.hasCapability(Status.POWER_STAR) || flag;
    }

    /**
     * Gets a list of actions that can be done to the tree.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return actions
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (!direction.isEmpty()){
            actions.add(new JumpActorAction(location, direction, this));
        }
        return actions;
    }
    /**
     * Adds the RESETTABLE status to this tree instance
     */
    @Override
    public void resetInstance() {
        this.addCapability(Status.RESETTABLE);
    }
}
