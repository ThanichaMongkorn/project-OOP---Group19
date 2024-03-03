package Game;

import Player.Player;
import Region.Region;

import java.util.Map;

public class Board implements BoardManager{
    int numRows = 50;
    int numCols = 50;
    private final Map<String, Region> regions;

    public Board(Map<String, Region> regions) {
        this.regions = regions;
    }

    @Override
    public Region getRegion(int row, int col) {//ดูว่าพิกัดนั้นมีเมืองไหมถ้ามีก็จะส่งคือนว่าว่ามีเมืองแต่ถ้าไม่มีreturn null
        String key = generateOneRegion(row, col);
        return regions.get(key);
    }

    @Override
    public void setRegionOwner(int row, int col, Player owner) {//setให้เมืองเป็นเมืองของผู้เล่น
        Region region = getRegion(row, col);
        if (region != null) {
            region.setOwner(owner);
        }
    }

    @Override
    public void generateLand() {//สร้างเมือง
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                String key = generateOneRegion(row, col);
                regions.put(key, new Region(row, col, 0));
            }
        }
    }

    @Override//สร้างเมืองหลวง
    public String generateOneRegion(int row, int col) {
        return row + "," + col;
    }
}
