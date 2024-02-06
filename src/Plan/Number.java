package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Enumeration;
import java.util.Map;

public class Number implements Expr {
    private int value;
    public Number(int value){
        this.value = value;
    }
    public int eval(Map<String, Integer> bindings)  {
        return value;
    }

    public void prettyPrint(StringBuilder sb) { sb.append(value);

    }
}
