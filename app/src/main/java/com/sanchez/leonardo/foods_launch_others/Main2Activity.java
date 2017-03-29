package com.sanchez.leonardo.foods_launch_others;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;

import static android.R.attr.data;

public class Main2Activity extends AppCompatActivity {

    ArrayList<ArrayList<String>> factura;

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //add items
        i=getIntent();
        Bundle extras = i.getExtras();
        if (extras != null)
        {
            System.out.println("es recibida");
            factura = (ArrayList<ArrayList<String>>) i.getSerializableExtra("factura");
            System.out.println(factura);

        }
        if (factura==null)
        {
            System.out.println("es null");
            factura=new ArrayList<ArrayList<String>>();
            factura.add(new ArrayList<String>(Arrays.asList("title","values")));
            System.out.println(factura);
        }

    }

    public void pass_to_food(View v)
    {
        Intent i= new  Intent(this,Food.class);
        i.putExtra("food","meals");
        i.putExtra("factura", factura);
        startActivity(i);
    }
    public void pass_to_drinks(View v)
    {
        Intent i= new  Intent(this,Food.class);
        i.putExtra("food","drinks");
        // Get the extras (if there are any)
        Bundle extras = i.getExtras();
        if (extras != null)
        {
            i.putExtra("factura", factura);
        }
        startActivity(i);
    }
    public void pass_to_desserts(View v)
    {
        Intent i= new  Intent(this,Food.class);
        i.putExtra("food","deserts");
        // Get the extras (if there are any)
        Bundle extras = i.getExtras();
        if (extras != null)
        {
            i.putExtra("factura", factura);
        }
        startActivity(i);
    }
    public void pass_to_buy(View v)
    {

        System.out.println(factura);
        Intent i= new  Intent(this,facturar.class);
        i.putExtra("factura", factura);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        // your code.
        Intent i= new  Intent(this,MainActivity.class);
        System.out.println(this.factura);
        startActivity(i);
    }
}
