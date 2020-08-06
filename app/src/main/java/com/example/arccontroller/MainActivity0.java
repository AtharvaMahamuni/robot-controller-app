package com.example.arccontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity0 extends AppCompatActivity {

    ImageView right, left, up, down;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main0);

        right = findViewById(R.id.right);
        left = findViewById(R.id.left);
        up = findViewById(R.id.up);
        down = findViewById(R.id.down);




    }

}