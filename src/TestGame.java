import Action.Direction;
import Crew.Crew;
import Game.Board;
import Player.Player;
import Region.Region;

public class TestGame {
    public static void main(String[] args){

        //สร้างboard
        Board board = new Board(50,50);

        Player player1 = new Player("pp" , 5000);
        Player player2 = new Player("joy" , 5000);

        //get budget & name
        System.out.println("Budget "+player1.getname()+" : "+player1.getBudget());
        System.out.println("Budget "+player2.getname()+" : "+player2.getBudget());

        System.out.println("---------------------------------------------------");

        //reduce budget
        System.out.println("Reduce Budget 500 "+player1.getname()+" : "+player1.reduceBudget(500));
        //System.out.println("Budget After Reduce "+player1.getname()+" : "+player1.getBudget());
        System.out.println(" ");
        System.out.println("Reduce Budget 450 "+player2.getname()+" : "+player2.reduceBudget(450));
        //System.out.println("Budget After Reduce "+player2.getname()+" : "+player2.getBudget());

        System.out.println("---------------------------------------------------");

        //add budget
        System.out.println("Add Budget 100 "+player1.getname()+" : "+player1.addBudget(100));
        System.out.println("Budget After Add "+player1.getname()+" : "+player1.getBudget());
        System.out.println(" ");
        System.out.println("Add Budget 10 "+player2.getname()+" : "+player2.addBudget(10));
        System.out.println("Budget After Add "+player2.getname()+" : "+player2.getBudget());

        System.out.println("---------------------------------------------------");

        //สร้างเมืองหลวงของแต่ละคน
        String RegionPlayer1 = player1.generateOneRegion(50,50);
        String RegionPlayer2 = player2.generateOneRegion(50,50);
        System.out.println("City center"+player1.getname()+RegionPlayer1);
        System.out.println("City center"+player2.getname()+RegionPlayer2);



        int rowPlayer1 = Integer.parseInt(RegionPlayer1.substring(1, RegionPlayer1.indexOf(',')));
        int colPlayer1 = Integer.parseInt(RegionPlayer1.substring(RegionPlayer1.indexOf(',') + 1, RegionPlayer1.length() - 1));
        int rowPlayer2 = Integer.parseInt(RegionPlayer2.substring(1, RegionPlayer2.indexOf(',')));
        int colPlayer2 = Integer.parseInt(RegionPlayer2.substring(RegionPlayer2.indexOf(',') + 1, RegionPlayer2.length() - 1));

        System.out.println("---------------------------------------------------");

        //setให้ตำแหน่งนี้ว่าเจ้าของที่เป็นใคร



        board.setRegionOwner(rowPlayer1, colPlayer1, player1);
        board.setRegionOwner(rowPlayer2, colPlayer2, player2);

        System.out.println("Owner of RegionPlayer"+RegionPlayer1+ ": " + board.getOwnerName(rowPlayer1, colPlayer1));
        System.out.println("Owner of RegionPlayer"+RegionPlayer2+": " + board.getOwnerName(rowPlayer2, colPlayer2));

        System.out.println("---------------------------------------------------");

        //test movecrew
        Crew crew = new Crew();
        Region region = new Region(rowPlayer1, colPlayer1, player1.getBudget());

        boolean result = region.hasOwner();
        System.out.println("hash Owner : "+ !result);

        System.out.println("");

        System.out.println("(Row,Col) "+player1.getname()+" : "+ RegionPlayer1);
        System.out.println("Deposit "+player1.getname()+" : "+player1.getBudget());

        System.out.println("");

        crew.moveCrew("move up", region);
        crew.moveCrew("move down", region);
        crew.moveCrew("move left", region);
        crew.moveCrew("move right", region);
        crew.moveCrew("move upright", region);
        crew.moveCrew("move upleft", region);
        crew.moveCrew("move downleft", region);
        crew.moveCrew("move downright", region);

        System.out.println("---------------------------------------------------");

        //test get Deposit
        region.getDeposit();

        System.out.println("---------------------------------------------------");
        //test addDeposit
        region.addDeposit(500);
        region.getDeposit();

        System.out.println("---------------------------------------------------");
        //test reduceDeposit
        region.reduceDeposit(100);
        region.getDeposit();

        System.out.println("---------------------------------------------------");



    }
}
