package br.com.edrsantos.calculadora.calc;

/**
 * Created by slimv on 4/4/2018.
 */

public enum Operator {
    PLUS("+", Operator.Operands.DOUBLE, 0) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(f1.doubleValue() + f2.doubleValue());
        }
    },
    MINUS("-", Operator.Operands.DOUBLE, 0) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(f1.doubleValue() - f2.doubleValue());
        }
    },
    TIMES("*", Operator.Operands.DOUBLE, 10) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(f1.doubleValue() * f2.doubleValue());
        }
    },
    DIV("/", Operator.Operands.DOUBLE, 10) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(f1.doubleValue() / f2.doubleValue());
        }
    },
    POW("^", Operator.Operands.DOUBLE, 10) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.pow(f1.doubleValue(), f2.doubleValue()));
        }
    },
    MOD("%", Operator.Operands.DOUBLE, 10) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(f1.doubleValue() % f2.doubleValue());
        }
    },
    COS("cos", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.cos(f1.doubleValue()));
        }
    },
    SIN("sin", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.sin(f1.doubleValue()));
        }
    },
    TAN("tan", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.tan(f1.doubleValue()));
        }
    },
    ACOS("acos", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.acos(f1.doubleValue()));
        }
    },
    ASIN("asin", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.asin(f1.doubleValue()));
        }
    },
    ATAN("atan", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.atan(f1.doubleValue()));
        }
    },
    SQRT("sqrt", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.sqrt(f1.doubleValue()));
        }
    },
    SQR("sqr", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(f1.doubleValue() * f1.doubleValue());
        }
    },
    LOG("log", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.log(f1.doubleValue()));
        }
    },
    FLOOR("floor", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.floor(f1.doubleValue()));
        }
    },
    CEIL("ceil", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.ceil(f1.doubleValue()));
        }
    },
    ABS("abs", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.abs(f1.doubleValue()));
        }
    },
    NEG("neg", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(-f1.doubleValue());
        }
    },
    RND("rnd", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.random() * f1.doubleValue());
        }
    },
    RAD("rad", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.toRadians(f1.doubleValue()));
        }
    },
    DEG("deg", Operator.Operands.SINGLE, 20) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf(Math.toDegrees(f1.doubleValue()));
        }
    },
    AND("&", Operator.Operands.DOUBLE, 30) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf((double)((int)Math.floor(f1.doubleValue()) & (int)Math.floor(f2.doubleValue())));
        }
    },
    OR("|", Operator.Operands.DOUBLE, 30) {
        public Double resolve(Double f1, Double f2) {
            return Double.valueOf((double)((int)Math.floor(f1.doubleValue()) | (int)Math.floor(f2.doubleValue())));
        }
    };

    private String op;
    private Operator.Operands type;
    private int priority;

    private Operator(String op, Operator.Operands type, int p) {
        this.op = op;
        this.type = type;
        this.priority = p;
    }

    public abstract Double resolve(Double var1, Double var2);

    public String getOperator() {
        return this.op;
    }

    public Operator.Operands getType() {
        return this.type;
    }

    public int getPriority() {
        return this.priority;
    }

    public static enum Operands {
        SINGLE,
        DOUBLE;

        private Operands() {
        }
    }
}

