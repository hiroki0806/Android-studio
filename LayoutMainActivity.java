package a5817076.aoyama;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LayoutMainActivity extends Activity {
    Button myButton;
    Button myButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        myButton = findViewById(R.id.my_button);
        myButton.setText(R.string.btn_str);
        myButton2 = findViewById(R.id.my_button2);
        myButton2.setText(R.string.btn_str2);
    }


    public void myBtnClick(View v){
        if (v.getId() == R.id.my_button) {
            TextView btn_pre = (TextView) findViewById(R.id.btn_pre);
            btn_pre.setText(R.string.btn_pressed);
        }
    }

    public void myBtn2Click(View v2){
        if (v2.getId() == R.id.my_button2) {
            TextView btn_pre = (TextView) findViewById(R.id.btn_pre);
            btn_pre.setText(R.string.btn_pressed2);
        }
    }
}

