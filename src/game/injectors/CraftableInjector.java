package game.injectors;

import edu.monash.fit2099.engine.actions.ActionList;
import game.actions.ChopAction;
import game.actions.CraftAction;
import game.items.Bow;
import game.items.Sword;

public class CraftableInjector {

    public ActionList addingCraftableItems() {
        ActionList lst = new ActionList();
        lst.add(new CraftAction(new Sword()));
        lst.add(new CraftAction(new Bow()));
        return lst;
    }
}
