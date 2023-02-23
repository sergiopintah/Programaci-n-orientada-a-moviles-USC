package com.example.holamundo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private TextView view_name;
    private TextView view_id;
    private TextView view_curso;

    private EditText field_text_name;
    private EditText field_text_id;
    private EditText field_text_curso;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        field_text_name = findViewById(R.id.text_name);


    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText = (EditText) findViewById(R.id.text_name);
        String messageName = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, messageName);
        startActivity(intent);
    }

}