package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record AttackCommand(String c,Expr e) implements Plan{
    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {
        s.append(" ");
        e.prettyPrint(s);
    }
}
