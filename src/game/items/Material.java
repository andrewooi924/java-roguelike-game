package game.items;

/**
 * Any items that are used in recipes for crafting implement this interface.
 */
public interface Material {

    /**
     * Returns the amount of material required in the recipe
     * @return the amount of material required in the recipe
     */
    int getAmount();
}
