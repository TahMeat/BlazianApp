package com.example.BlazianApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPin extends AppCompatActivity {

    EditText editTextTextPassword3;
    Button button, forgot;

    String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpin);

        SharedPreferences settings = getSharedPreferences("PIN", Context.MODE_PRIVATE);
        pin = settings.getString("Pin","");
        RecordFragment recordFragment = MainActivity.getInstance().recordFragment;
        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3);
        button = findViewById(R.id.button);
        forgot = findViewById(R.id.button3);

        button.setOnClickListener(view -> {
            String text = editTextTextPassword3.getText().toString();
            if(text.equals(pin))
            {
                MainActivity.getInstance().replaceFragment(recordFragment, "fragRecord");
                finish();
            }
            else
            {
                Toast.makeText(EnterPin.this,"Wrong pin. Please try again",Toast.LENGTH_SHORT).show();
            }
        });

        forgot.setOnClickListener(view ->{
            Intent intent = new Intent(getApplicationContext(), forgotPin.class);
            startActivity(intent);
            finish();
        });


    }
}