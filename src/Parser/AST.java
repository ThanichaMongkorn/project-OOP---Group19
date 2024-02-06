package Parser;

import java.util.Map;

public class AST {
    record IntLit(int val) implements Expr {
        public void prettyPrint(
                StringBuilder s) {
            s.append(val);
        }
        @Override
        public int eval(Map<String, Integer> bindings){
            return val;
        }
    }

    record Variable(String name) implements Expr {
        public int eval(
                Map<String, Integer> bindings) throws EvalError {
            if (bindings.containsKey(name))
                return bindings.get(name);
            throw new EvalError(
                    "undefined variable: " + name);
        }
        public void prettyPrint(
                StringBuilder s) {
            s.append(name);
        }
    }

    record BinaryArithExpr(
            Expr left, String op, Expr right)
            implements Expr {
        public int eval(
                Map<String, Integer> bindings) throws EvalError , ArithmeticException {
            int lv = left.eval(bindings);
            int rv = right.eval(bindings);
            if (op.equals("+")) return lv + rv;
            if (op.equals("-")) return lv - rv;
            if (op.equals("*")) return lv * rv;
            if(lv == 0){
                throw new ArithmeticException("ArithmeticException:");
            }else{
                if (op.equals("/")) return lv / rv;
                if (op.equals("%")) return lv % rv;
            }
            throw new EvalError("unknown op: " + op);
        }
        public void prettyPrint(StringBuilder s) {
            s.append("(");
            left.prettyPrint(s);
            s.append(op);
            right.prettyPrint(s);
            s.append(")");
        }
    }

}
