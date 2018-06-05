package com.dev.quintest.bluetooth;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by srikanthbandi on 31/07/16.
 */
public class DeviceAutoConnectService extends Service {
    private boolean isRunning  = false;
    Handler mHandler=new Handler();

    @Override
    public void onCreate() {
        super.onCreate();
        isRunning = true;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getBaseContext(),"Service Connected", Toast.LENGTH_SHORT).show();
        Log.i("", "Service onStartCommand");

        //Creating new thread for my service
        //Always write your long running tasks in a separate thread, to avoid ANR
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//                //Your logic that service will perform will be placed here
//                //In this example we are just looping and waits for 1000 milliseconds in each loop.
//                for (int i = 0; i < 5; i++) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//                    }
//
//                    if(isRunning){
//                        Log.i("onStartCommand ", "Service running");
//                        Toast.makeText(getBaseContext(),"Service Connected",Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                //Stop service once it finishes its task
//                stopSelf();
          //  }


        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        Toast.makeText(getBaseContext(),"Service DisConnected", Toast.LENGTH_SHORT).show();
    }
}
