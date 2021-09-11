package com.madblocks.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1,cb2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1=findViewById(R.id.checkBox); // apple
        cb2=findViewById(R.id.checkBox2); // orange
        btn=findViewById(R.id.button); // submit

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() && cb2.isChecked()) {
                    Toast.makeText(MainActivity.this,"Both Apple and Orange were selected",Toast.LENGTH_SHORT).show();
                } else if(cb1.isChecked()) {
                    Toast.makeText(MainActivity.this,"Apple is Selected",Toast.LENGTH_SHORT).show();
                } else if(cb2.isChecked()) {
                    Toast.makeText(MainActivity.this,"Orange is Selected",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,"No fruit is selected",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}