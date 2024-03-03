//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Parser;

import java.util.Map;

public class AST {
    public AST() {
    }

    static record BinaryArithExpr(Expr left, String op, Expr right) implements Expr {
        BinaryArithExpr(Expr left, String op, Expr right) {
            this.left = left;
            this.op = op;
            this.right = right;
        }

        public int eval(Map<String, Integer> bindings) throws EvalError, ArithmeticException {
            int lv = this.left.eval(bindings);
            int rv = this.right.eval(bindings);
            if (this.op.equals("+")) {
                return lv + rv;
            } else if (this.op.equals("-")) {
                return lv - rv;
            } else if (this.op.equals("*")) {
                return lv * rv;
            } else if (lv == 0) {
                throw new ArithmeticException("ArithmeticException:");
            } else if (this.op.equals("/")) {
                return lv / rv;
            } else if (this.op.equals("%")) {
                return lv % rv;
            } else {
                throw new EvalError("unknown op: " + this.op);
            }
        }

        public void prettyPrint(StringBuilder s) {
            s.append("(");
            this.left.prettyPrint(s);
            s.append(this.op);
            this.right.prettyPrint(s);
            s.append(")");
        }

        public Expr left() {
            return this.left;
        }

        public String op() {
            return this.op;
        }

        public Expr right() {
            return this.right;
        }
    }

    static record Variable(String name) implements Expr {
        Variable(String name) {
            this.name = name;
        }

        public int eval(Map<String, Integer> bindings) throws EvalError {
            if (bindings.containsKey(this.name)) {
                return (Integer)bindings.get(this.name);
            } else {
                throw new EvalError("undefined variable: " + this.name);
            }
        }

        public void prettyPrint(StringBuilder s) {
            s.append(this.name);
        }

        public String name() {
            return this.name;
        }
    }

    static record IntLit(int val) implements Expr {
        IntLit(int val) {
            this.val = val;
        }

        public void prettyPrint(StringBuilder s) {
            s.append(this.val);
        }

        public int eval(Map<String, Integer> bindings) {
            return this.val;
        }

        public int val() {
            return this.val;
        }
    }
}
