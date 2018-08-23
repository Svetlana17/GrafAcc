package com.example.user.grafacc;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GrafActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    Sensor sensor;
    GraphView graph;
    private double graph2LastXValue = 5d;
    private double graph2LastYValue = 5d;
    private double graph2LastZValue = 5d;
    private Double[] dataPoints;
    LineGraphSeries<DataPoint> series;
    LineGraphSeries<DataPoint> seriesX;
    LineGraphSeries<DataPoint> seriesZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graf);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
          System.out.println(extras.getInt("sensortype"));
        }
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor=mSensorManager.getDefaultSensor(extras.getInt("sensortype"));
        System.out.println(sensor);
        graph=(GraphView)findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 0),
        });
        series.setColor(Color.GREEN);

        seriesX=new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, 0),

        });
        seriesX.setColor(Color.BLACK);

        seriesZ=new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0,0),
        });
        seriesZ.setColor(Color.RED);

        graph.addSeries(seriesX);
        graph.addSeries(series);
        graph.addSeries(seriesZ);

        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(20);
        
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
