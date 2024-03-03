package Test;

import Parser.SyntaxError;
import Token.Tokenizer;

public class TestParser {
    public static void main(String[] args) throws SyntaxError,NumberFormatException{
        Tokenizer tkz;
        String t = "t = t + 1 \n" +
                "m = 0  \n" +
                "while (deposit) { \n" +
                "  if (deposit - 100)\n" +
                "  then collect (deposit / 4)  \n" +
                "  else if (budget - 25) then invest 25\n" +
                "  else {}\n" +
                "  if (budget - 100) then done else done \n" +
                "  opponentLoc = opponent\n" +
                "  if (opponentLoc / 10 - 1)\n" +
                "  then  \n" +
                "    if (opponentLoc % 10 - 5) then move downleft\n" +
                "    else if (opponentLoc % 10 - 4) then move down\n" +
                "    else if (opponentLoc % 10 - 3) then move downright\n" +
                "    else if (opponentLoc % 10 - 2) then move right\n" +
                "    else if (opponentLoc % 10 - 1) then move upright\n" +
                "    else move up\n" +
                "  else if (opponentLoc)\n" +
                "  then  \n" +
                "    if (opponentLoc % 10 - 5) then {\n" +
                "      cost = 10 ^ (nearby upleft % 100 + 1)\n" +
                "      if (budget - cost) then shoot upleft cost else {}\n" +
                "    }\n" +
                "    else if (opponentLoc % 10 - 4) then {\n" +
                "      cost = 10 ^ (nearby downleft % 100 + 1)\n" +
                "      if (budget - cost) then shoot downleft cost else {}\n" +
                "    }\n" +
                "    else if (opponentLoc % 10 - 3) then {\n" +
                "      cost = 10 ^ (nearby down % 100 + 1)\n" +
                "      if (budget - cost) then shoot down cost else {}\n" +
                "    }\n" +
                "else if (opponentLoc % 10 - 2) then {\n" +
                "      cost = 10 ^ (nearby downright % 100 + 1)\n" +
                "      if (budget - cost) then shoot downright cost else {}\n" +
                "    }\n" +
                "    else if (opponentLoc % 10 - 1) then {\n" +
                "      cost = 10 ^ (nearby upright % 100 + 1)\n" +
                "      if (budget - cost) then shoot upright cost else {}\n" +
                "    }\n" +
                "    else {\n" +
                "      cost = 10 ^ (nearby up % 100 + 1)\n" +
                "      if (budget - cost) then shoot up cost else {}\n" +
                "    }\n" +
                "  else {\n" +
                "    dir = random % 6\n" +
                "    if (dir - 4) then move upleft\n" +
                "    else if (dir - 3) then move downleft\n" +
                "    else if (dir - 2) then move down\n" +
                "    else if (dir - 1) then move downright\n" +
                "    else if (dir) then move upright\n" +
                "    else move up\n" +
                "    m = m + 1\n" +
                "  }\n" +
                "} \n" +
                "if (budget - 1) then invest 1 else {}\n"+
                " ";
        tkz = new Tokenizer(t);
        while ( tkz.hasNextToken()){
            System.out.println(tkz.consume());
        }
//        StringBuilder p = new StringBuilder();
//        new ParserCalculate(tkz).parse().prettyPrint(p);
//        System.out.println(p.toString());
//        Tokenizer tokenizer = new Tokenizer(t);
//        ParserCalculate parser = new ParserCalculate(tokenizer);
//        Plan plan = parser.parse();

//        // ตรวจสอบว่าไม่มี SyntaxError เกิดขึ้น
//        System.out.println("No SyntaxError occurred.");
//
//        // ตรวจสอบว่าการแปลงโค้ดเป็นตารางข้อมูลเสร็จสมบูรณ์
//        System.out.println("Parsed successfully.");
//
//        // ทดสอบ prettyPrint() เพื่อดูผลลัพธ์ที่ถูกต้อง
//        StringBuilder prettyPrinted = new StringBuilder();
//        plan.prettyPrint(prettyPrinted);
//        System.out.println("Pretty printed code:");
//        System.out.println(prettyPrinted.toString());

    }

}