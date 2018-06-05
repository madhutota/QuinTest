package com.dev.quintest;

import android.bluetooth.BluetoothAdapter;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dev.quintest.bluetooth.BleDevicesAdapter;

import java.util.Scanner;

public class BluetoothActivity extends AppCompatActivity {
    private FloatingActionButton fab;

    public static BluetoothAdapter bluetoothAdapter;
    public static BleDevicesAdapter leDeviceListAdapter;
    public static Scanner scanner;
    public static boolean isScanning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
