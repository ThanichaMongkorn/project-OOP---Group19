package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record AssignmentStatement(Expr e) implements Plan{
    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {

    }
}
