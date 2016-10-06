package com.example.mmizukami.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static com.example.mmizukami.alohamusic.R.raw.hula;

public class MediaActivity extends AppCompatActivity {

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    private VideoView hulaVideoView;

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;
   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ukuleleButton =(Button) findViewById(R.id.ukuleleButton);
        ipuButton =(Button) findViewById(R.id.ipuButton);
        hulaButton = (Button)findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView)findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName()+"/" + hula));
        hulaVideoView.setMediaController(new MediaController(this));

    // Associate the mediaPlayer objects with the raw files
        ukuleleMP = MediaPlayer.create(this,R.raw.ukulele);
        ipuMP = MediaPlayer.create(this,R.raw.ipu);



    }

    public void playMedia(View view)
    {
        // Determine which button is clicked
        switch (view.getId())
        {
            case R.id.ukuleleButton:
                if(ukuleleMP.isPlaying())
                {
                    ukuleleMP.pause();
                    // show the other two button
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                }
                else
                {
                    ukuleleMP.start();
                    ipuButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                }
                break;
            case R.id.ipuButton:
                if(ipuMP.isPlaying())
                {
                    ipuMP.pause();
                    // show the other two button
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);
                    ipuButton.setText(R.string.ipu_button_play_text);
                }
                else
                {
                    ipuMP.start();
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                    ipuButton.setText(R.string.ipu_button_pause_text);
                }



                break;
            case R.id.hulaButton:
                if(hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);

                }
                break;





        }

    }

}
