package br.com.edrsantos.calculadora.calc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by slimv on 4/4/2018.
 */

public class Calcular {
    private String expression = null;
    private Map<String, Double> variables = new HashMap();

    public Calcular() {
    }

    public Calcular(String s) {
        this.setExpression(s);
    }

    public void setVariable(String v, double val) {
        this.variables.put(v, new Double(val));
    }

    public void setExpression(String s) {
        this.expression = s;
    }

    public Double resolve() {
        if(this.expression == null) {
            return null;
        } else {
            try {
                return evaluate(new Node(this));
            } catch (Exception var2) {
                var2.printStackTrace();
                return null;
            }
        }
    }

    private static Double evaluate(Node n) {
        if(n.hasOperator() && n.hasChild()) {
            if(n.getOperator().getType() == Operator.Operands.SINGLE) {
                n.setValue(n.getOperator().resolve(evaluate(n.getLeft()), (Double)null));
            } else if(n.getOperator().getType() == Operator.Operands.DOUBLE) {
                n.setValue(n.getOperator().resolve(evaluate(n.getLeft()), evaluate(n.getRight())));
            }
        }

        return n.getValue();
    }

    public Double getVariable(String s) {
        return (Double)this.variables.get(s);
    }

    public Double getDouble(String s) {
        if(s == null) {
            return null;
        } else {
            try {
                return new Double(Double.parseDouble(s));
            } catch (Exception var3) {
                return this.getVariable(s);
            }
        }
    }

    public String getExpression() {
        return this.expression;
    }
}
