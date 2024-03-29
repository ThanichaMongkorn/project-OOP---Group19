package Crew;

import Region.Region;

public class Crew {
    private  int rowCrew;
    private int colCrew;

    public void Crew(int rowCrew, int colCrew){
        this.colCrew = colCrew;
        this.rowCrew = rowCrew;
    }

    public int getRowCrew(){
        return this.rowCrew;
    }

    public int getColCrew(){
        return this.colCrew;
    }

//    public int nearby(String direction,Region region, Crew crew) {
//        int rowCrew = region.getRow();
//        int colCrew = region.getCol();
//
//        return 0;
//    }
//
//    @Override
//    public int enermy(String direction, Region region, Crew crew) {
//
//        return 0;
//    }


    public int moveCrew(String direction , Region region) {
        if(direction.equals("move up")){
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move up : ("+row+","+col+")");

            col -= 1;
            region.setCol(col);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);


            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        }else if (direction.equals("move down")){
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move down : ("+row+","+col+")");

            col += 1;
            region.setCol(col);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        } else if (direction.equals("move left")){
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move left : ("+row+","+col+")");

            row -= 1;
            region.setRow(row);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        } else if (direction.equals("move right")) {
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move right : ("+row+","+col+")");

            row += 1;
            region.setRow(row);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        } else if (direction.equals("move upright")) {
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move upright : ("+row+","+col+")");

            col -= 1;
            row +=1;
            region.setCol(col);
            region.setRow(row);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        } else if (direction.equals("move upleft")) {
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move upleft : ("+row+","+col+")");

            col -= 1;
            row -=1;
            region.setCol(col);
            region.setRow(row);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        } else if (direction.equals("move downleft")) {
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move down left : ("+row+","+col+")");

            col += 1;
            row -=1;
            region.setCol(col);
            region.setRow(row);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");

        }else if (direction.equals("move downright")){
            int row = region.getRow();
            int col = region.getCol();
            System.out.println("Row Col before move downright : ("+row+","+col+")");

            col += 1;
            row +=1;
            region.setCol(col);
            region.setRow(row);

            int depositRegion = region.reduceDeposit(1);
            System.out.println("Deposit : "+ depositRegion);

            System.out.println("newRow Col : ("+region.getRow() +","+ region.getCol()+")");
        }
        return 0;
    }


}
