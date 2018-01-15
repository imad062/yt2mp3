package com.example.imad.yt2mp3;

import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String videoUrl = "https://www.youtube.com/watch?v=CkmVIXnxquw";

    public static String videoId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff0000")));

        editText = (EditText) findViewById(R.id.ytlink_activity_main);

        ClipboardManager clipMan = (ClipboardManager)getSystemService(MainActivity.this.CLIPBOARD_SERVICE);
        editText.setText(clipMan.getText());

    }

    public void getVideoId()
    {
        videoId = "";
        for(int i = 0; i < videoUrl.length() ; i++)
        {
            if(videoUrl.charAt(i) == 'w' && videoUrl.charAt(i+1) == 'a' && videoUrl.charAt(i+2) == 't' && videoUrl.charAt(i+3) == 'c' && videoUrl.charAt(i+4) == 'h' && videoUrl.charAt(i+5) == '?' && videoUrl.charAt(i+6) == 'v' && videoUrl.charAt(i+7) == '=')
            {
                for(int j = i+8; j <= i+18; j++)
                {
                    videoId = videoId + videoUrl.charAt(j) + "";
                }
                return;
            }
        }

        Toast.makeText(MainActivity.this, "Not A Valid URL", Toast.LENGTH_LONG).show();
    }

    public void clickedOnGetAudio(View view)
    {
        if(videoUrl.equals(""))
        {
            Toast.makeText(MainActivity.this, "No link given", Toast.LENGTH_LONG).show();
        }
        else {
            videoUrl = editText.getText().toString();
            getVideoId();

            Intent intent = new Intent(MainActivity.this, getAudio.class);
            startActivity(intent);
        }
    }

}

