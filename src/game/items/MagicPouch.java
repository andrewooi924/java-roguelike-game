package game.items;

import edu.monash.fit2099.engine.items.Item;

import java.util.HashMap;

public class MagicPouch extends Item {

    HashMap<Storable, Integer> counter = new HashMap<>();
    /***
     * Constructor.
     */
    public MagicPouch() {
        super("Magic Pouch", 'P', false);
    }

    public int getAmount(Storable item) {
        return counter.getOrDefault(item, 0);
    }

    public void setAmount(Storable item, int amount) {
        counter.put(item, amount);
    }

    public void increaseAmount(Storable item, int amount) {
        counter.put(item, this.getAmount(item) + amount);
    }

    public void decreaseAmount(Storable item, int amount) {
        counter.put(item, this.getAmount(item) - amount);
    }
}
