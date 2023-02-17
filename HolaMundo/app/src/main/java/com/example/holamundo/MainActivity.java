package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView view_name;
    private TextView view_id;
    private TextView view_curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_name = findViewById(R.id.text_view_name);
        view_id = findViewById(R.id.text_view_id);
        view_curso = findViewById(R.id.text_view_curso);

    }


    public void mostrarInformacion(View view){
        view_name.setText("Sergio Iván Pinta Higuita");
        view_id.setText("CC 1143878432");
        view_curso.setText("POM 2023A");
    }
}