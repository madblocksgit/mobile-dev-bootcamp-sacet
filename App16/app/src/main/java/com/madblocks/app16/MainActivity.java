package com.madblocks.app16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        result=findViewById(R.id.textView2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sttIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.UK);
                sttIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                sttIntent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Boss,Speak");
                try {
                    startActivityForResult(sttIntent,100);
                } catch(ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(),"Your device is not supported",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        switch (requestCode) {
            case 100: {
                if(resultCode==RESULT_OK && data!=null) {
                    ArrayList result1=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    result.setText(result1.get(0).toString());
                }
            }
        }
    }
}