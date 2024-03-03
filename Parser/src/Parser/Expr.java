//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Parser;

import java.util.Map;

public interface Expr {
    int eval(Map<String, Integer> var1) throws EvalError;

    void prettyPrint(StringBuilder var1);
}
