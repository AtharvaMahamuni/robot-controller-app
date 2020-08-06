package com.example.arccontroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
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

        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("IMAGE","motion event:"+event.toString());
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        up.setImageResource(R.drawable.ic_arrow_drop_up_faint);
                        return true;
                    }
                    case MotionEvent.ACTION_UP:{
                        up.setImageResource(R.drawable.ic_arrow_drop_up);
                        return true;
                    }
                }
                return false;
            }
        });


        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("IMAGE","motion event:"+event.toString());
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        down.setImageResource(R.drawable.ic_arrow_drop_down_faint);
                        return true;
                    }
                    case MotionEvent.ACTION_UP:{
                        down.setImageResource(R.drawable.ic_arrow_drop_down);
                        return true;
                    }
                }
                return false;
            }
        });


        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("IMAGE","motion event:"+event.toString());
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        left.setImageResource(R.drawable.ic_arrow_drop_left_faint);
                        return true;
                    }
                    case MotionEvent.ACTION_UP:{
                        left.setImageResource(R.drawable.ic_chevron_left_48px);
                        return true;
                    }
                }
                return false;
            }
        });


        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("IMAGE","motion event:"+event.toString());
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN: {
                        right.setImageResource(R.drawable.ic_arrow_drop_right_faint);
                        return true;
                    }
                    case MotionEvent.ACTION_UP:{
                        right.setImageResource(R.drawable.ic_chevron_right);
                        return true;
                    }
                }
                return false;
            }
        });
    }

}