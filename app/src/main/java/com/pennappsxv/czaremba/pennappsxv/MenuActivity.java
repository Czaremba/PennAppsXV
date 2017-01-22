package com.pennappsxv.czaremba.pennappsxv;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu);
        VideoView background = (VideoView) findViewById(R.id.videoView);
        setupVideoAndPlay(background, MenuActivity.this);
    }

    public void startDonate(View v){
        Intent i = new Intent(MenuActivity.this, VRActivity.class);
        startActivity(i);
    }

    public void setupVideoAndPlay(VideoView videoView, Context context){
        int videoID = this.getRawResIdByName("footage", context);
        videoView.setVideoURI(Uri.parse("android.resource://" + context.getPackageName() + "/" + videoID));
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    public int getRawResIdByName(String resName, Context context) {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    public void startVR(View v){
        //changeLayoutInSameXML();
    }

    /*public void changeLayoutInSameXML(){
        //Buttons to disappear:
        //Button vrButton = (Button) findViewById(R.id.vrExperience);
        Button donateButton = (Button) findViewById(R.id.donateButton);

        //Buttons to appear:
        Button colourblindnessButton = (Button) findViewById(R.id.colourblindnessButton);
        Button diabeticButton = (Button) findViewById(R.id.diabeticButton);
        Button glaucomaButton = (Button) findViewById(R.id.glaucomaButton);

        //Make these buttons disappear:
        vrButton.setEnabled(false);
        vrButton.setVisibility(View.INVISIBLE);

        donateButton.setEnabled(false);
        donateButton.setVisibility(View.INVISIBLE);

        //Make these buttons appear:
        colourblindnessButton.setEnabled(true);
        colourblindnessButton.setVisibility(View.VISIBLE);

        diabeticButton.setEnabled(true);
        diabeticButton.setVisibility(View.VISIBLE);

        glaucomaButton.setEnabled(true);
        glaucomaButton.setVisibility(View.VISIBLE);
    }*/

}
