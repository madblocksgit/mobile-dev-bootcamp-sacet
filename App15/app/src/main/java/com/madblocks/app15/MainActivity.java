package com.madblocks.app15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText txt;
    TextToSpeech t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the TTS Engine
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        btn=findViewById(R.id.button);
        txt=findViewById(R.id.editTextTextPersonName);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // text has to be converted into speech
                t1.speak(txt.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
    public void onPause() {
        if(t1!=null) {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}