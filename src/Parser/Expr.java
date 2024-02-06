package Parser;

import java.util.Map;

public interface Expr {
    int eval(Map<String, Integer> bindings) throws EvalError;

    void prettyPrint(StringBuilder s);
}
