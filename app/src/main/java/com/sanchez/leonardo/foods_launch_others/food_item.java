package com.sanchez.leonardo.foods_launch_others;

/**
 * Created by brayhancriollo on 8/19/16.
  credits to this man
 */
/**
 * Created by etnad on 23/03/2017.
 */


public class food_item {

    private String nombre;
    private String precio;
    private int foto;

    public food_item (int foto, String nombre, String precio){
        this.foto       = foto;
        this.nombre     = nombre;
        this.precio    = precio;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getRanking() {return precio;}
    public void setRanking(String precio) {this.precio= precio;}

    public int getFoto() {return foto;}
    public void setFoto(int foto) {this.foto = foto;}
}
