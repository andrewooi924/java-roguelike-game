package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

public class CraftAction extends Action {

    private Item item;

    public CraftAction(Item item){
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map){
        return "";
    }

    @Override
    public String menuDescription(Actor actor){
        return "";
    }
}
