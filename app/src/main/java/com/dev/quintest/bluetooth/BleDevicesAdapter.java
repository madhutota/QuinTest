package com.dev.quintest.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.quintest.R;

import java.util.ArrayList;
import java.util.HashMap;

public class BleDevicesAdapter extends BaseAdapter {
    private final LayoutInflater inflater;
    private Context mContext;

    private final ArrayList<BluetoothDevice> leDevices;
    private final HashMap<BluetoothDevice,Integer> rssiMap = new HashMap<>();

    public BleDevicesAdapter(Context context) {
        leDevices = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        mContext = context;
    }

    public void addDevice(BluetoothDevice device, int rssi) {
        if (!leDevices.contains(device)) {
            leDevices.add(device);
        }
        rssiMap.put(device, rssi);
    }

    public BluetoothDevice getDevice(int position) {
        return leDevices.get(position);
    }

    public void clear() {
        leDevices.clear();
    }

    @Override
    public int getCount() {
        return leDevices.size();
    }

    @Override
    public Object getItem(int i) {
        return leDevices.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        // General ListView optimization code.
        if (view == null) {
            view = inflater.inflate(R.layout.row_item_device, null);
            viewHolder = new ViewHolder();
            viewHolder.txt_dialog_device_address = (TextView) view.findViewById(R.id.txt_dialog_device_address);
            viewHolder.txt_dialog_device_name = (TextView) view.findViewById(R.id.txt_dialog_device_name);
            viewHolder.txt_dialog_heart_connected = (TextView) view.findViewById(R.id.txt_dialog_heart_connected);
            viewHolder.txt_dialog_heart_connected.setTypeface(Utility.setTypeFace_fontawesome(mContext));
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        BluetoothDevice device = leDevices.get(i);
        final String deviceName = device.getName();
        if (deviceName != null && deviceName.length() > 0) {
            viewHolder.txt_dialog_device_name.setText(deviceName);
        }
        else {
            viewHolder.txt_dialog_device_name.setText(R.string.unknown_device);
        }
        viewHolder.txt_dialog_device_address.setText(device.getAddress());
        viewHolder.txt_dialog_heart_connected.setTextColor(ContextCompat.getColor(mContext,R.color.colorPrimary));
        //viewHolder.txt_dialog_heart_connected.setText("");

        return view;

    }

    private static class ViewHolder {
        TextView txt_dialog_device_name;
        TextView txt_dialog_device_address;
        TextView txt_dialog_heart_connected;
    }
}
