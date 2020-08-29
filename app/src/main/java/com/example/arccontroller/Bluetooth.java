package com.example.arccontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class Bluetooth extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    ListView listView;
    TextView textView;
    Button connect;
    String SelectedID;
    String check="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        ArrayList arrayList = new ArrayList();
        textView=(TextView)findViewById(R.id.selectedMac);
        int i = 0;
        for (BluetoothDevice device : pairedDevices) {
            String devicename = device.getName();
            String address = device.getAddress();
            arrayList.add("Name: " + devicename + "\nMAC address : " + address);
        }

        listView = (ListView) findViewById(R.id.mac);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str=(String)listView.getItemAtPosition(i);
                String sep="MAC address : ";
                int sepPos=str.indexOf(sep);
                if(sepPos==-1){
                    System.out.println(" ");
                }
                SelectedID=str.substring(sepPos+sep.length());
                textView.setText((String) listView.getItemAtPosition(i));
                System.out.println(SelectedID);
                check="Go";
            }
        });
        connect=(Button)findViewById(R.id.button);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity0.address=SelectedID;
                if(check=="Go") {
                    Intent i = new Intent(Bluetooth.this, MainActivity0.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Select Device from above List",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}