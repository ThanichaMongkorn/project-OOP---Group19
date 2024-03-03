//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Plan;

import Parser.EvalError;
import Parser.Expr;
import java.util.Map;

public record AssignmentStatement(Expr e) implements Plan {

    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {
        //หาidentifier
        s.append("=");
        e.prettyPrint(s);
    }

}
