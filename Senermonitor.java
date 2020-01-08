package jp.aoyama.a5817076.thsensormonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity  implements SensorEventListener {

    private TextView textView,textView2,textView3,textView4;
    private SensorManager sma;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        textView2 = findViewById(R.id.text_view2);
        textView3 = findViewById(R.id.text_view3);
        textView4 = findViewById(R.id.text_view4);
        textView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        textView4.setVisibility(View.INVISIBLE);
        sma=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        sma.registerListener(this, sma.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_FASTEST);

    }


    @Override
    protected void onPause() {
        super.onPause();
        sma.unregisterListener(this);
    }

        public void onSensorChanged(SensorEvent event){

            long ltime=0;

            StringBuffer info = new StringBuffer();
            info.append(event.sensor.getName());
            info.append("\n");
            info.append("Type: ");
            info.append(event.sensor.getStringType());
            info.append("\n");
            info.append("Vendor: ");
            info.append(event.sensor.getVendor());
            info.append("\n");
            info.append("Version: ");
            info.append(event.sensor.getType());
            info.append("\n");
            float fData = event.sensor.getResolution();
            info.append("Resolution: ");
            fData = event.sensor.getResolution();
            info.append(String.valueOf(fData));
            info.append("\n");
            info.append("MaxRange: ");
            fData = event.sensor.getMaximumRange();
            info.append(String.valueOf(fData));
            info.append("\n");
            info.append("Power: ");
            fData = event.sensor.getPower();
            info.append(String.valueOf(fData));
            info.append(" mA\n");
            long ctime =System.currentTimeMillis();
            info.append("Sampling interval: ");
            info.append(ctime - ltime);
            info.append("msec\n");
            ltime = ctime;

            if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                double x= event.values[0];
                double y= event.values[1];
                double z= event.values[2];

                String strTmp="\nx="+x+"\ny="+ y+"\nz="+z;
                textView.setText(info);
                textView.append(strTmp);
            }
            else if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                double x= event.values[0];
                String strTmp="Luminesence="+x+"Lux";
                textView2.setText(info);
                textView2.append(strTmp);
            }
            else if(event.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){
                double x= event.values[0];
                double y= event.values[1];
                double z= event.values[2];

                String strTmp="\nx="+x+"\ny="+ y+"\nz="+z;
                textView3.setText(info);
                textView3.append(strTmp);
            }
            else if(event.sensor.getType()==Sensor.TYPE_GYROSCOPE){
                double x= event.values[0];
                double y= event.values[1];
                double z= event.values[2];

                String strTmp="\nx="+x+"\ny="+ y+"\nz="+z;
                textView4.setText(info);
                textView4.append(strTmp);
            }


        }
        public void onAccuracyChanged(Sensor sensor, int accuracy){
            // TODO Auto-generated method stub
        }

    public void myBtnClick(View v){
        if(v.getId()==R.id.acc){
            sma.unregisterListener(this);
            sma.registerListener(this, sma.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_FASTEST);

            textView.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.velocity){
            sma.unregisterListener(this);
            sma.registerListener(this, sma.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_FASTEST);

            textView.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.ele){
            sma.unregisterListener(this);
            sma.registerListener(this, sma.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_FASTEST);

            textView.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.VISIBLE);
            textView4.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.carve) {
            sma.unregisterListener(this);
            sma.registerListener(this, sma.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_FASTEST);

            textView.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            textView4.setVisibility(View.VISIBLE);

        }
    }


}

