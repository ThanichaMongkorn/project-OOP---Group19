package Plan;

import java.util.Map;
import Parser.EvalError;
public interface Plan {

    void eval(Map<String, Integer> bindings) throws EvalError;
    void prettyPrint(StringBuilder s);
}


