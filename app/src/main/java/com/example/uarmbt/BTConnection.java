package com.example.uarmbt;

import android.os.Handler;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;


public class BTConnection {
        private static BTConnection connectionObj;

        private Handler mHandler;



        public BTConnection() {
            //constructor
        }

        public static BTConnection getInstance() {
            if(connectionObj == null) {
                connectionObj = new BTConnection();
            }
            return connectionObj;
        }


        public void setHandler(Handler handler) {
            mHandler = handler;
        }

    BluetoothAdapter mBTAdapter = BluetoothAdapter.getDefaultAdapter();



}
