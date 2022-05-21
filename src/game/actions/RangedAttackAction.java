package game.actions;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.items.Weapon.RangedWeapon;

public class RangedAttackAction extends AttackAction{
    RangedWeapon weapon;
    /**
     * Constructor.
     *
     * @param target    the Actor to attack
     * @param weapon Weapon of choice
     */
    public RangedAttackAction(Actor target, RangedWeapon weapon) {
        super(target, "a distance");
        this.weapon = weapon;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        this.weapon.reduceAmmo(actor, 1);
        return super.attackActor(actor, this.weapon, map);
    }
}
