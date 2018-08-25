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
import android.widget.Button;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GrafActivity extends AppCompatActivity implements SensorEventListener {
//    private SensorManager mSensorManager;
//    Sensor sensor;
//    GraphView graph;
//    private double graph2LastXValue = 5d;
//    private double graph2LastYValue = 5d;
//    private double graph2LastZValue = 5d;
//    private Double[] dataPoints;
//    LineGraphSeries<DataPoint> series;
//    LineGraphSeries<DataPoint> seriesX;
//    LineGraphSeries<DataPoint> seriesZ;
//    private Thread thread;
//    private boolean plotData = true;
//    FloatingActionButton floatingActionButton;
//    private boolean graficflag=true;
//
//
//    private float On_1 = 1;
//    private float altha = 0.05f;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_graf);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buttonClick();
//            }
////                if(graficflag==true){
////                graficflag=false;
////            }
////            else {graficflag=false;}}
//        });
//
//        Bundle extras=getIntent().getExtras();
//        if(extras!=null)
//        {
//          System.out.println(extras.getInt("sensortype"));
//        }
//        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        sensor=mSensorManager.getDefaultSensor(extras.getInt("sensortype"));
//        System.out.println(sensor);
//        graph=(GraphView)findViewById(R.id.graph);
//        series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 0),
//        });
//        series.setColor(Color.GREEN);
//
//        seriesX=new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(0, 0),
//
//        });
//        seriesX.setColor(Color.BLACK);
//
//        seriesZ=new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(0,0),
//        });
//        seriesZ.setColor(Color.RED);
//        if(graficflag) {
//            graph.addSeries(seriesX);
//            graph.addSeries(series);
//            graph.addSeries(seriesZ);
//        }
//            graph.getViewport().setXAxisBoundsManual(true);
//            graph.getViewport().setMinX(0);
//            graph.getViewport().setMaxX(20);
//            feedMultiple();
//
//    }
//    public void addEntry(SensorEvent event) {
//        /*     LineGraphSeries<DataPoint> series = new LineGraphSeries<>();*/
//        float[] values = event.values;
//        // Movement
//        float x = values[0];
//        System.out.println(x);
//        float y = values[1];
//        System.out.println(y);
//        float z = values[2];
//        System.out.println(z);
//
//
//        graph2LastXValue += 1d;
//        graph2LastYValue += 1d;
//        graph2LastZValue += 1d;
//        series.appendData(new DataPoint(graph2LastYValue, y), true, 20);
//
//        seriesX.appendData(new DataPoint(graph2LastXValue, x), true, 20);
//        seriesZ.appendData(new DataPoint(graph2LastZValue, z), true, 20);
//        if (graficflag) {
//            graph.addSeries(series);
//            graph.addSeries(seriesX);
//            graph.addSeries(seriesZ);
//        }
//
//
////        /*добавление фильтра
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(x, y),
//        });
//        graph.addSeries(series);
//    }
//
//
//
//
//
//
//        /*float accelationSquareRoot = (x * x + y * y + z * z)
//                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
//        double acceleration = Math.sqrt(accelationSquareRoot);
//        long actualTime = System.currentTimeMillis();
//        graph2LastXValue += 1d;
//        series.appendData(new GraphView(accelationSquareRoot,));
//        addDataPoint(acceleration);
//*/
////    }
//
//    public void addEntry1(SensorEvent event) {
//        /*     LineGraphSeries<DataPoint> series = new LineGraphSeries<>();*/
//        float[] values = event.values;
//        // Movement
//        float x = values[0];
//        System.out.println(x);
//        float y = values[1];
//        System.out.println(y);
//        float z = values[2];
//        System.out.println(z);
////        float filtrx=(float)(On_1+ altha*(x-On_1));
//        float filtrx=(float)(x*3);
//        float filtry=(float)(On_1+ altha*(y-On_1));
//        float filtrz=(float)(On_1+ altha*(z-On_1));
//
//
//        graph2LastXValue += 1d;
//        graph2LastYValue += 1d;
//        graph2LastZValue += 1d;
//        series.appendData(new DataPoint(graph2LastYValue, y), true, 20);
//
//        seriesX.appendData(new DataPoint(graph2LastXValue, x), true, 20);
//        seriesZ.appendData(new DataPoint(graph2LastZValue, z), true, 20);
//
//            graph.addSeries(series);
//            graph.addSeries(seriesX);
//            graph.addSeries(seriesZ);
//
//    }
//    private void addDataPoint(double acceleration) {
//        dataPoints[499] = acceleration;
//        //To change body of created methods use File | Settings | File Templates.
//    }
//
//    private void feedMultiple() {
//
//        if (thread != null){
//            thread.interrupt();
//        }
//
//        thread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true){
//                    plotData = true;
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        thread.start();
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (thread != null) {
//            thread.interrupt();
//        }
//        mSensorManager.unregisterListener(this);
//
//    }
//
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        if(plotData){
//            addEntry(event);
//            addEntry1(event);
//
//
//            plotData = false;
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
//    }
//
//    @Override
//    protected void onDestroy() {
//        mSensorManager.unregisterListener(GrafActivity.this);
//        thread.interrupt();
//        super.onDestroy();
//    }
//
//    private void  buttonClick(){
////        mSensorManager.unregisterListener(GrafActivity.this);
////        thread.interrupt();
//       if (graficflag){
////            plotData = true;
//            mSensorManager.unregisterListener(GrafActivity.this);
//           graficflag=false;
//        }
//        else {
//           mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
//       }
//    }
//}
//--------2 вариант
//    private SensorManager mSensorManager;
//    Sensor sensor;
//    GraphView graph;
//    private double graph2LastXValue = 5d;
//    private double graph2LastYValue = 5d;
//    private double graph2LastZValue = 5d;
//    private Double[] dataPoints;
//    LineGraphSeries<DataPoint> series;
//    LineGraphSeries<DataPoint> seriesX;
//    LineGraphSeries<DataPoint> seriesZ;
//    private Thread thread;
//    private boolean plotData = true;
//    FloatingActionButton floatingActionButton;
//    private boolean graficflag=true;
//
//
//    private float On_1 = 1;
//    private float altha = 0.05f;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_graf);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        floatingActionButton=(FloatingActionButton)findViewById(R.id.fab);
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buttonClick();
//            }
////                if(graficflag==true){
////                graficflag=false;
////            }
////            else {graficflag=false;}}
//        });
//
//        Bundle extras=getIntent().getExtras();
//        if(extras!=null)
//        {
//            System.out.println(extras.getInt("sensortype"));
//        }
//        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        sensor=mSensorManager.getDefaultSensor(extras.getInt("sensortype"));
//        System.out.println(sensor);
//        graph=(GraphView)findViewById(R.id.graph);
//        series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 0),
//        });
//        series.setColor(Color.GREEN);
//
//        seriesX=new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(0, 0),
//
//        });
//        seriesX.setColor(Color.BLACK);
//
//        seriesZ=new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(0,0),
//        });
//        seriesZ.setColor(Color.RED);
//
//        graph.addSeries(seriesX);
//        graph.addSeries(series);
//        graph.addSeries(seriesZ);
//
//        graph.getViewport().setXAxisBoundsManual(true);
//        graph.getViewport().setMinX(0);
//        graph.getViewport().setMaxX(20);
//
//        feedMultiple();
//
//    }
//    public void addEntry(SensorEvent event) {
//        /*     LineGraphSeries<DataPoint> series = new LineGraphSeries<>();*/
//        float[] values = event.values;
//        // Movement
//        float x = values[0];
//        System.out.println(x);
//        float y = values[1];
//        System.out.println(y)
//        ;
//        float z = values[2];
//        System.out.println(z);
//
//
//        graph2LastXValue += 1d;
//        graph2LastYValue += 1d;
//        graph2LastZValue += 1d;
//        series.appendData(new DataPoint(graph2LastYValue, y), true, 20);
//
//        seriesX.appendData(new DataPoint(graph2LastXValue, x), true, 20);
//        seriesZ.appendData(new DataPoint(graph2LastZValue, z), true, 20);
//
//        graph.addSeries(series);
//        graph.addSeries(seriesX);
//        graph.addSeries(seriesZ);
//
//
//
////        /*добавление фильтра
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(x, y),
//        });
//        graph.addSeries(series);
//    }
//
//
//    public void addEntry1(SensorEvent event) {
//        /*     LineGraphSeries<DataPoint> series = new LineGraphSeries<>();*/
//        float[] values = event.values;
//        // Movement
//        float x = values[0];
//        System.out.println(x);
//        float y = values[1];
//        System.out.println(y)
//        ;
//        float z = values[2];
//        System.out.println(z);
////        float filtrx=(float)(On_1+ altha*(x-On_1));
//        float filtrx=(float)(x*3);
//        float filtry=(float)(On_1+ altha*(y-On_1));
//        float filtrz=(float)(On_1+ altha*(z-On_1));
//
//
//        graph2LastXValue += 1d;
//        graph2LastYValue += 1d;
//        graph2LastZValue += 1d;
//        series.appendData(new DataPoint(graph2LastYValue, y), true, 20);
//
//        seriesX.appendData(new DataPoint(graph2LastXValue, x), true, 20);
//        seriesZ.appendData(new DataPoint(graph2LastZValue, z), true, 20);
//
//        graph.addSeries(series);
//        graph.addSeries(seriesX);
//        graph.addSeries(seriesZ);
//
//    }
//    private void addDataPoint(double acceleration) {
//        dataPoints[499] = acceleration;
//        //To change body of created methods use File | Settings | File Templates.
//    }
//
//    private void feedMultiple() {
//
//        if (thread != null){
//            thread.interrupt();
//        }
//
//        thread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (true){
//                    plotData = true;
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        thread.start();
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (thread != null) {
//            thread.interrupt();
//        }
//        mSensorManager.unregisterListener(this);
//
//    }
//
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        if(plotData){
//            if (graficflag) {
//                addEntry(event);
//                plotData = false;
//            }
//            else{
//                addEntry1(event);
//                plotData = false;}
//
//
//
//        }
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
//    }
//
//    @Override
//    protected void onDestroy() {
//        mSensorManager.unregisterListener(GrafActivity.this);
//        thread.interrupt();
//        super.onDestroy();
//    }
//
//    private void  buttonClick(){
//
//        if (graficflag){
//            graficflag=false;
//        }
//        else {
//            graficflag=true;
//        }
//    }
//}
///------3 вариант
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
        LineGraphSeries<DataPoint> seriesXX;
        LineGraphSeries<DataPoint> seriesYY;
        LineGraphSeries<DataPoint> seriesZZ;
        private Thread thread;
        private boolean plotData = true;
        FloatingActionButton floatingActionButton;
        private boolean graficflag = false;

        float xx;
        float yy;
        float zz;

        private float On_1 = 1;
        private float altha = 0.05f;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_graf);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClick();
                }
// if(graficflag==true){
// graficflag=false;
// }
// else {graficflag=false;}}
            });

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                System.out.println(extras.getInt("sensortype"));
            }
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            sensor = mSensorManager.getDefaultSensor(extras.getInt("sensortype"));
            System.out.println(sensor);
            graph = (GraphView) findViewById(R.id.graph);

            series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(0, 0),
            });
            series.setColor(Color.GREEN);


            seriesX = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(0, 0),

            });
            seriesX.setColor(Color.BLACK);


            seriesZ = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(0, 0),
            });
            seriesZ.setColor(Color.RED);

            graph = (GraphView) findViewById(R.id.graph);
            series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(0, 0),
            });
            series.setColor(Color.BLUE);

            seriesXX = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(0, 0),

            });
            seriesXX.setColor(Color.YELLOW);

            seriesZZ = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(0, 0),
            });
            seriesZZ.setColor(Color.LTGRAY);


            seriesYY=new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0,0),
            });
            seriesYY.setColor(Color.MAGENTA);


            graph.addSeries(seriesXX);
            graph.addSeries(seriesYY);
            graph.addSeries(seriesZZ);
            graph.addSeries(seriesX);
            graph.addSeries(series);
            graph.addSeries(seriesZ);

            graph.getViewport().setXAxisBoundsManual(true);
            graph.getViewport().setMinX(0);
            graph.getViewport().setMaxX(20);

            feedMultiple();

        }

        public void addEntry(SensorEvent event) {
            /* LineGraphSeries<DataPoint> series = new LineGraphSeries<>();*/
            float[] values = event.values;

            float x = values[0];
            System.out.println(x);
            float y = values[1];
            System.out.println(y);
            float z = values[2];
            System.out.println(z);

            float xx=0;
            float yy=0;
            float zz=0;



            graph2LastXValue += 1d;
            graph2LastYValue += 1d;
            graph2LastZValue += 1d;

                xx = (float) (On_1 + altha * (x - On_1));
                yy = (float) (On_1 + altha * (y - On_1));
                zz = (float) (On_1 + altha * (z - On_1));
                seriesXX.appendData(new DataPoint(graph2LastXValue,xx), true,20);
             seriesYY.appendData(new DataPoint(graph2LastYValue,yy), true,20);
                seriesZZ.appendData(new DataPoint(graph2LastZValue,zz), true,20);

            series.appendData(new DataPoint(graph2LastYValue, y), true, 20);
            seriesX.appendData(new DataPoint(graph2LastXValue, x), true, 20);
            seriesZ.appendData(new DataPoint(graph2LastZValue, z), true, 20);




            graph.addSeries(series);
            graph.addSeries(seriesX);
            graph.addSeries(seriesZ);
//            graph.addSeries(seriesXX);
//            graph.addSeries(seriesYY);
//            graph.addSeries(seriesZZ);

            if (!graficflag) {
                graph.removeSeries(seriesXX);
            graph.removeSeries(seriesYY);
                graph.removeSeries(seriesZZ);
            }
            else {
                graph.addSeries(seriesXX);
            graph.addSeries(seriesYY);
            graph.addSeries(seriesZZ);

            }



// /*добавление фильтра
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                    new DataPoint(x, y),
            });
            graph.addSeries(series);
        }


        private void addDataPoint(double acceleration) {
            dataPoints[499] = acceleration;
//To change body of created methods use File | Settings | File Templates.
        }

        private void feedMultiple() {

            if (thread != null) {
                thread.interrupt();
            }

            thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        plotData = true;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
// TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            });

            thread.start();
        }

        @Override
        protected void onPause() {
            super.onPause();

            if (thread != null) {
                thread.interrupt();
            }
            mSensorManager.unregisterListener(this);

        }


        @Override
        public void onSensorChanged(SensorEvent event) {
            if (plotData) {

                addEntry(event);
                plotData = false;


            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

        @Override
        protected void onResume() {
            super.onResume();
            mSensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
        }

        @Override
        protected void onDestroy() {
            mSensorManager.unregisterListener(GrafActivity.this);
            thread.interrupt();
            super.onDestroy();
        }

        private void buttonClick() {
            graficflag = !graficflag;
        }
    }
