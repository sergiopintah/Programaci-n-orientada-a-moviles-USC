package com.example.proyecto003;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton R1, R2, R3, R4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        tv1=findViewById(R.id.tv1);
        R1=findViewById(R.id.R1);
        R2=findViewById(R.id.R2);
        R3=findViewById(R.id.R3);
        R4=findViewById(R.id.R4);
    }

    public void operar(View view){

        et1.setError(null);
        et2.setError(null);

        String valor1=et1.getText().toString();
        String valor2=et2.getText().toString();

        if("".equals(valor1))
        {
            et1.setError("Ingrese números");
            et1.requestFocus();
            return;
        }else if("".equals(valor2))
        {
            et2.setError("Ingrese números");
            et2.requestFocus();
            return;
        }

        double nro1=Double.parseDouble(valor1);
        double nro2=Double.parseDouble(valor2);



        if (R1.isChecked()==true) {
            double suma=nro1+ nro2;
            String resu=String.valueOf(suma);
            tv1.setText(resu);
        } else
        if (R2.isChecked()==true) {
            double resta=nro1-nro2;
            String resu=String.valueOf(resta);
            tv1.setText(resu);
        } else
        if (R3.isChecked()==true) {
            double multiplicacion=nro1*nro2;
            String resu=String.valueOf(multiplicacion);
            tv1.setText(resu);
        } else
        if (R4.isChecked()==true) {
            if (nro1 == 0){
                et1.setError("Ingrese un numero mayor a 0");
            }
            else if (nro2 == 0){
                et2.setError("Ingrese un numero mayor a 0");
            } else{
                double division=nro1/nro2;
                String resu=String.valueOf(division);
                tv1.setText(resu);
            }
        }
    }
}