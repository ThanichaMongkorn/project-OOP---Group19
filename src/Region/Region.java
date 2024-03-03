package Region;

import Player.Player;

public class Region implements RegionManager {
    private int row;
    private int col;
    private int deposit;
    private Player owner;//เก็บข้อมูลเจ้าของที่
    public Region(int row, int col, int deposit) {
        this.row = row;
        this.col = col;
        this.deposit = deposit;
        //this.owner = null; // ตั้งค่าเริ่มต้นให้ไม่มีเจ้าของ
    }

    @Override
    public boolean hasOwner() {
        return owner != null;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void addDeposit(int amount) {
        this.deposit += amount;
    }

    @Override
    public void reduceDeposit(int amount) {
        this.deposit -= amount;
        if (this.deposit < 0) {
            this.deposit = 0;
        }
    }

    @Override
    public int getDeposit() {
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
    public void setOwner(Player player) {
        this.owner = player;
    }//กำหนดว่าใครเป็นเจ้าของที่
}
