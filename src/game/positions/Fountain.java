package game.positions;

import game.items.Consumable;

public interface Fountain {
    public Consumable getContents();
    public void reduceCapacity();
}
