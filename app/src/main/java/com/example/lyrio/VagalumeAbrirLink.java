package com.example.lyrio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class VagalumeAbrirLink extends AppCompatActivity {

//    private TextView hotspotText;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot_abrir_link);

//        hotspotText = findViewById(R.id.hotspot_textview);
        webView = findViewById(R.id.hotspot_webview);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String url = bundle.getString("HOTSPOT_LINK");

//        hotspotText.setText(url);

        WebSettings ws = webView.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);
        webView.loadUrl(url);

    }


}
