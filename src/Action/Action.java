package Action;
import Crew.Crew;
import Player.Player;
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
    public void relocate(Crew crew, Region region, Player player) {
        region.setRow(crew.getRowCrew());
        region.setCol(crew.getColCrew());

        int x = Math.abs(crew.getColCrew()-region.getCol()) + Math.abs(crew.getRowCrew()-region.getRow());
        player.reduceBudget(5*x +10);

    }

    @Override
    public void invest(int amount, Region region, Player player) {
        player.reduceBudget(amount);
        region.reduceDeposit(amount);
    }

    @Override
    public void collect(Player player, Crew crew, Region region) {
        int deposit = region.getDeposit();
        if(player.getBudget()<=0){
            done();
        }else{
            player.reduceBudget(1);
            player.addBudget(deposit);
            region.reduceDeposit(deposit);
        }
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

