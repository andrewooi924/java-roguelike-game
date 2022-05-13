package game.actors;

/**
 * Actors that can do an intrinsic attack, and whose base attack damage from intrinsic fighting
 * can increase/decrease.
 */
public interface IntrinsicFighter {
    void setIntrinsicDamage(int damage);
    int getIntrinsicDamage();
}
