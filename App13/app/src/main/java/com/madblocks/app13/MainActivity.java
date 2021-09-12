package com.madblocks.app13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText phoneNo;
    EditText msg;
    String phoneNumber, msgString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.button);
        phoneNo=findViewById(R.id.editTextPhone);
        msg=findViewById(R.id.editTextTextPersonName);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber=phoneNo.getText().toString();
                msgString=msg.getText().toString();
                if(ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber,null,msgString,null,null);
                Toast.makeText(MainActivity.this,"SMS Sent",Toast.LENGTH_SHORT).show();
            }
        });


    }
}