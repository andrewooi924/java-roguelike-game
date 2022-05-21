package game.items.Weapon;

/**
 * A super overpowered sword that slashes through dimensions.
 */
public class GalaxySword extends Sword{

    public GalaxySword(){
        this.setDisplayChar('!');
    }

    @Override
    public int damage(){
        return 400;
    }

    @Override
    public String toString(){
        return "Galaxy Sword";
    }
}
