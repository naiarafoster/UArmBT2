package com.example.uarmbt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.util.UUID;
import java.util.ArrayList;


public class child_calibration extends AppCompatActivity {

    private ListView deviceList;
    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private ArrayAdapter arrayAdapter;
     Set<BluetoothDevice> PairedDevices;

    private final static int REQUEST_ENABLE_BT = 1; // used to identify adding bluetooth names

    BluetoothSPP bt = new BluetoothSPP(Context);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_calibration);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = (Button) findViewById(R.id.button_calibration);

        //capture button click
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start Main4Activity.class
                Intent myIntent = new Intent(child_calibration.this,
                        step1Activity.class);
                startActivity(myIntent);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_connect:
                // User chose the "Connect" item
                if (bluetoothAdapter == null) {
                    // Device does not support Bluetooth
                    Toast.makeText(getApplicationContext(),"Device does not support bluetooth!",Toast.LENGTH_SHORT).show();
                }
                if (!bluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
                    Toast.makeText(getApplicationContext(),"Bluetooth turned on",Toast.LENGTH_SHORT).show();
                   /* Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
                    ArrayList list = new ArrayList();
                    if(pairedDevices.size()>0){
                        for(BluetoothDevice device: pairedDevices){
                            String devicename = device.getName();
                            String macAddress = device.getAddress();
                            list.add("Name: "+devicename+"MAC Address: "+macAddress);
                        }
                        deviceList = (ListView) findViewById(R.id.deviceList);
                        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                        deviceList.setAdapter(arrayAdapter);
                    }*/
                }
                else {
                    Toast.makeText(getApplicationContext(),"Bluetooth already On",Toast.LENGTH_SHORT).show();

                }


                return true;

            case R.id.action_overflow:

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

   /* private void listPairedDevices(View view){
        PairedDevices = bluetoothAdapter.getBondedDevices();
        if(bluetoothAdapter.isEnabled()) {
            // put it's one to the adapter
            for (BluetoothDevice device : PairedDevices)
                BTArrayAdapter.add(device.getName() + "\n" + device.getAddress());

            Toast.makeText(getApplicationContext(), "Show Paired Devices", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Bluetooth not on", Toast.LENGTH_SHORT).show();
    }*/

}
