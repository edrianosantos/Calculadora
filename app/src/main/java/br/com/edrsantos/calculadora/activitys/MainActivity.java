package br.com.edrsantos.calculadora.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.edrsantos.calculadora.R;
import br.com.edrsantos.calculadora.calc.Calcular;

public class MainActivity extends AppCompatActivity {

    TextView result;
    Button btnSoma;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnPonto;
    Button btnC;
    Button btnIgual;
    Button btnDel;
    Button btnPercent;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;

    boolean isCalcular = false;
    boolean isMenuShare = false;
    String percent = "";
    List<String> op;

    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        result = (TextView) findViewById(R.id.result);

        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnPonto = (Button) findViewById(R.id.btnPonto);
        btnC = (Button) findViewById(R.id.btnC);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnPercent = (Button) findViewById(R.id.btnPercent);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    if (verificaCaracter("+") || result.getText().toString().endsWith("%")) {
                        String aux = result.getText().toString();
                        aux += "+";
                        op.add("+");
                        isCalcular = true;
                        result.setText(aux);
                    }
                } catch (Exception e) {
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (verificaCaracter("-") || result.getText().toString().endsWith("%")) {
                        String aux = result.getText().toString();
                        aux += "-";
                        op.add("-");
                        isCalcular = true;
                        result.setText(aux);
                    }
                } catch (Exception e) {
                }

            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (verificaCaracter("x")) {
                        String aux = result.getText().toString();
                        aux += "x";
                        op.add("x");
                        isCalcular = true;
                        result.setText(aux);
                    }
                } catch (Exception e) {
                }

            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (verificaCaracter("÷")) {
                        String aux = result.getText().toString();
                        aux += "÷";
                        op.add("÷");
                        isCalcular = true;
                        result.setText(aux);
                    }
                } catch (Exception e) {
                }

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int tamanho = result.getText().length();
                    if (tamanho > 0) {
                        result.setText(result.getText().toString().substring(0, tamanho - 1));
                        isMenuShare = false;
                        percent = "";
                    }

                } catch (Exception e) {
                }

            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (result.getText().toString().contains("%"))
                        return;
                    if (verificaCaracter("%") || op.size() != 1) {
                        isCalcular = true;
                        calcPrecent();
                    }
                } catch (Exception e) {
                }

            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    calcular();
                } catch (Exception e) {
                }

            }
        });

        btnPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificaCaracter(".")) {
                    String aux = result.getText().toString();
                    aux += ".";
                    result.setText(aux);
                }
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estadoInicial();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(9);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (op == null)
            op = new ArrayList<>();
    }

    private void calcPrecent() {
        try {
            int soma = result.getText().toString().lastIndexOf("+");
            int sub = result.getText().toString().lastIndexOf("-");
            int mult = result.getText().toString().lastIndexOf("x");
            int div = result.getText().toString().lastIndexOf("÷");

            double valor = 0;
            double porcentagem = 0;
            double resultado = 0;

            if (soma > sub && soma > mult && soma > div) {
                valor = calculateString(result.getText().toString().substring(0, soma));
                porcentagem = calculateString(result.getText().toString().substring(soma + 1));
                resultado = valor + ((valor * porcentagem) / 100);
            }

            if (sub > soma && sub > mult && sub > div) {
                valor = calculateString(result.getText().toString().substring(0, sub));
                porcentagem = calculateString(result.getText().toString().substring(sub + 1));
                resultado = valor - ((valor * porcentagem) / 100);
            }

            if (mult > soma && mult > sub && mult > div) {
                valor = calculateString(result.getText().toString().substring(0, mult));
                porcentagem = calculateString(result.getText().toString().substring(mult + 1));
                resultado = valor * ((valor * porcentagem) / 100);
            }

            if (div > soma && div > sub && div > mult) {
                valor = calculateString(result.getText().toString().substring(0, div));
                porcentagem = calculateString(result.getText().toString().substring(div + 1));
                resultado = valor / ((valor * porcentagem) / 100);
            }

            if (resultado != 0) {
                isMenuShare = true;
                percent = "%";

                this.result.setText(decimalFormat.format(resultado).replaceAll("[,]", "."));
            }

            isCalcular = false;
        } catch (Exception e) {
        }

    }

    private boolean verificaCaracter(String caracter) {
        try {
            int ultCarac = 0;
            ultCarac = result.getText().toString().length();
            String[] caracterVetor = new String[ultCarac];
            String aux = result.getText().toString();

            for (int i = 0; i < ultCarac; i++) {
                caracterVetor[i] = aux.substring(i, i + 1);
            }

            if (ultCarac == 0 && caracter.equalsIgnoreCase(".")) {
                return false;
            }

            if (caracterVetor[ultCarac - 1].equalsIgnoreCase("+") || caracterVetor[ultCarac - 1].equalsIgnoreCase("%") ||
                    caracterVetor[ultCarac - 1].equalsIgnoreCase("-") ||
                    caracterVetor[ultCarac - 1].equalsIgnoreCase("x") || caracterVetor[ultCarac - 1].equalsIgnoreCase("÷") ||
                    caracterVetor[ultCarac - 1].equalsIgnoreCase(".")) {
                return false;
            }

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private void calcular() {
        try {
            double valorFinal = 0;
            String calculo = result.getText().toString();
            valorFinal = calculateString(calculo);
            if (isCalcular) {
                isMenuShare = true;
                String total = decimalFormat.format(valorFinal);
                this.result.setText(total);

                if (valorFinal == Double.parseDouble("Infinity")) {
                    Toast.makeText(this, "Divisão por 0 \"ZERO\" não é permitido.", Toast.LENGTH_LONG).show();
                }
            }

            isCalcular = false;
        } catch (Exception e) {
        }

    }

    private double calculateString(String expression) {
        try {
            expression = expression.replaceAll("[x]", "*").replaceAll("[÷]", "/").replaceAll("[,]", ".");
            double result = 0;

            if (percent.trim().length() > 0 && percent.trim().equalsIgnoreCase("%")) {
                expression = this.result.getText().toString();
                percent = "";
            }

            char chr = expression.charAt(expression.length() - 1);
            if (!Character.isDigit(chr))
                expression = expression.substring(0, expression.length() - 1);


            Calcular calc = new Calcular(expression);
            result = calc.resolve();
            isCalcular = true;

            return result;
        } catch (Exception e) {
            return 0;
        }

    }

    private void estadoInicial() {
        isCalcular = false;
        isMenuShare = false;
        percent = "";
        result.setText("");
        op.clear();
    }

    public void click(int num_lido) {
        String total = result.getText().toString() + num_lido;
        result.setText(total);
    }

}
