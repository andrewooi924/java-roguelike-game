package game.items;

/**
 * A wallet system to keep coins
 */
public interface WalletKeeper {
    /**
     * Returns the balance of the actor
     * @return an integer representing the wallet balance
     */
    int getWalletBalance();

    /**
     * Adds an amount to the wallet
     * @param amount - an integer
     */
    void addToWallet(int amount);

    /**
     * Deducts an amount from the wallet
     * @param amount - an integer
     */
    void deductFromWallet(int amount);
}
