package com.sanchez.leonardo.foods_launch_others;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class facturar extends AppCompatActivity {


    private ArrayList<ArrayList<String>> factura;
    private ArrayList<String> row;
    private ArrayList<String> array;
    Double Total;
    int valor_a_pagar=0;
    Double iva;
    private Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturar);

        Intent i=getIntent();
        Bundle extras = i.getExtras();

        if (extras.containsKey("factura"))
        {
            this.factura=(ArrayList<ArrayList<String>>) i.getSerializableExtra("factura");
            System.out.println("factura recepcionada");
            System.out.println(this.factura);
        }

        array = new ArrayList<String>();
        for (int it = 1; it < factura.size(); it++)
        {
            row = factura.get(it);
            array.add(row.toString());

            System.out.println(row.get(1));
            valor_a_pagar+=Integer.parseInt((row.get(1)));

        }

        //set value to paid
        //subtotal

        //iva
        final TextView ivatxt=(TextView) findViewById(R.id.textView16);
        //subtotal
        final TextView subtotal=(TextView) findViewById(R.id.textView6);
        //total
        final TextView paid=(TextView) findViewById(R.id.textView7);


        //setting
        iva=iva_calc(valor_a_pagar);
        Total=valor_a_pagar+iva;
        ivatxt.setText("$"+iva);
        subtotal.setText("$"+valor_a_pagar);
        paid.setText("$"+Total);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        ListView myListView = (ListView) findViewById(R.id.lista_pagar);
        myListView.setAdapter(adapter);

        //clic list factura
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                //System.out.println(position);
                //System.out.println(factura);
                //System.out.println("factura"+factura.get(position));
                factura.remove(position+1);
                String row2 = array.get(position);
                array.remove(position);
                System.out.println("factura"+factura);
                System.out.println("array"+array);
                Toast.makeText(context,"borraste de la lista a "+row2,Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                //recalcular valor de la factura
                valor_a_pagar=0;
                if(factura.size()>1)
                {
                    for (int it = 1; it < factura.size(); it++)
                    {
                        System.out.println("dejado"+row);
                        row = factura.get(it);
                        valor_a_pagar+=Integer.parseInt((row.get(1)));

                        //setting
                        iva=iva_calc(valor_a_pagar);
                        Total=valor_a_pagar+iva;
                        ivatxt.setText("$"+iva);
                        subtotal.setText("$"+valor_a_pagar);
                        paid.setText("$"+Total);
                    }
                }
                else
                    {
                        subtotal.setText("¯\\_(⊙︿⊙)_/¯");
                        ivatxt.setText("¯\\_(⊙︿⊙)_/¯");
                        paid.setText("¯\\_(⊙︿⊙)_/¯");
                    }
            }
        });

    }


    public void Restart(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void end(View v)
    {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void wait_waitter(View v)
    {
        Dialog settingsDialog = new Dialog(this);
        settingsDialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        settingsDialog.setContentView(getLayoutInflater().inflate(R.layout.waiter,null));
        settingsDialog.show();
    }

    @Override
    public void onBackPressed() {
        // your code.
        Intent i= new  Intent(this,Main2Activity.class);
        factura=new ArrayList<ArrayList<String>>();
        factura.add(new ArrayList<String>(Arrays.asList("title","values")));
        i.putExtra("factura", this.factura);
        System.out.println(this.factura);
        startActivity(i);
    }

    public Double iva_calc(int total)
    {
        return  total*0.19;
    }
}
