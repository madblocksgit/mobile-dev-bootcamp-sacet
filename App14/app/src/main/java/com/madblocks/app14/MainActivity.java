package com.madblocks.app14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String[] to={"mad@madblocks.tech"};
        String[] cc={"info@madblocks.tech"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        emailIntent.putExtra(Intent.EXTRA_CC,cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Email from App");
        emailIntent.putExtra(Intent.EXTRA_TEXT,"Hello, Bootcamp is going great");

        try {
            startActivity(Intent.createChooser(emailIntent,"Send Email..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,"install client",Toast.LENGTH_SHORT).show();
        }

    }
}