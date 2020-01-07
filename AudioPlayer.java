package jp.aoyama.a5817076.thaudioplayer;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActionBar;
import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.IOException;

import a5817076.aoyama.thaudioplayer.R;

public class MainActivity extends Activity {

    private MediaPlayer mp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.kalimba);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.th_audio_menu,menu);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_setting:
                TextView setting = findViewById(R.id.back);
                setting.append("Setting\n");
                break;
            case R.id.action_edit:
                TextView editting = findViewById(R.id.back);
                editting.append("Edit\n");
                break;
            case R.id.action_preview:
                TextView preview = findViewById(R.id.back);
                preview.append("Preview\n");
                break;
            case R.id.action_save:
                TextView saving = findViewById(R.id.back);
                saving.append("Save\n");
                break;
            case android.R.id.home:
                TextView back = findViewById(R.id.back);
                back.append("back\n");
                break;
        }
        return true;
    }

    public void playClick (View v) throws IOException {
        if (v.getId() == R.id.play_btn) {
            TextView btn_pre =  findViewById(R.id.back);

            mp.start();
            //btn_pre.setText(R.string.play_pressed);
            StringBuffer str = new StringBuffer();
            str.append("Media Duration is " + mp.getDuration()/1000/60 + ":" + mp.getDuration()/1000%60);
            str.append("\n\n");
            TextView media = findViewById(R.id.back);
            media.setText(str);
        }
    }

    public void stopClick (View v2) throws IOException {
        if (v2.getId() == R.id.stop_btn) {
            TextView btn_pre =  findViewById(R.id.back);
            mp.stop();
            //btn_pre.setText(R.string.stop_pressed);
            mp = MediaPlayer.create(this, R.raw.kalimba);
        }
    }
    public void pauseClick (View v2){
        if (v2.getId() == R.id.pause_btn) {
            //btn_pre.setText(R.string.pause_pressed);
            TextView media = findViewById(R.id.back);
            StringBuffer str = new StringBuffer();
            str.append("    Media Duration is " + mp.getDuration()/1000/60 + ":" + mp.getDuration()/1000%60);
            str.append("\n\n");
            media.setText(str);
            media.append("  Current Position is " + mp.getCurrentPosition()/1000/60 + ":" + mp.getCurrentPosition()/1000%60);
            mp.pause();
        }
    }

}
