package game.items;

/**
 * A super overpowered sword that slashes through dimensions.
 */
public class GalaxySword extends Sword{

    public GalaxySword(){
        this.setDisplayChar('G');
    }

    @Override
    public int damage(){
        return 500;
    }
}
