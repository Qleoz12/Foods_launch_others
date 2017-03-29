package com.sanchez.leonardo.foods_launch_others;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;

public class Food extends AppCompatActivity {


    ArrayList<food_item> foods_ArrayList;
    private RecyclerView lista_foods;
    //factura
    private ArrayList<ArrayList<String>> factura = new ArrayList<ArrayList<String>>();
    private Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food);


        lista_foods = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista_foods.setLayoutManager(llm);
        //
        i=getIntent();
        String foodType=i.getStringExtra("food");
        System.out.println(foodType);
        Bundle extras = i.getExtras();

            if (extras.containsKey("factura"))
            {
                this.factura=(ArrayList<ArrayList<String>>) i.getSerializableExtra("factura");
                System.out.println("factura recepcionada");
                System.out.println(this.factura);
            }


        if(foodType.equals("drinks"))
        {
            cargarfood_items_drinks();
            inicAdapter();
        }
        if(foodType.equals("deserts"))
        {
            cargarfood_items_desserts();
            inicAdapter();
        }
        if(foodType.equals("meals"))
        {
            cargarfood_items_foods();
            inicAdapter();
        }
        if(foodType.equals("buy"))
        {
            mostrar_factura();
        }

    }


    public void cargarfood_items_drinks(){

        foods_ArrayList = new ArrayList<food_item>();
        foods_ArrayList.add(new food_item(R.drawable.d_absolut, "Vodka Absolute", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_cappuccino, "capuccino", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_citrussolcocktail, "Citrus Sol Cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_cocktail, "Cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_water, "Mineral Water", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_starbucks_coffe, "Starbucks Cofee", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_drinkcarryall, "Soda", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_el_dorado_cocktail, "el dorado cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_fernet_daiquiri_cocktail, "Fernet-daiquiri-d_cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_hoedown_cocktail, "hoedown-d_cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_its_always_sunny_cocktail, "ts_always_sunny_cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_jpcollinscocktail, "d_jpcollinscocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_tea, "Tea", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_skyebird, "Lemonade", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_summer_brew_cocktail, "summer_brew_cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_summer_mint_meadow_cocktail, "summer_mint_meadow_cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_tailor_made_punch_cocktail, "tailor-made-punch-d_cocktail", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_thirsty_1x, "Wine", "5000"));
        foods_ArrayList.add(new food_item(R.drawable.d_van_goghs_garden_cocktail, "van-goghs-garden-d_cocktail", "5000"));





    }
    public void cargarfood_items_desserts(){

        foods_ArrayList = new ArrayList<food_item>();
        foods_ArrayList.add(new food_item(R.drawable.desert_black_prince, "black_prince", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.desert_donut, "Desert Donouts", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.desert_fruit, "Tropical Fruits", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.desert_ice_cream, "Ice Cream (Speciality)", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.desert_jelly_cake, "Jelly Cake", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.desert_oreo, "Oreo Biscuits", "20000"));
    }

    public void cargarfood_items_foods(){
        foods_ArrayList = new ArrayList<food_item>();
        foods_ArrayList.add(new food_item(R.drawable.food_abalon_en_lecho_de_lechuga, "abalon_en_lecho_de_lechuga", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_chow_mein, "food_chow_mein", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_dim_sum_china, "food_dim_sum_china", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_makbus, "food_makbus", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_shahe_fen, "food_shahe_fen", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_siew_yokh, "food_siew_yokh", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_sopa_de_aleta_de_tiburon, "food_sopa_de_aleta_de_tiburon", "20000"));
        foods_ArrayList.add(new food_item(R.drawable.food_egg, "Simple Egg", "1500"));
        foods_ArrayList.add(new food_item(R.drawable.food_egg_with_toast, "Simple egg with Toast", "3000"));
        foods_ArrayList.add(new food_item(R.drawable.food_double_eggs, "Double Egg", "2000"));
        foods_ArrayList.add(new food_item(R.drawable.food_house_doublecheeese, "House Double Cheese", "7500"));
        foods_ArrayList.add(new food_item(R.drawable.food_house_pizza, "House Pizza", "2500"));
        foods_ArrayList.add(new food_item(R.drawable.cute_burrito, "House Burritos", "7500"));
        foods_ArrayList.add(new food_item(R.drawable.food_zongzi, "Chinese Zongzi", "12500"));
        foods_ArrayList.add(new food_item(R.drawable.food_dougioedog, "Dougioe Dog(Hot dog Dragon |Canada|)", "290905"));


    }

    public void inicAdapter(){
        food_itemAdaptador adp = new food_itemAdaptador(foods_ArrayList,this,this.factura);
        lista_foods.setAdapter(adp);
    }

    public void mostrar_factura(){
        System.out.println(this.factura);
    }

    @Override
    public void onBackPressed() {
        // your code.
        Intent i= new  Intent(this,Main2Activity.class);

        i.putExtra("factura", this.factura);
        System.out.println(this.factura);
        startActivity(i);
    }


}
