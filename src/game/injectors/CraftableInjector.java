package game.injectors;

import edu.monash.fit2099.engine.actions.ActionList;
import game.actions.CraftAction;
import game.items.Sword;

public class CraftableInjector {

    public ActionList addingCraftableItems() {
        ActionList lst = new ActionList();
        lst.add(new CraftAction(new Sword()));
        return lst;
    }
}
