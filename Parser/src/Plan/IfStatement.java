package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record IfStatement(Expr e,Plan state1,Plan state2) implements Plan  {

    public void eval(Map<String, Integer> bindings) throws EvalError {
    }

    public void prettyPrint(StringBuilder s) {
        s.append("if (");
        e.prettyPrint(s);
        s.append(") { ");
        state1.prettyPrint(s);
        s.append(" } else { ");
        state2.prettyPrint(s);
        s.append(" }");
    }
}
