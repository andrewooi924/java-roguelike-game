package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.ArrayList;
import java.util.Random;

import static game.Status.POWER_STAR;

public class MonologueAction extends Action {

    private String hotkey;
    private Actor actor;

    private final Random random;

    public MonologueAction(Actor targetActor) {
        this.actor = targetActor;
        random = new Random();
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        ArrayList<String> dialoguePossibilities = new ArrayList<String>();
        dialoguePossibilities.add("The Princess is depending on you! You are our only hope.");
        dialoguePossibilities.add("Being imprisoned in these walls can drive a fungus crazy :(");
        boolean hasWrench = false;
        boolean hasPowerStar = actor.hasCapability(POWER_STAR);
        for (Item i: actor.getInventory()) {
            if (i.toString().equalsIgnoreCase("Wrench")) {
                hasWrench = true;
                break;
            }
        }
        if (!hasWrench) {
            dialoguePossibilities.add("You might need a wrench to smash Koopa's hard shells.");
        }
        if (!hasWrench) {
            dialoguePossibilities.add("You better get back to finding the Power Stars.");
        }
        return this.actor + ": \"" + dialoguePossibilities.get(random.nextInt(dialoguePossibilities.size())) + "\"";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " talks with " + this.actor;
    }
}
