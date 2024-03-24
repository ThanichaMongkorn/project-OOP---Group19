package Game;

import Player.Player;
import Region.Region;

import java.util.Map;

public class Board implements BoardManager{
//    int numRows = 50;
//    int numCols = 50;
//    //private final Map<String, Region> regions;
    private String[][] regions;

    public Board(int numRows, int numCols) {
        if(numRows < 100 && numCols < 100){
            System.out.println("Build map size : "+numRows+","+numCols);

            for(int i=1;i<=numRows;i++){
                for(int j=1;j<=numCols;j++){
                    System.out.println("("+i+","+j+")");
                }
                System.out.println("");
        }
        }else {
            System.out.println("can not build.");
        }

        regions = new String[numRows][numCols];
    }

    @Override
    public Region getRegion(int row, int col) {//ดูว่าพิกัดนั้นมีเมืองไหมถ้ามีก็จะส่งคือนว่าว่ามีเมืองแต่ถ้าไม่มีreturn null
//        String key = generateOneRegion(row, col);
//        return regions.get(key);
        return null;
    }

    @Override
    public void setRegionOwner(int row, int col, Player owner) {//setให้เมืองเป็นเมืองของผู้เล่น
        regions[row][col] = owner.getname();
    }

    //@Override
    //public void generateLand() {//สร้างเมือง
//        for (int row = 0; row < numRows; row++) {
//            for (int col = 0; col < numCols; col++) {
//                String key = generateOneRegion(row, col);
//                regions.put(key, new Region(row, col, 0));
//            }
//        }
     //   return;
    //}

//    @Override//สร้างเมืองหลวง
//    public String generateOneRegion(int row, int col) {
//        int startRow = row%51;
//        int startCol = col%51;
//
//        return "( "+startRow + "," + startCol +" )";
//    }

    @Override
    public String getOwnerName(int row, int col) {
        return regions[row][col];
    }
}
