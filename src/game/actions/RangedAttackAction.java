package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

public class RangedAttackAction extends AttackAction{
    Weapon weapon;
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param weapon Weapon of choice
     */
    public RangedAttackAction(Actor target, Weapon weapon) {
        super(target, "at a distance");
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        return super.attackActor(actor, this.weapon, map);
    }
}
