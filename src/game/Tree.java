package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Tree extends HigherGround {

    /**
     * Constructor.
     */
    public Tree() {
        super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.POWER_STAR) || actor.hasCapability(Status.CAN_JUMP);
    }

    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction){
        ActionList actions = new ActionList();
        if (location.canActorEnter(actor)) {
            actions.add(new JumpActorAction(location, direction, this));
        }
        return actions;
    }

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
}
