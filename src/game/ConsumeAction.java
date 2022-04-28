package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ConsumeAction extends Action {

    Consumable consumable;

    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        actor.addCapability(this.consumable.effect());
        String additionalInfo = this.consumable.execute(actor, map);
        additionalInfo = (additionalInfo == null || additionalInfo.isEmpty()) ? "" : " - " + additionalInfo;
        return actor.toString() + " consumes " + consumable.toString() + additionalInfo;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " consumes " + consumable.toString();
    }
}
