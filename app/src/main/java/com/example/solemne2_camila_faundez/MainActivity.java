package com.example.solemne2_camila_faundez;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public TextView tvRe,tvOp;
    public double op1, res;
    int op=0; //Indica con n° del 1 al 5 qué tipo de operación se realiza
    int ops=0;//Indica 0 o 1 si se ha usado un operador o no.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRe=findViewById(R.id.PantallaResultado);
        tvOp=findViewById(R.id.PantallaOperacion);

    }
    public void btnC (View v){
        tvOp.setText("");
        tvRe.setText("");
        op1 =0.0;
        ops=0;
        res=0.0;
    }
    public void btnCE (View v){
        if (!tvRe.getText().toString().equals("")){
            tvRe.setText(tvRe.getText().subSequence(0, tvRe.getText().length()-1)+"");
            tvOp.setText(tvOp.getText().subSequence(0, tvOp.getText().length()-1)+"");
        }
    }
    public void btn7 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"7";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("7");}
    }
    public void btn8 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"8";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("8");}
    }
    public void btn9 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"9";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("9");}
    }
    public void btn4 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"4";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("4");}
    }
    public void btn5 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"5";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("5");}
    }
    public void btn6 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"6";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("6");}
    }
    public void btn1 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"1";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("1");}
    }
    public void btn2 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"2";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("2");}
    }
    public void btn3 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"3";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("3");}
    }
    public void btn0 (View v){
        String ms=tvRe.getText().toString();
        ms=ms+"0";
        tvRe.setText(ms);
        if(tvOp != null){tvOp.append("0");}
    }
    public void btnPunto (View v){
        String ms=tvRe.getText().toString();
        ms=ms+".";
        tvRe.setText(ms);
    }
    public void Sumar (View v){
        if(ops != 0){
            tvOp.setText("¡Error!");
            tvRe.setText("Solo operaciones con 2 operandos.");
        }
        else {
            try {
                String aux1 = tvRe.getText().toString();
                op1 = Double.parseDouble(aux1);
            }
            catch (NumberFormatException nfe) {
            }
            String cap = tvRe.getText().toString();
            tvOp.setText(cap + "+");
            tvRe.setText("");
            op = 1;
            ops=1;
        }
    }
    public void Restar (View v){
        //Verifica si ya se ha usado un operador antes de pedir el resultado.
        if(ops != 0){
            tvOp.setText("¡Error!");
            tvRe.setText("Solo operaciones con 2 operandos.");
        }
        else {
            try {
                String aux1 = tvRe.getText().toString();
                op1 = Double.parseDouble(aux1);
            } catch (NumberFormatException nfe) {
            }
            String cap = tvRe.getText().toString();
            tvOp.setText(cap + "-");
            tvRe.setText("");
            op = 2;
            ops=1;
        }
    }
    public void Multiplicar (View v){
        if(ops != 0){
            tvOp.setText("¡Error!");
            tvRe.setText("Solo operaciones con 2 operandos.");
        }
        else {
            try {
                String aux1 = tvRe.getText().toString();
                op1 = Double.parseDouble(aux1);
            } catch (NumberFormatException nfe) {
            }
            String cap = tvRe.getText().toString();
            tvOp.setText(cap + "x");
            tvRe.setText("");
            op = 3;
            ops=1;
        }
    }
    public void Dividir (View v){
        if(ops != 0){
            tvOp.setText("¡Error!");
            tvRe.setText("Solo operaciones con 2 operandos.");
        }
        else {
            try {
                String aux1 = tvRe.getText().toString();
                op1 = Double.parseDouble(aux1);
            } catch (NumberFormatException nfe) {
            }
            String cap = tvRe.getText().toString();
            tvOp.setText(cap + "/");
            tvRe.setText("");
            op = 4;
            ops=1;
        }
    }
    public void Potencia (View v){
        if(ops != 0){
            tvOp.setText("¡Error!");
            tvRe.setText("Solo operaciones con 2 operandos.");
        }
        else {
            try {
                String aux1 = tvRe.getText().toString();
                op1 = Double.parseDouble(aux1);
            } catch (NumberFormatException nfe) {
            }
            String cap = tvRe.getText().toString();
            tvOp.setText(cap + "^");
            tvRe.setText("");
            op = 5;
            ops = 1;
        }
    }

    public void btnReturn (View v){
        DB conn = new DB(this);
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ULTIMAOP", null);
        if(cursor.isClosed()){tvOp.setText(""); tvRe.setText("");}
        else{
        cursor.moveToFirst();
        String op0 = cursor.getString(cursor.getColumnIndex("OPERACION"));
        String total = cursor.getString(cursor.getColumnIndex("TOTAL"));
        db.close();
        tvOp.setText(op0);
        tvRe.setText(total);}
    }
    public void Resultado (View v) {
        try {
            double resultado = .0;
            double[] valores = new double[2];

            valores[0] = op1;
            valores[1] = Double.parseDouble(
                    tvRe.getText().toString().isEmpty() ?
                            String.valueOf(0) : tvRe.getText().toString());

            switch (op){
                case 1:
                    resultado = valores[0] + valores[1];
                    ops=0;
                    break;
                case 2:
                    resultado = valores[0] - valores[1];
                    ops=0;
                    break;
                case 3:
                    resultado = valores[0] * valores[1];
                    ops=0;
                    break;
                case 4:
                    resultado = valores[0] / valores[1];
                    ops=0;
                    break;
                case 5:
                    resultado = Math.pow(valores[0], valores[1]);
                    ops=0;
                    break;
            }

            res = resultado;
            String total = String.valueOf(resultado);

            //Quita el ".0" si el número es entero.
            if((resultado % 1) == 0)
                total = total.substring(0, total.length()-2);

            tvRe.setText(total);
            //Guardar operación en DB para luego mostrar en Return.
            DB conn = new DB(this);
            SQLiteDatabase db = conn.getWritableDatabase();
            db.delete("ULTIMAOP",null,null);
            ContentValues contenido = new ContentValues();
            contenido.put("OPERACION", tvOp.getText().toString());
            contenido.put("TOTAL", tvRe.getText().toString());
            //db.insert("ULTIMAOP", null, contenido);

            Long idResul = db.insert("ULTIMAOP",null,contenido);

            Toast.makeText(getApplicationContext(),"Id reg: "+idResul,Toast.LENGTH_SHORT).show();
            db.close();
        }
        catch (IndexOutOfBoundsException | NumberFormatException ex){
            tvRe.setText("¡Error! Operación inválida");
        }

    }

}


