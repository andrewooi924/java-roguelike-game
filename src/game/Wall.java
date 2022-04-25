package game;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

public class Wall extends HigherGround {

	/**
	 * Constructor
	 */
	public Wall() {
		super('#');
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
