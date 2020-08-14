package com.example.arccontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;


import java.util.Set;


public class MainActivity extends AppCompatActivity {
    Button connect;
    BluetoothAdapter Ba;
    //static final UUID sUUID=UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_main);
        connect=(Button)findViewById(R.id.connect);
/*        Ba=BluetoothAdapter.getDefaultAdapter();
        System.out.println(Ba.getBondedDevices());*/
        enalableBt();
        pairDevice();
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,MainActivity0.class);
                startActivity(i);
            }
        });
    }

    public void enalableBt(){
        Ba=BluetoothAdapter.getDefaultAdapter();
        if(Ba==null){
            Toast.makeText(getApplicationContext(),"Bluetooth Not Found",Toast.LENGTH_LONG).show();
        }
        else{
            if(!Ba.isEnabled()){
                Intent enableIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableIntent,1);
                }
            }
        }

    public void pairDevice(){
        Set<BluetoothDevice> devices=Ba.getBondedDevices();
            for(BluetoothDevice device:devices){
                String deviceName= device.getName();
                String deviceAddress=device.getAddress();
                System.out.println(deviceName+"\n"+deviceAddress);
        }
    }
}


