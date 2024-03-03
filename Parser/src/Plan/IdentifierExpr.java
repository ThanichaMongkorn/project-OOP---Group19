package Plan;

import Parser.EvalError;
import Parser.Expr;

import java.util.Map;

public class IdentifierExpr implements Expr {
    private String name;

    public IdentifierExpr(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int eval(Map<String, Integer> bindings) throws EvalError {
        if(bindings.containsKey(name)){
            return bindings.get(name);
        }else{
            throw new EvalError("Variable " + name +" not found in binding");}
    }
    public void prettyPrint(StringBuilder s){
        s.append(name);
    }

}
