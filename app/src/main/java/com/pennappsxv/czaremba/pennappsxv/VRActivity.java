package com.pennappsxv.czaremba.pennappsxv;

import android.app.Activity;
import android.app.VoiceInteractor;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;
import com.google.vr.sdk.widgets.video.VrVideoView;

import java.io.IOException;

/**
 * Created by czaremba on 2017-01-20.
 */

public class VRActivity extends Activity {
    MenuActivity menuActivity = new MenuActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr);
        VrVideoView vr = (VrVideoView) findViewById(R.id.video_view);
        VrVideoView.Options options = new VrVideoView.Options();
        options.inputType = VrVideoView.Options.TYPE_MONO;
        options.inputFormat = VrVideoView.Options.FORMAT_HLS;
        try {
            int videoID = this.getRawResIdByName("congo", VRActivity.this);
            Uri uri = Uri.parse("android.resource://" + VRActivity.this.getPackageName() + "/" + videoID);
            vr.loadVideo(uri, options);

            vr.playVideo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getRawResIdByName(String resName, Context context) {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }


}
