//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Plan;

import Parser.EvalError;
import java.util.Map;

public record ActionCommand(String c) implements Plan {


    public void eval(Map<String, Integer> bindings) throws EvalError {

    }

    public void prettyPrint(StringBuilder s) {
        s.append(c);
    }


}
