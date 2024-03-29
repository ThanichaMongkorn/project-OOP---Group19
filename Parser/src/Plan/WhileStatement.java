package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record WhileStatement (Expr e, Plan state) implements Plan{
    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {
        s.append("while (");
        e.prettyPrint(s);
        s.append(") ");
        state.prettyPrint(s);
    }
}
