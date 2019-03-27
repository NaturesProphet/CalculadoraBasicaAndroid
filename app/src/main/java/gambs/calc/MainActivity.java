package gambs.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed1, ed2;
    private Button sum, mult, div, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.ed1 = findViewById(R.id.ed1);
        this.ed2 = findViewById(R.id.ed2);
        this.sum = findViewById(R.id.sumButt);
        this.mult = findViewById(R.id.multButt);
        this.div = findViewById(R.id.divButt);
        this.sub = findViewById(R.id.subButt);
    }

    /**
     * Executa a soma dos dois campos de texto
     *
     * @param view view
     */
    public void soma(View view) {
        this.calcula('+');
    }

    /**
     * Executa a subtração dos dois campos de texto
     *
     * @param view view
     */
    public void subtrai(View view) {
        this.calcula('-');
    }

    /**
     * Executa a multiplicação dos dois campos de texto
     *
     * @param view view
     */
    public void multiplica(View view) {
        this.calcula('x');
    }

    /**
     * Executa a divisão dos dois campos de texto
     *
     * @param view view
     */
    public void divide(View view) {
        this.calcula('/');
    }

    /**
     * Método genérico que reaproveita código para executar as 4 operações aritiméticas básicas
     *
     * @param metodo char representando a operação a ser executada: { '+', '-', '/', 'x' }
     */
    private void calcula(char metodo) {

        boolean success = true;

        double val1 = 0, val2 = 0, resp = 0;

        try {
            val1 = Double.parseDouble("" + this.ed1.getText());
        } catch (Exception ex) {
            Toast.makeText(this, "Valor invalido no primeiro TextEdit:\n" + ed1.getText(), Toast.LENGTH_SHORT).show();
            ed1.setText(null);
            success = false;
        }
        if (success) {
            try {
                val2 = Double.parseDouble("" + this.ed2.getText());
            } catch (Exception ex) {
                Toast.makeText(this, "Valor invalido no segundo TextEdit:\n" + ed2.getText(), Toast.LENGTH_SHORT).show();
                ed2.setText(null);
                success = false;
            }
            try {
                switch (metodo) {
                    case '+':
                        if (success) {
                            resp = val1 + val2;
                        }
                        break;
                    case '-':
                        if (success) {
                            resp = val1 - val2;
                        }
                        break;
                    case '/':
                        if (success) {
                            if (val2 != 0) {
                                resp = val1 / val2;
                            } else {
                                success = false;
                                throw new Exception("Divisão por zero não permitida");
                            }
                        }
                        break;
                    case 'x':
                        if (success) {
                            resp = val1 * val2;
                        }
                        break;
                    default:
                        Toast.makeText(this, "Operação inválida. use os chars +,-,x,/", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception ex) {
                Toast.makeText(this, "Operação impossível com os recursos atuais: " + ex.getMessage(), Toast.LENGTH_LONG).show();
            }
            ed1.setText("" + resp);
            ed2.setText(null);
            if (success) Toast.makeText(this, "operação concluída", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Limpa os dois campos de edição texto da view
     *
     * @param view view
     */
    public void clear(View view) {
        ed1.setText(null);
        ed2.setText(null);
    }

}


