package com.sanchez.leonardo.foods_launch_others;

/**
 * Created by brayhancriollo on 8/19/16.
 * credits for this man/
/**
 * Created by etnad on 23/03/2017.
 */

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.common.util.UriUtil;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class food_itemAdaptador  extends RecyclerView.Adapter<food_itemAdaptador.food_ViewHolder>{

    ArrayList<food_item> foods_ArrayList;
    Activity activity;
    public int a;
    ArrayList<ArrayList<String>> twoDim;


    public food_itemAdaptador(ArrayList<food_item> foods_ArrayList, Activity activity, ArrayList<ArrayList<String>> twoDim ){
        this.foods_ArrayList = foods_ArrayList;
        this.activity = activity;
        this.twoDim=twoDim;
    }

    @Override
    public food_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row, parent, false);
        return new food_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(food_ViewHolder holder, int position) {
        final food_item food = foods_ArrayList.get(position);
        Uri uri = Uri.parse("res:///" +food.getFoto());
        // uri looks like res:/123456789
        //holder.imFoto_food.set
        holder.imFoto_food.setImageURI(uri);
        holder.tvNombre_food.setText(food.getNombre());
        holder.tvprecio_food.setText(food.getRanking());

        holder.imFoto_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Mascota llamada "+food.getNombre(),
                        Toast.LENGTH_LONG).show();
            }});

        holder.lyot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, " compraste  "+food.getNombre()
                                +" de costo "+food.getRanking(),
                        Toast.LENGTH_LONG).show();

                twoDim.add(new ArrayList<String>(Arrays.asList(food.getNombre(),food.getRanking())));
                System.out.println(twoDim);
            }});


    }

    @Override
    public int getItemCount() {
        return foods_ArrayList.size();
    }


    public static class food_ViewHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView imFoto_food;
        private TextView tvNombre_food;
        private TextView tvprecio_food;
        private RelativeLayout lyot;

        public food_ViewHolder(View itemView) {
            super(itemView);

            imFoto_food= (SimpleDraweeView) itemView.findViewById(R.id.my_image_view);
            tvNombre_food   = (TextView) itemView.findViewById(R.id.name);
            tvprecio_food     = (TextView) itemView.findViewById(R.id.txt_value);
            lyot=(RelativeLayout) itemView.findViewById(R.id.relativelayout);
        }
    }
}