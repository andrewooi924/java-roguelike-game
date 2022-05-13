package game.positions;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.JumpActorAction;
import game.positions.HigherGround;

public class Wall extends HigherGround {

	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
	}

	@Override
	public boolean canActorEnter(Actor actor) {
		boolean flag = super.canActorEnter(actor);
		return actor.hasCapability(Status.POWER_STAR) || flag;
	}

	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	@Override
	public int getFallDamageRate() {
		return 20;
	}

	@Override
	public double getFallProb() {
		return 0.80;
	}

	@Override
	public String toString() {
		return "Wall";
	}
}
