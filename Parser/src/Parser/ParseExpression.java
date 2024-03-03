package Parser;

import Plan.IdentifierExpr;
import Plan.InfoExpression;
import Plan.Number;
import Token.Tokenizer;

public class ParseExpression{
    private final Tokenizer tkz;

    public ParseExpression (Tokenizer tkz){
        this.tkz = tkz;
    }
    public Expr parse() throws SyntaxError {
        return parseExpr();
    }
    public Expr parseExpr() throws SyntaxError {
        Expr e = parseTerm();
        while (tkz.peek("+")){
            tkz.consume();
            e = new AST.BinaryArithExpr(e, "+",parseTerm());
        }
        while (tkz.peek("-")){
            tkz.consume();
            e = new AST.BinaryArithExpr(e, "-",parseTerm());
        }
        return e;
    }

    public Expr parseTerm() throws SyntaxError{
        Expr e = parseFactor();
        while (tkz.peek("*")){
            tkz.consume();
            e = new AST.BinaryArithExpr(e,"*",parseFactor());
        }
        while (tkz.peek("/")){
            tkz.consume();
            e = new AST.BinaryArithExpr(e,"/",parseFactor());
        }
        while (tkz.peek("%")){
            tkz.consume();
            e = new AST.BinaryArithExpr(e,"%",parseFactor());
        }
        return e;
    }

    private Expr parseFactor() throws SyntaxError{
        Expr e = parsePower();
        while (tkz.peek("^")){
            tkz.consume("^");
            e = new AST.BinaryArithExpr(e,"^",parseFactor());
        }
        return e;
    }

    private Expr parsePower() throws SyntaxError {
        String peek  = tkz.peek();
        if (peek.matches("\\d+")) {
            return new Number(Integer.parseInt(tkz.consume())); // Parse <number>
        } else if(peek.equals("opponent")||peek.equals("nearby")) {
            return parseInfoExpression(); // Parse InfoExpression
        }
        else if (Character.isLetter(peek.charAt(0))) {
            return new IdentifierExpr(tkz.consume()); // Parse <identifier>
        } else if (tkz.peek("(")) {
            tkz.consume("(");
            Expr expression = parseExpr();
            tkz.consume(")");
            return expression; // Parse ( Expression )
        } else {
            throw new SyntaxError("Invalid Expression format");
        }
    }



    private Expr parseInfoExpression() throws SyntaxError {
        String peek = tkz.peek();
        if (peek.equals("opponent")) {
            tkz.consume("opponent");
            return new InfoExpression("opponent");
        } else if (peek.equals("nearby")) {
            tkz.consume("nearby");
            String direction = tkz.consume(); // Assuming consumeDirection() returns Direction token
            return new InfoExpression("nearby " + direction);
        } else {
            throw new SyntaxError("Invalid InfoExpression format");
        }
    }

    //    E → E + T | E - T | T
//    public Expr parseE() throws SyntaxError {
//        Expr v = parseT();
//        while(tkz.peek("+")||tkz.peek("-")){
//            String op = tkz.consume();
//            if(op.equals("+")){
//                v = new AST.BinaryArithExpr(v, "+", parseT());
//            }else if(op.equals("-")){
//                v = new AST.BinaryArithExpr(v, "-", parseT());
//            }
//        }
//        return v;
//    }
//    //    T → T * F | T / F | T % F | F
//    public Expr parseT() throws SyntaxError{
//        Expr v = parseF();
//        while(tkz.peek("*")||tkz.peek("%")||tkz.peek("/")){
//            String op = tkz.consume();
//            if(op.equals("*")){
//                v = new AST.BinaryArithExpr(v, "*", parseF());
//            }else if(op.equals("%")){
//                v = new AST.BinaryArithExpr(v, "%", parseF());
//            }else if(op.equals("/")){
//                v = new AST.BinaryArithExpr(v, "/", parseF());
//            }
//        }
//        return v;
//    }
//    //    F → n | x | ( E )
//    public Expr parseF() throws SyntaxError {
//        if (tkz.peek().matches("\\d+")) {
//            return new AST.IntLit(Integer.parseInt(tkz.consume()));
//        }else if (tkz.peek().equals("(")){
//            tkz.consume("(");
//            Expr v = parseE();
//            tkz.consume(")");
//            return v;
//        } else {
//            return new AST.Variable(tkz.consume());
//        }
//    }
}
