package Action;
import Region.Region;

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
    public int[] move(String  direction, int row, int col) {
        if (direction.equals("move up")) {
            row -= 1;
        } else if (direction.equals("move down")) {
            row += 1;
        } else if (direction.equals("move left")) {
            col -=1;
        } else if (direction.equals("move right")) {
            col +=1;
        } else if (direction.equals("move downleft")) {
            row +=1;
            col -=1;
        } else if (direction.equals("move downright")) {
            row +=1;
            col +=1;
        } else if (direction.equals("move upleft")) {
            row -=1;
            col -=1;
        }else {//upright
            row -=1;
            col +=1;
        }

        int[] newPosition = {row, col}; // สร้าง Array เพื่อเก็บตำแหน่งใหม่

        return newPosition; // ส่งค่าตำแหน่งใหม่ออกมา
    }
    


}

