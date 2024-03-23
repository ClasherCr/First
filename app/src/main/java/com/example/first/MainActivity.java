package com.example.first;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText passwoed;
    EditText email;
    ImageButton btn;
    Button btn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        passwoed = findViewById(R.id.password);
        email = findViewById(R.id.email);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.forgot);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputname = name.getText().toString();
                String inputpassword = passwoed.getText().toString();
                String inputemail = email.getText().toString();
                Toast.makeText(MainActivity.this, "Welcome " + inputname + " to my app", Toast.LENGTH_SHORT).show();
                goTohomeactivity();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTosecondActivity();
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void goTosecondActivity() {
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
    public void goTohomeactivity(){
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
    }

}