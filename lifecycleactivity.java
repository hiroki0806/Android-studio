package a5817076.aoyama.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onDestroy() {
        Log.v(TAG,"メッセージonDestroy");
        super.onDestroy();
    }
    @Override
    protected void onStop() {
        Log.v(TAG,"メッセージonStop");
        super.onStop();

    }
    @Override
    protected void onPause() {
        Log.v(TAG,"メッセージonPause");
        super.onPause();
    }
    @Override
    protected void onResume() {
        Log.v(TAG,"メッセージonResume");
        super.onResume();
    }
    @Override
    protected void onRestart() {
        Log.v(TAG,"メッセージonRestart");
        super.onRestart();
    }
    @Override
    protected void onStart() {
        Log.v(TAG,"メッセージonStart");
        super.onStart();
    }
}
