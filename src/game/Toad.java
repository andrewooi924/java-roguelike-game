package game;

import edu.monash.fit2099.engine.actions.Action;
        import edu.monash.fit2099.engine.actions.ActionList;
        import edu.monash.fit2099.engine.actions.DoNothingAction;
        import edu.monash.fit2099.engine.actors.Actor;
        import edu.monash.fit2099.engine.displays.Display;
        import edu.monash.fit2099.engine.positions.GameMap;

public class Toad extends Actor {

    /**
     * Constructor
     */
    public Toad() {
        super("Toad", 'O', 10);
    }

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList ret = new ActionList();
        Action talk = new MonologueAction(this);
        ret.add(new TradingAction(new Wrench()));
        ret.add(new TradingAction(new SuperMushroom()));
        ret.add(new TradingAction(new PowerStar()));
        ret.add(talk);
        return ret;
    }
}
