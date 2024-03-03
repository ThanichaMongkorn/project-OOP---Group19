package Player;
import Action.ActionManager;
import Region.Region;
import Action.Direction;

import java.util.ArrayList;
import java.util.List;

public class Action implements ActionManager {
    private String name;
    private int budget;
    private List<Region> regionsOwned; // เก็บบริเวณที่เป็นเจ้าของ

    public void Player(String name, int budget) {
        this.name = name;
        this.budget = budget;
        this.regionsOwned = new ArrayList<>();
    }

    @Override
    public void done() {
        //methodนี้ใช้เมื่อผู้เล่นกด next turn
    }

    @Override
    public void relocate() {
    }

    @Override
    public void invest(int amount) {

    }

    @Override
    public void collect(int amount) {

    }

    @Override
    public void shoot(Direction direction, int expenditure) {

    }

    @Override
    public void move(Direction direction) {

    }

}
