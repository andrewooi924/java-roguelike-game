package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.actions.MonologueAction;
import game.injectors.TradableInjector;

public class PrincessPeach extends Actor{
    //TODO spawn in lava zone next to Bowser

    /**
     * Constructor
     */
    public PrincessPeach() {
        super("Peach", 'P', 100);
        this.addCapability(Status.INVULNERABLE);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList ret = new ActionList();
        //TODO, let Princess Peach have his own speech and make Toad's speech unique to him
        if (otherActor.hasCapability(Status.HAS_KEY)) {
            Action talk = new MonologueAction(this);
            ret.add(talk);
        }
        //TODO, end the game and give single option to reset
        return ret;
    }
}
