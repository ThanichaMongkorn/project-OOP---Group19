package Region;

import Crew.Crew;
import Player.Player;

public class Region implements RegionManager{
    private int row;
    private int col;
    private int deposit;
    private Player owner;//เก็บข้อมูลเจ้าของที่

    public Region(int row, int col, int deposit) {
        this.row = row;
        this.col = col;
        this.deposit = deposit;
        this.owner = null; // ตั้งค่าเริ่มต้นให้ไม่มีเจ้าของ
    }

    @Override
    public boolean hasOwner() {
        return owner != getOwner();
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public int addDeposit(int amount) {
        this.deposit += amount;
        System.out.println("Depsit (add) " + amount+" : " + deposit);
        return deposit;
    }

    @Override
    public int reduceDeposit(int amount) {
        this.deposit -= amount;
        if (this.deposit < 0) {
            this.deposit = 0;
            System.out.println("Deposit (reduce) "+amount+" : "+deposit);
            return deposit;
        }
        System.out.println("Deposit (reduce) "+amount+" : "+deposit);
        return deposit;
    }

    @Override
    public int getDeposit() {
        System.out.println("Deposit (current) : "+deposit);
        return deposit;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public int getCol() {
        return col;
    }

    @Override
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public void setOwner(Player player) {
        this.owner = player;
    }//กำหนดว่าใครเป็นเจ้าของที่
}
