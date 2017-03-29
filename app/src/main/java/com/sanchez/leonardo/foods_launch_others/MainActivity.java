package com.sanchez.leonardo.foods_launch_others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
    }

    public void pass_to_restaurant(View v)
    {
        Intent i= new  Intent(this,Main2Activity.class);
        startActivity(i);
    }
}
