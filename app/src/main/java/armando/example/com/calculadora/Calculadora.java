package armando.example.com.calculadora;

import android.widget.EditText;
import android.text.Editable;

/**
 * Created by Armando on 04/03/2017.
 */

public class Calculadora{

    public EditText edit;
    public double acum;

    public Calculadora (EditText edit) {
        this.edit = edit;
        this.edit.setText(R.string.n0);
        this.acum = 0;
    }

    public boolean searchPoint () {
        String text = getText().toString();
        for (int i = 0; i < text.length(); i ++) {
            if(text.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    public void write (String text) {
        if((isEmpty() && !text.equals("."))) {
            edit.setText("");
        }
        edit.append(text);
    }

    public void clear() {
        if (!isEmpty() && getText().toString().toCharArray().length != 1) {
            edit.setText(getText().toString().substring(0, getText().toString().toCharArray().length - 1));
        } else {
            edit.setText("0");
        }
    }

    public void clearAll() {
        edit.setText("0");
    }

    public boolean isFill () {
        byte point;
        if (searchPoint()) point = 1; else point = 0;
        if(getText().toString().toCharArray().length - point < 15) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty () {
        if (getText().toString().isEmpty() || getText().toString().equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    public Editable getText() {
        return edit.getText();
    }

    public void suma () {

    }
}