package Parser;

import Plan.Plan;
import Token.Tokenizer;
import Plan.Statement;
import Plan.IfStatement;
import Plan.WhileStatement;
import Plan.ActionCommand;
import Plan.MoveCommand;
import Plan.RegionCommand;
import Plan.AttackCommand;
import Plan.AssignmentStatement;
import Plan.NoStatement;
import Plan.IdentifierExpr;
import Plan.InfoExpression;
import Plan.Number;
public class ParserCalculate {
    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
    private Tokenizer tkz;
    public ParserCalculate(Tokenizer tkz){
        this.tkz = tkz;
    }


    public Plan parse() throws SyntaxError {
        Plan v = parsePlan();
//        System.out.println(v);  //For testing
        if (tkz.hasNextToken()){throw new SyntaxError("leftover token");}
        return v;
    }

    //    E → E + T | E - T | T
    public Plan parsePlan() throws SyntaxError {
        Plan v = parseStatement();
        while (tkz.hasNextToken()) {
            v = new Statement(v,parseStatement());
        }
        return v;
    }

    public Plan parseStatement() throws SyntaxError, ArithmeticException {
        String peek = tkz.peek();
     if(peek.equals("{")){
         return parseBlockStatement();
     }

     if(peek.equals("if")){
         return parseIfStatement();
     }

     if(peek.equals("while")){
         return parseWhileStatement();
     }

     else {
         return parseCommand();
     }
    }

    public Plan parseCommand() throws SyntaxError {
        String peek  = tkz.peek();
        if(peek.equals("done") || peek.equals("relocate")){
            return parseActionCommand();
        }

        if (peek.equals("move")){
            return parseMoveCommand();
        }

        if(peek.equals("invest") || peek.equals("collect")){
            return parseRegionCommand();
        }

        if(peek.equals("shoot")){
            return parseAttackCommand();
        }
        else {
            return parseAssignmentStatement();
        }
    }

    private Plan parseAssignmentStatement() throws SyntaxError {
        String peek = tkz.peek();
        tkz.consume();
        tkz.consume(" = ");
        Expr e = parseExpression();
        return new AssignmentStatement(e);
    }

    private Plan parseAttackCommand() throws SyntaxError {
        String peek = tkz.peek();
        tkz.consume("shoot");
        String s = " ";

        if(peek.equals("up")){
            s = "up";
        }
        if(peek.equals("down")){
            s = "down";
        }
        if(peek.equals("upleft")){
            s = "upleft";
        }
        if(peek.equals("upright")){
            s = "upright";
        }
        if (peek.equals("downleft")){
            s = "downleft";
        }
        if (peek.equals("downright")){
            s = "downright";
        }
        Expr e = parseExpression();

        return new AttackCommand(s,e);

    }

    private Plan parseRegionCommand() throws SyntaxError {
        String peek = tkz.peek();

        if(peek.equals("invest")){
            tkz.consume("invest");
        }

        if (peek.equals("collect")){
            tkz.consume("collect");
        }
        Expr e = parseExpression();
        return new RegionCommand(e);
    }

    public Plan parseMoveCommand() throws SyntaxError {
        String peek = tkz.peek();
        String s= "";
        tkz.consume("move");
        if(peek.equals("up")){
            s = "up";
        }
        if(peek.equals("down")){
            s = "down";
        }
        if(peek.equals("upleft")){
            s = "upleft";
        }
        if(peek.equals("upright")){
            s = "upright";
        }
        if (peek.equals("downleft")){
            s = "downleft";
        }
        if (peek.equals("downright")){
            s = "downright";
        }
        return new MoveCommand(s);
    }

    public Plan parseActionCommand() throws SyntaxError {
        String peek = tkz.peek();
        String s = " ";
        if(peek.equals("done")){
            s = "done";
        }
        if(peek.equals("relocate")){
            s = "relocate";
        }
        return new ActionCommand(s);
    }

    public Plan parseWhileStatement() throws SyntaxError{
        tkz.consume("while");
        tkz.consume("(");
        Expr e = parseExpression();
        tkz.consume(")");
        Plan state = parseStatement();
        return new WhileStatement(e,state);
    }

    public Plan parseIfStatement() throws SyntaxError {
        tkz.consume("if");
        tkz.consume("(");
        Expr e = parseExpression();
        tkz.consume(")");
        tkz.consume("then");

        Plan state = parseStatement();

        tkz.consume("else");
        return new IfStatement(e,state,parseStatement());
    }

    public  Expr parseExpression() {
    return  null;
    }

    public Plan parseBlockStatement() throws SyntaxError {
        Plan v = new NoStatement();
        tkz.consume("{");
        while (tkz.hasNextToken()){
            v = new Statement(v,parseStatement());
        }
        tkz.consume("}");
        return v;
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
        if (isNumber(peek)) {
            return new Number(Integer.parseInt(tkz.consume())); // Parse <number>
        } else if (Character.isLetter(peek.charAt(0))) {
            return new IdentifierExpr(tkz.consume()); // Parse <identifier>
        } else if (tkz.peek("(")) {
            tkz.consume("(");
            Expr expression = parseExpression();
            tkz.consume(")");
            return expression; // Parse ( Expression )
        } else {
            return parseInfoExpression(); // Parse InfoExpression
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



}

