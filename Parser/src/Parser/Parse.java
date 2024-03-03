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

public class Parse {
    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
    private final Tokenizer tkz;
    public Parse(Tokenizer tkz){
        this.tkz = tkz;
        exprParser = new ParseExpression(tkz);
    }

    private final ParseExpression exprParser;

    public Plan parse() throws SyntaxError {
        Plan v = parsePlan();
//        System.out.println(v);  //For testing
        if (tkz.hasNextToken()){throw new SyntaxError("leftover token");}
        return v;
    }


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
        String peek = tkz.consume();
        tkz.consume("=");
        Expr e = exprParser.parse();
        return new AssignmentStatement(e);
    }

    private Plan parseAttackCommand() throws SyntaxError {
        tkz.consume("shoot");
        String s = " ";
        String peek = tkz.consume();

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
        Expr e = exprParser.parse();

        return new AttackCommand(peek,e);

    }

    private Plan parseRegionCommand() throws SyntaxError {
        String peek = tkz.consume();

        if(peek.equals("invest")){
            tkz.consume("invest");
        }

        if (peek.equals("collect")){
            tkz.consume("collect");
        }
        Expr e = exprParser.parse();
        return new RegionCommand(e);
    }

    public Plan parseMoveCommand() throws SyntaxError {
        String s= "";
        tkz.consume("move");
        String peek = tkz.consume();
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
        return new MoveCommand(peek);
    }

    public Plan parseActionCommand() throws SyntaxError {
        String peek = tkz.consume();
        String s = " ";
        if(peek.equals("done")){
            s = "done";
        }
        if(peek.equals("relocate")){
            s = "relocate";
        }
        return new ActionCommand(peek);
    }

    public Plan parseWhileStatement() throws SyntaxError{
        tkz.consume("while");
        tkz.consume("(");
        Expr e = exprParser.parse();
        tkz.consume(")");
        Plan state = parseStatement();
        return new WhileStatement(e,state);
    }

    public Plan parseIfStatement() throws SyntaxError {
        tkz.consume("if");
        tkz.consume("(");
        Expr e = exprParser.parse();
        tkz.consume(")");
        tkz.consume("then");

        Plan state = parseStatement();

        tkz.consume("else");
        return new IfStatement(e,state,parseStatement());
    }


    public Plan parseBlockStatement() throws SyntaxError {
        Plan v = new NoStatement();
        tkz.consume("{");
        while (tkz.hasNextToken()&& !tkz.peek("}")){
            v = new Statement(v,parseStatement());
        }
        tkz.consume("}");
        return v;
    }
}

