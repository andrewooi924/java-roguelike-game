package game.positions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.items.Coin;

import java.util.Random;

/**
 * An abstract class used to provide a singular identity for high grounds
 * that the Player can attempt to jump onto.
 */
public abstract class HigherGround extends Ground {

    public abstract int getFallDamageRate();
    public abstract double getFallProb();


    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public HigherGround(char displayChar) {
        super(displayChar);
    }

    public String jumpOn(Actor jumper, GameMap map, Location destination) {
        double successRate = this.getFallProb();
        int damage = this.getFallDamageRate();
        if (jumper.hasCapability(Status.TALL)) {
            successRate = 1.0;
            // This line is redundant as the Player won't take damage due to the success rate
            damage = 0;
        }
        Random random = new Random();
        if (random.nextDouble() <= successRate){
            map.moveActor(jumper, destination);
            return String.format("%s jumps to %s(%d, %d)", jumper, this, destination.x(), destination.y());
        }
        else{
            jumper.hurt(damage);
            return String.format("%s hits the %s and takes %d damage", jumper, this.toString().toLowerCase(), damage);
        }

    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(Status.POWER_STAR);
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
        if (location.containsAnActor() && location.getActor().hasCapability(Status.POWER_STAR)) {
            location.addItem(new Coin(5));
        }
    }
}