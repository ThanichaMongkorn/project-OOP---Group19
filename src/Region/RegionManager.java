package Region;

import Player.Player;

public interface RegionManager {
    boolean hasOwner();//ตรวจสอบว่าพิกัดนั้นมีเจ้าของหรือไม่
    void setOwner(Player player);//กำหนดเจ้าของพท.
    Player getOwner();//รับข้อมูลเจ้าของบริเวณ
    void addDeposit(int amount);//เพิ่มยอดเงินฝาก
    void reduceDeposit(int amount);//ลดยอดเงินฝาก
    int getDeposit();//ดูยอดเงินฝาก
    int getRow();
    int getCol();
}
