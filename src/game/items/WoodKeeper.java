package game.items;

public interface WoodKeeper {
    /**
     * Returns the balance of wood from the actor
     * @return an integer representing the amount of wood
     */
    int getWoodAmount();

    /**
     * Adds an amount to the woodstack.
     * @param amount - an integer
     */
    void addToWood(int amount);

    /**
     * Deducts an amount from the woodstack.
     * @param amount - an integer
     */
    void deductFromWood(int amount);
}
