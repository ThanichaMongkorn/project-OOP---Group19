package Plan;

import Parser.EvalError;

import java.util.Map;

public record NoStatement () implements Plan {
    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {

    }
}
