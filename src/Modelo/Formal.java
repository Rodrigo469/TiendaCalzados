package Modelo;

import java.security.PublicKey;

public abstract class Formal extends Calzado{
    //Atributos
    protected  String color;
// Constructor
    public Formal(Producto producto, String diaVenta,
                  int numeroCalzado, String color) {
        super(producto, diaVenta, numeroCalzado);
        this.color = color;
    }
//Getters and Setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    //Métodos
    //impuestoEspecifico
    public int impuestoEspecifico(){
        return(int) Math.round(this.getProducto().getValorBase()*7.4*100);
    }

        public abstract int descuento();
}
