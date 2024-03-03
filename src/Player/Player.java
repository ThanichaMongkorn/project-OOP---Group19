package Player;

import Region.Region;

import java.util.ArrayList;
import java.util.List;

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
    public void addBudget(int money) {
        this.budget += money;
    }

    //methodลดเงินของผู้เล่น
    @Override
    public void reduceBudget(int money) {
        this.budget -= money;
//        if (this.budget < 0) {
//            this.budget = 0;
//        }
    }

    @Override
    public int getBudget() {
        return budget;
    }
}
