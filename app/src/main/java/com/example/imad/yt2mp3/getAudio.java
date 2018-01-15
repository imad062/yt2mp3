package com.example.imad.yt2mp3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class getAudio extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_audio);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff0000")));


        webView = (WebView) findViewById(R.id.audio_activity_getAudio);
        webView.getSettings().setJavaScriptEnabled(true);
        Toast.makeText(this, "This might take a while based on your connection speed.Please be patient",Toast.LENGTH_LONG).show();
        webView.loadUrl("http://api.youtube6download.top/fetch/link.php?i=" + MainActivity.videoId);
    }
}
