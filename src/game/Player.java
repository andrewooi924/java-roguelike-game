package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements WalletKeeper  {

	private final Menu menu = new Menu();
	private int balance = 100000;
	public static int resetTimes = 1;
	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addCapability(Status.CAN_JUMP);
	}

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();
		Location playerPos = map.locationOf(this);
		display.println(this + this.printHp() + " at " + "(" + playerPos.x() + ", " + playerPos.y() + ")");
		display.println("wallet: $" + this.getWalletBalance());
		// return/print the console menu
		if (this.hasCapability(Status.POWER_STAR)) {
			display.println("Mario is INVINCIBLE!");
		}
		if (resetTimes > 0) {
			actions.add(new Reset());
		}
		return menu.showMenu(this, actions, display);
	}

	@Override
	public char getDisplayChar(){
		return this.hasCapability(Status.TALL) ? Character.toUpperCase(super.getDisplayChar()): super.getDisplayChar();
	}

	@Override
	public int getWalletBalance() {
		return this.balance;
	}

	@Override
	public void addToWallet(int amount) {
		this.balance += amount;
	}

	@Override
	public void deductFromWallet(int amount) {
		this.balance -= amount;
	}
}
