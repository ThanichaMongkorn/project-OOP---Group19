package Game;

import Player.Player;
import Region.Region;

public interface BoardManager {
    Region getRegion(int row, int col);//ดูว่าพิกัดเมืองนั้นมีเมืองไหมถ้ามีส่งคืนว่ามีเมืองถ้าไม่มีreturn null
    void setRegionOwner(int row, int col, Player owner);//setให้เป็นเมืองของผู้เล่น
    void generateLand();//สร้างแผนที่
    String generateOneRegion(int row,int col);//สร้างเมืองหลวง

}