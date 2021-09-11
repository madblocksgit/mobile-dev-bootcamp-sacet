package com.madblocks.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitButton,resetButton;
    TextView message; // local variables are to be binded with the physical object
    String s="Hello Maddy!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton=findViewById(R.id.submitButton);
        resetButton=findViewById(R.id.resetButton);
        message=findViewById(R.id.textView1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("Hello Maddy!");
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message.setText("");
            }
        });
    }
}