package game.items;

import edu.monash.fit2099.engine.items.Item;

public class Pouch extends Item {
    private int amount = 0;
    /***
     * Constructor.
     */
    public Pouch(String name, Enum<?> capability) {
        super(name + " Pouch", 'P', false);
        this.addCapability(capability);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void reduceAmount(int amount) {
        this.amount -= amount;
    }
}
