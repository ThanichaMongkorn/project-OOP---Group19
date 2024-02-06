package Plan;

import Parser.EvalError;

import java.util.Map;

public record MoveCommand (String s1) implements Plan{
    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {

    }
}