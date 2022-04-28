package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.Random;

public class Tree extends HigherGround {
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
    }


    @Override
    public void tick(Location location){
        super.tick(location);
        final double CONVERT_TO_DIRT = 0.50;

        if (this.hasCapability(Status.RESETTABLE)){
            if (random.nextDouble() <= CONVERT_TO_DIRT) {
                location.setGround(new Dirt());
            }
            this.removeCapability(Status.RESETTABLE);
        }
        else {
            age++;
            if (age == 10) {
                this.treeState = TreeState.SAPLING;
                setDisplayChar('t');
            } else if (age == 20) {
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
                        // Uncomment when coin code is completed.
                        // location.addItem(new Coin(COIN_DEFAULT_AMOUNT));
                    }
                    break;
                case MATURE:
                    if (!location.containsAnActor() &&
                            random.nextDouble() <= KOOPA_SPAWN_PROB) {
                        location.addActor(new Koopa());
                    }

                    // TO-DO: Does "every 5 turns" include the first turn?  Yes, right?
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
