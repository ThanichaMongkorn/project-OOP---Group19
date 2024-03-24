package Player;

public interface PlayerManager {
    int addBudget(int money);
    int reduceBudget(int money);
    int getBudget();
    String getname();

    String generateOneRegion(int row,int col);

}
