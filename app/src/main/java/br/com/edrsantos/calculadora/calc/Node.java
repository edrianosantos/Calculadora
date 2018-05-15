package br.com.edrsantos.calculadora.calc;

import br.com.edrsantos.calculadora.utils.StringUtil;

/**
 * Created by slimv on 4/4/2018.
 */

public class Node {
    private Operator operator;
    private Node leftNode;
    private Node rightNode;
    private Double value;

    public Node(Calcular s) {
        this(s.getExpression(), s);
    }

    private Node(String s, Calcular exp) {
        this.operator = null;
        this.leftNode = null;
        this.rightNode = null;
        this.value = null;
        s = StringUtil.removeCharacters(s, new char[]{' '});
        s = this.removeBrackets(s);
        s = this.addZero(s);
        if(!this.checkBrackets(s)) {
            throw new IllegalArgumentException("Número errado de parênteses em '" + s + "'");
        } else {
            this.value = exp.getDouble(s);
            int sLength = s.length();
            int inBrackets = 0;
            int startOperator = 0;

            for(int i = 0; i < sLength; ++i) {
                if(s.charAt(i) == 40) {
                    ++inBrackets;
                } else if(s.charAt(i) == 41) {
                    --inBrackets;
                } else if(inBrackets == 0) {
                    Operator o = this.getOperator(s, i);
                    if(o != null && (this.operator == null || this.operator.getPriority() >= o.getPriority())) {
                        this.operator = o;
                        startOperator = i;
                    }
                }
            }

            if(this.operator != null) {
                if(startOperator == 0 && this.operator.getType() == Operator.Operands.SINGLE) {
                    if(this.checkBrackets(s.substring(this.operator.getOperator().length()))) {
                        this.leftNode = new Node(s.substring(this.operator.getOperator().length()), exp);
                        return;
                    }

                    throw new IllegalArgumentException("Erro ao analisar em '" + s + "'");
                }

                if(startOperator > 0 && this.operator.getType() == Operator.Operands.DOUBLE) {
                    this.leftNode = new Node(s.substring(0, startOperator), exp);
                    this.rightNode = new Node(s.substring(startOperator + this.operator.getOperator().length()), exp);
                }
            }

        }
    }

    public Operator getOperator(String s, int start) {
        Operator[] operators = Operator.values();
        String next = this.getNextWord(s.substring(start));

        for(int i = 0; i < operators.length; ++i) {
            if(next.startsWith(operators[i].getOperator())) {
                return operators[i];
            }
        }

        return null;
    }

    public String getNextWord(String s) {
        int sLength = s.length();

        for(int i = 1; i < sLength; ++i) {
            char c = s.charAt(i);
            if((c > 122 || c < 97) && (c > 57 || c < 48)) {
                return s.substring(0, i);
            }
        }

        return s;
    }

    public boolean checkBrackets(String s) {
        int brackets = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == 40 && brackets >= 0) {
                ++brackets;
            } else if(s.charAt(i) == 41) {
                --brackets;
            }
        }

        if(brackets == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String addZero(String s) {
        return !s.startsWith("+") && !s.startsWith("-")?s:"0" + s;
    }

    public void trace() {
        System.out.println(this.value != null?this.value:this.operator.getOperator());
        if(this.hasChild()) {
            if(this.hasLeft()) {
                this.getLeft().trace();
            }

            if(this.hasRight()) {
                this.getRight().trace();
            }
        }

    }

    public boolean hasChild() {
        return this.leftNode != null || this.rightNode != null;
    }

    public boolean hasOperator() {
        return this.operator != null;
    }

    public boolean hasLeft() {
        return this.leftNode != null;
    }

    public Node getLeft() {
        return this.leftNode;
    }

    public boolean hasRight() {
        return this.rightNode != null;
    }

    public Node getRight() {
        return this.rightNode;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double f) {
        this.value = f;
    }

    private String removeBrackets(String s) {
        String res = s;
        if(s.length() > 2 && s.startsWith("(") && s.endsWith(")") && this.checkBrackets(s.substring(1, s.length() - 1))) {
            res = s.substring(1, s.length() - 1);
        }

        return res != s?this.removeBrackets(res):res;
    }
}
