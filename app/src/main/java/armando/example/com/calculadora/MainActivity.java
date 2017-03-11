package armando.example.com.calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    Button[] numeros = new Button[17];
    int[] ids = new int[17];
    Button erase;
    Button clear;
    Button equal;
    EditText edit;
    Calculadora c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ids[0] = R.id.n0;
        ids[1] = R.id.n1;
        ids[2] = R.id.n2;
        ids[3] = R.id.n3;
        ids[4] = R.id.n4;
        ids[5] = R.id.n5;
        ids[6] = R.id.n6;
        ids[7] = R.id.n7;
        ids[8] = R.id.n8;
        ids[9] = R.id.n9;
        ids[10] = R.id.punto;
        ids[11] = R.id.suma;
        ids[12] = R.id.resta;
        ids[13] = R.id.multi;
        ids[14] = R.id.div;
        ids[15] = R.id.potencia;
        ids[16] = R.id.porcentaje;
        for(int i = 0; i < numeros.length ; i++) {
            numeros[i] = (Button) findViewById(ids[i]);
            numeros[i].setOnClickListener(this);
        }
        edit = (EditText) findViewById(R.id.valor);
        erase = (Button) findViewById(R.id.erase);
        clear = (Button) findViewById(R.id.clear);
        equal = (Button) findViewById(R.id.equal);
        erase.setOnClickListener(this);
        clear.setOnClickListener(this);
        equal.setOnClickListener(this);
        c = new Calculadora(edit);
    }

    @Override
    public void onClick(View v) {
        if (c.isFill()) {
            switch(v.getId()) {
                case R.id.n1: c.write("1"); break;
                case R.id.n2: c.write("2"); break;
                case R.id.n3: c.write("3"); break;
                case R.id.n4: c.write("4"); break;
                case R.id.n5: c.write("5"); break;
                case R.id.n6: c.write("6"); break;
                case R.id.n7: c.write("7"); break;
                case R.id.n8: c.write("8"); break;
                case R.id.n9: c.write("9"); break;
                case R.id.n0: c.write("0"); break;
                case R.id.punto:
                    if (!c.searchPoint()) {
                        c.write(".");
                    }
                    break;
                case R.id.erase: c.clear(); break;
                case R.id.clear: c.clearAll(); break;
                case R.id.suma:
                    c.write("+");
                    c.suma();
                    break;
                case R.id.resta: break;
                case R.id.multi: break;
                case R.id.div: break;
                case R.id.potencia: break;
                case R.id.porcentaje: break;
                case R.id.equal: break;
            }
        } else {
            Toast.makeText(this, R.string.fill, Toast.LENGTH_SHORT).show();
            switch(v.getId()) {
                case R.id.erase: c.clear(); break;
                case R.id.clear: c.clearAll(); break;
            }
        }
    }
}
