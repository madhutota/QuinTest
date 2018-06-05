package com.dev.quintest.sensors;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.quintest.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class SensorTestActivity extends Activity implements SensorEventListener {
    public static final String TAG = SensorTestActivity.class.getSimpleName();
    private SensorManager sensorManager;
    private boolean color = false;
    private View view;
    private long lastUpdate;
    private TextView tv_first;
    private TextView tv_second;
    private TextView tv_third;

    private Double[] dataPoints;
    private GraphView graphView;
    private BarGraphSeries series;
    private double graph2LastXValue = 5d;
    LineGraphSeries<DataPoint> linearGraphSeries;
    GraphView graph;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_test);
        view = findViewById(R.id.textView);
        view.setBackgroundColor(Color.GREEN);

        tv_first = findViewById(R.id.tv_first);
        tv_second = findViewById(R.id.tv_second);
        tv_third = findViewById(R.id.tv_third);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lastUpdate = System.currentTimeMillis();

        /*series = new BarGraphSeries(new GraphView.GraphViewData[] {
        });
        graphView = new LineGraphView(
                this // context
                , "Acceleration" // heading
        );
        graphView.addSeries(series); // data
        graphView.setViewPort(1, 10);
        graphView.setManualYAxisBounds(20,1);
        graphView.setScalable(true);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        layout.addView(graphView);

        dataPoints = new Double[500];*/


      graph = (GraphView) findViewById(R.id.graph);





    }



    /*Sensor.TYPE_GYROSCOPE

Sensor.TYPE_MAGNETIC_FIELD

Sensor.TYPE_ORIENTATION

Sensor.TYPE_ACCELEROMETER*/
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            getAccelerometer(event);
        }

    }

    @SuppressLint("SetTextI18n")
    private void getAccelerometer(SensorEvent event) {
        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];
        tv_first.setText("X --->" + String.valueOf(x));
        tv_third.setText("Z --->" + String.valueOf(z));
        tv_second.setText("Y --->" + String.valueOf(y));


       /* float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        double acceleration = Math.sqrt(accelationSquareRoot);
        long actualTime = System.currentTimeMillis();
        graph2LastXValue += 1d;
        series.appendData(new GraphView.GraphViewData(graph2LastXValue, acceleration), true, 10);
        addDataPoint(acceleration);*/


        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = event.timestamp;
        if (accelationSquareRoot >= 2) //
        {
            if (actualTime - lastUpdate < 200) {
                return;
            }
            lastUpdate = actualTime;
            Toast.makeText(this, "Device ", Toast.LENGTH_SHORT)
                    .show();
            if (color) {
                view.setBackgroundColor(Color.GREEN);
            } else {
                view.setBackgroundColor(Color.RED);
            }
            color = !color;
        }

        linearGraphSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(x, y)
        });
        graph.addSeries(linearGraphSeries);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    private void addDataPoint(double acceleration) {
        dataPoints[499] = acceleration;
        //To change body of created methods use File | Settings | File Templates.
    }

}
