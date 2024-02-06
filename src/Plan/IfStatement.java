package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public record IfStatement(Expr e,Plan state1,Plan state2) implements Plan  {

        public void eval(Map<String, Integer> bindings) throws EvalError {

        }

        public void prettyPrint(StringBuilder s) {

        }
}
