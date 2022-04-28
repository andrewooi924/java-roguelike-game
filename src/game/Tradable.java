package game;

import edu.monash.fit2099.engine.items.Item;

public interface Tradable {

    int getPrice();

    Item getItem();

    String toString();
}
