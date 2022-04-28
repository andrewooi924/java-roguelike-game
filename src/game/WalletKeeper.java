package game;

public interface WalletKeeper {
    public int getWalletBalance();
    public void addToWallet(int amount);
    public void deductFromWallet(int amount);
}
