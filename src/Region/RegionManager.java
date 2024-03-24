package Region;

import Player.Player;

public interface RegionManager {
    boolean hasOwner();//ตรวจสอบว่าพิกัดนั้นมีเจ้าของหรือไม่
    void setOwner(Player player);//กำหนดเจ้าของพท.
    Player getOwner();//รับข้อมูลเจ้าของบริเวณ
    int addDeposit(int amount);//เพิ่มยอดเงินฝาก
    int reduceDeposit(int amount);//ลดยอดเงินฝาก
    int getDeposit();
    int getRow();
    int getCol();
    void setRow(int row);
    void setCol(int col);
}
