package com.madblocks.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView web1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web1=findViewById(R.id.web1);
        web1.setWebViewClient(new WebViewClient());
        web1.loadUrl("https://google.com");
    }
}