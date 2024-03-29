package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record Statement (Plan first,Plan second) implements Plan {
    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {
        first.prettyPrint(s);
        if (second != null) {
            s.append("\n");
            second.prettyPrint(s);
        }
    }
}
