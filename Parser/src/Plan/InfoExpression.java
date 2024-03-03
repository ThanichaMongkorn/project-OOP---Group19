package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record InfoExpression (String c) implements Expr {

    public int eval(Map<String, Integer> bindings) throws EvalError {
        return 0;
    }

    public void prettyPrint(StringBuilder s) {
        s.append(c);
    }
}
