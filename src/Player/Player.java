package Player;

import Region.Region;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements PlayerManager {
    private String name;
    private int budget;
    private List<Region> regionsOwned;//เอาไว้เก็บพื้นที่ของผู้เล่น

    public Player(String name,int budget){
        this.name = name;
        this.budget = budget;
        this.regionsOwned = new ArrayList<>();
    }


    @Override
    public int addBudget(int money) {
        this.budget += money;
        return budget;
    }

    @Override
    public int reduceBudget(int money) {
        this.budget -= money;
        if (this.budget < 0) {
            this.budget = 0;
        }
        return budget;
    }

    @Override
    public int getBudget() {
        return budget;
    }

    @Override
    public String getname() {
        return name;
    }

    @Override
    public String generateOneRegion(int row, int col) {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);

        int startRow = random.nextInt(row + 1);
        int startCol = random.nextInt(col + 1);

        return "("+ startRow+ "," +startCol +")";
    }


}
